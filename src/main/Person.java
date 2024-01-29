/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstoreautomation;

/**
 *
 * @author sozcu
 */
public class Person {

    Person temp;

    /**
     * @return the accountType
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    private String name;
    private String surname;
    private String email;

    private String phone;
    private String address;
    private String password;
    private Gender gender;
    private AccountType accountType;
    private int id;

    public enum AccountType {

        CUSTOMER,
        ADMIN
    }

    public enum Gender {
        MALE,
        FEMALE,
        NOTPREFERED
    }

    public Person() {
    }

    public Person(String name, String surname, String email, String phone, String address, String password, Gender gender, int id) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.gender = gender;
        this.id = id;
    }

    public static String getInfo(Person person) {
        return "Name: " + person.getName()
                + "\nSurname: " + person.getSurname()
                + "\nEmail: " + person.getEmail()
                + "\nPhone: " + person.getPhone()
                + "\nAddress: " + person.getAddress()
                + "\nGender: " + person.getGender()
                + "\nPassword: " + person.getPassword();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
