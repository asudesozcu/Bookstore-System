/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstoreautomation;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sozcu
 */
public class Order {

     int orderNumber;
     Date orderDate;
     double totalPrice;
     Customer customer;
     ArrayList<Books> orderedBooks= new ArrayList();

    public Order() {
    }

     
    public Order(int orderNumber, Date orderDate, double totalPrice, Customer customer, ArrayList<Books> orderedBooks) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.orderedBooks = orderedBooks;
    }

    
     public void addBook(Books book) {
        getOrderedBooks().add(book);
    }
     
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * @param orderNumber the orderNumber to set
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the totalPrice
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the orderedBooks
     */
    public ArrayList<Books> getOrderedBooks() {
        return orderedBooks;
    }

    /**
     * @param orderedBooks the orderedBooks to set
     */
    public void setOrderedBooks(ArrayList<Books> orderedBooks) {
        this.orderedBooks = orderedBooks;
    }

  

}
