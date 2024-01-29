/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.bookstoreautomation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sozcu
 */
public class Books {

    private String name;
    private String author;
    private String publisher;
    private int publishingYear;
    private int ISBN;
    private int stock;
    private int edition;
    private double price;
    private double stars;
    private BookType type;

    void setStock(int newStock) {
        this.stock = newStock;
    }

    public static enum BookType {
        NOVEL,
        POETRY,
        SCIENCE_FICTION,
        HISTORY,
        BIOGRAPHY,
        EDUCATION,
        CHILDREN,
        OTHER
    };

    public Books(String name, String author, String publisher, int publishingYear, int ISBN, int stock, int edition, double price, double stars, BookType type) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.ISBN = ISBN;
        this.stock = stock;
        this.edition = edition;
        this.price = price;
        this.stars = stars;
        this.type = type;
    }

    public static void CreateBook(String name, String author, String publisher, int publishingYear, int ISBN, int stock, int edition, double price, double stars, BookType type) {
        String url = "jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL";

        try ( Connection connection = DriverManager.getConnection(url, "root", "root")) {
            // Check if the book already exists in the database
            String checkBookSql = "SELECT COUNT(*) FROM books WHERE name = ? AND author = ? AND publishingyear = ? AND edition = ? AND type = ? AND stock = ? AND price = ? AND ISBN = ?";
            try ( PreparedStatement checkBookStatement = connection.prepareStatement(checkBookSql)) {
                checkBookStatement.setString(1, name);
                checkBookStatement.setString(2, author);
                checkBookStatement.setInt(3, publishingYear);
                checkBookStatement.setInt(4, edition);
                checkBookStatement.setString(5, type.toString());
                checkBookStatement.setInt(6, stock);
                checkBookStatement.setDouble(7, price);
                checkBookStatement.setInt(8, ISBN);

                ResultSet resultSet = checkBookStatement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    // Book already exists, show a warning message or handle as needed
                    JOptionPane.showMessageDialog(null, "This book already exists in the database.", "Duplicate Book", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // Book does not exist, proceed with creating and inserting the new book
            Books newbook = new Books(name, author, publisher, publishingYear, ISBN, stock, edition, price, stars, type);
            String insertBookSql = "INSERT INTO books (name, author, publishingyear, edition, type, stock, price, ISBN) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try ( PreparedStatement insertBookStatement = connection.prepareStatement(insertBookSql)) {
                insertBookStatement.setString(1, name);
                insertBookStatement.setString(2, author);
                insertBookStatement.setInt(3, publishingYear);
                insertBookStatement.setInt(4, edition);
                insertBookStatement.setString(5, type.toString());
                insertBookStatement.setInt(6, stock);
                insertBookStatement.setDouble(7, price);
                insertBookStatement.setInt(8, ISBN);

                insertBookStatement.executeUpdate();

                // Add the book to the allbooks list only if it was successfully inserted
                DataBase.allbooks.add(newbook);
                DataBase.publishers.add(publisher);
                isBestPrefered(newbook);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    static public boolean isBestPrefered(Books book) {
        if (book.getStars() >= 4.5) {
            DataBase.bestbooks.add(book);
            return true;
        } else {
            return false;
        }
    }

    public static String getInfo(Books book) {
        return "Title: " + book.getName()
                + "\nAuthor: " + book.getAuthor()
                + "\nPublisher: " + book.getPublisher()
                + "\nPublishing Year: " + book.getPublishingYear()
                + "\nStock: " + book.getStock()
                + "\nPrice: " + book.getPrice()
                + "\nType:  " + book.getType()
                + "\nStars: " + book.getStars();
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
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * @return the publishingYear
     */
    public int getPublishingYear() {
        return publishingYear;
    }

    /**
     * @param publishingYear the publishingYear to set
     */
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @return the edition
     */
    public int getEdition() {
        return edition;
    }

    /**
     * @param edition the edition to set
     */
    public void setEdition(int edition) {
        this.edition = edition;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the stars
     */
    public double getStars() {
        return stars;
    }

    /**
     * @return the type
     */
    public BookType getType() {
        return type;
    }

    /**
     * @return the imageURL
     */
    

    /**
     * @return the ISBN
     */
    public int getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @param stars the stars to set
     */
    public void setStars(double stars) {
        this.stars = stars;
    }

    /**
     * @param type the type to set
     */
    public void setType(BookType type) {
        this.type = type;
    }

}
