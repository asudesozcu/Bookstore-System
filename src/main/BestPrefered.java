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
public class BestPrefered extends Books {

  
    
public BestPrefered(String title, String author, String publisher, int publishingYear, int ISBN, int stock, int edition, double price, double stars, BookType type) {
    super(title, author, publisher, publishingYear, ISBN,stock, edition, price, stars, type);
}

    

    /**
     *
     * @param book
     * @return
     */
    public static String getInfo(Books book) {
        return Books.getInfo(book)+"\nThis book is one of the best prefered books!"; 
    }

    

}
