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
public class DataBase {

    static ArrayList<Books> authorsBooks = new ArrayList<>();
    static ArrayList<Books> bestbooks = new ArrayList<>();
    static ArrayList<Books> allbooks = new ArrayList<>();
    static ArrayList<String> publishers = new ArrayList<>();

    static ArrayList<BookstoreWorker> admin = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Order> ordersofCustomer = new ArrayList<>();
    static ArrayList<Order> allOrders = new ArrayList<>();
    static ArrayList<Order> selectedBooks = new ArrayList<>();
}
