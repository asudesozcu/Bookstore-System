/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookstoreautomation;

/**
 *
 * @author sozcu
 */
public class test {

    public static void main(String[] args) {
Books.CreateBook("İnce Mehmed", "Yakup Kadri Karaosmanoğlu", "Yayınevi1", 1928, 123456789, 100, 1, 29.99, 4.5, Books.BookType.NOVEL);
Books.CreateBook("Sineklerin Tanrısı", "William Golding", "Yayınevi2", 1954, 987654321, 150, 2, 19.99, 4.0, Books.BookType.SCIENCE_FICTION);
Books.CreateBook("Kuyucaklı Yusuf", "Sabahattin Ali", "Yayınevi3", 1937, 456789123, 120, 3, 24.99, 4.8, Books.BookType.NOVEL);
Books.CreateBook("Kürk Mantolu Madonna", "Sabahattin Ali", "Yayınevi4", 1940, 789123456, 80, 1, 39.99, 4.2, Books.BookType.NOVEL);
Books.CreateBook("Harry Potter", "J.K Rowling", "Yayınevi5", 1453, 321654987, 200, 2, 14.99, 4.9, Books.BookType.SCIENCE_FICTION);
Books.CreateBook("Saatleri Ayarlama Enstitüsü", "Ahmet Hamdi Tanpınar", "Yayınevi6", 1961, 654987321, 90, 3, 34.99, 4.7, Books.BookType.NOVEL);
Books.CreateBook("Beyaz Gemi", "Cengiz Aytmatov", "Yayınevi7", 1976, 159753468, 110, 1, 22.99, 4.0, Books.BookType.OTHER);
Books.CreateBook("İstanbul Hatırası", "Ahmet Ümit", "Yayınevi8", 2005, 147258369, 130, 2, 17.99, 4.5, Books.BookType.BIOGRAPHY);
Books.CreateBook("Şeker Portakalı", "José Mauro de Vasconcelos", "Yayınevi10", 1968, 258369147, 110, 1, 19.99, 4.2, Books.BookType.NOVEL);

        Customer.createCustomer("c1", "John", "Doe", "john.doe@example.com", "123456789", "c1", "123 Main St", Person.Gender.MALE, 25,1221);
        Customer.createCustomer("alice_smith", "Alice", "Smith", "alice.smith@example.com", "987654321", "password456", "456 Oak St", Person.Gender.FEMALE, 30,321);
        Customer.createCustomer("bob_jones", "Bob", "Jones", "bob.jones@example.com", "111223344", "password789", "789 Elm St", Person.Gender.MALE, 22,4321);
        
        BookstoreWorker worker = new BookstoreWorker("Ahmet", "Ak", "asdf@gmail.com", "09876543", "cfvjfdhvjkfdvhdvfd", "p1", Person.Gender.MALE, 1232131);
        DataBase.admin.add(worker);
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseLogınType().setVisible(true);
            }
        });
    }
}
