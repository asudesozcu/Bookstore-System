/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstoreautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sozcu
 */
public class Customer extends Person {

    private int age;
    private String username;

    public Customer(String username, String name, String surname, String email, String phone, String address, String password, Gender gender, int id, int age) {
        super(name, surname, email, phone, address, password, gender, id);
        this.username = username;
        this.age = age;
        this.setAccountType(AccountType.CUSTOMER);
    }

    public Customer() {
    }

    public static void createCustomer(String username, String name, String surname, String email,
            String phone, String password, String address, Gender gender, int age,int id) {
        String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";

        try ( Connection connection = DriverManager.getConnection(url, "root", "root")) {
            // Check if the customer already exists in the database
            String checkCustomerSql = "SELECT COUNT(*) FROM customers WHERE username = ?";
            try ( PreparedStatement checkCustomerStatement = connection.prepareStatement(checkCustomerSql)) {
                checkCustomerStatement.setString(1, username);

                ResultSet resultSet = checkCustomerStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    // Customer already exists, show a warning message or handle as needed
                    System.out.println("This customer already exists in the database.");
                    return;
                }
            }

            // Customer does not exist, proceed with creating and inserting the new customer
                   Customer newCustomer = new Customer(username, name, surname, email, phone, address, password, gender, id, age);

            String insertCustomerSql = "INSERT INTO customers (id,name, surname, username, email, phone, password, address, gender, age) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try ( PreparedStatement insertCustomerStatement = connection.prepareStatement(insertCustomerSql)) {
                                insertCustomerStatement.setInt(1, newCustomer.getId());

                insertCustomerStatement.setString(2, newCustomer.getName());
                insertCustomerStatement.setString(3, newCustomer.getSurname());
                insertCustomerStatement.setString(4, newCustomer.getUsername());
                insertCustomerStatement.setString(5, newCustomer.getEmail());
                insertCustomerStatement.setString(6, newCustomer.getPhone());
                insertCustomerStatement.setString(7, newCustomer.getPassword());
                insertCustomerStatement.setString(8, newCustomer.getAddress());
                insertCustomerStatement.setString(9, newCustomer.getGender().toString());
                insertCustomerStatement.setInt(10, newCustomer.getAge());

                insertCustomerStatement.executeUpdate();

                // Add the customer to the customers list only if it was successfully inserted
                DataBase.customers.add(newCustomer);
                System.out.println("Customer created and added to the database successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getter and Setter 
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInfo(Customer customer) {
        return "Username: " + customer.getUsername()
                + "\n" + super.getInfo(customer);
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

}
