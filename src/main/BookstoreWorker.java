/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstoreautomation;

import java.util.ArrayList;

/**
 *
 * @author sozcu
 */
public class BookstoreWorker extends Person {

    public BookstoreWorker(String name, String surname, String email, String phone, String address, String password, Gender gender, int id) {
        super(name, surname, email, phone, address, password, gender, id);
        this.setAccountType(AccountType.ADMIN);
    }
    
    public static void addBook(Books book) {
        DataBase.allbooks.add(book);
        System.out.println("Book added: " + book.getName());
    }
    
    public static void deleteBook(Books book) {
        if (DataBase.allbooks.contains(book)) {
            DataBase.allbooks.remove(book);
            System.out.println("Book deleted: " + book.getName());
        } else {
            System.out.println("Book not found: " + book.getName());
        }
    }
    
    public static void updateBook(Books oldBook, Books newBook) {
        if (DataBase.allbooks.contains(oldBook)) {
            int index = DataBase.allbooks.indexOf(oldBook);
            DataBase.allbooks.set(index, newBook);
            System.out.println("Book updated: " + oldBook.getName());
        } else {
            System.out.println("Book not found: " + oldBook.getName());
        }
    }
    
    public static void stockUpdate(Books book, int newStock) {
        if (DataBase.allbooks.contains(book)) {
            int index = DataBase.allbooks.indexOf(book);
            Books updatedBook = DataBase.allbooks.get(index);
            updatedBook.setStock(newStock);
            System.out.println("Stock updated for book: " + book.getName());
        } else {
            System.out.println("Book not found: " + book.getName());
        }
    }
    
    public static void deleteCustomer(Customer customer) {
        if (DataBase.customers.contains(customer)) {
            DataBase.customers.remove(customer);
            System.out.println("Customer deleted: " + customer.getUsername());
        } else {
            System.out.println("Customer not found: " + customer.getUsername());
        }
    }
}
