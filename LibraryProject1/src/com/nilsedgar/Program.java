package com.nilsedgar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();
    Customer customer;

    public Program() {

        Menu menu = new Menu();
        menu.showMainMenu();


    }

    public void showListOfBooks(){
        List<Book> books = (List<Book>) FileUtility.loadObject("books.ser");
        for(Book book: books){
            System.out.println(book.getTitle() + " " + book.getAuthor() + " " + book.getGenre() + "\n");
            if(book.getIsAvailable()){
                System.out.println("This book is available");
            }
            else{
                System.out.println("This book is not available");
            }
        }
    }

    public void borrowBook(){
        List<Book> books = (List<Book>) FileUtility.loadObject("books.ser");
        System.out.println("Enter the title of the book you wish to borrow: ");
        String borrowBook = scanner.nextLine();
        for(Book book : books){
            if(book.getTitle().equals(borrowBook) && book.getIsAvailable() == true){
                customer.borrowedBooks.add(book);
                book.setIsAvailable(false);
            }
            else{
                System.out.println("Book cannot be found.");
            }
        }
    }

    public void showMyBorrowedBooks(){
        for(Book book: customer.borrowedBooks){
            System.out.println(book.getTitle());
        }
    }

    public void returnBook(){

    }

    public void searchForAuthor(){
        List<Book> books = (List<Book>) FileUtility.loadObject("books.ser");
        System.out.println("Enter name of author: ");
        String bookAuthor = scanner.nextLine();
        for(Book book : books){
            if(book.getAuthor().equals(bookAuthor)){
                System.out.println("This author has written: " + book.getTitle());
            }
            else{
                System.out.println("There is no author by that name");
            }
        }

    }

    public void addNewBook(){
        System.out.println("Enter title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter author: ");
        String bookAuthor = scanner.nextLine();
        System.out.println("Enter genre: ");
        String bookGenre = scanner.nextLine();
        books.add(new Book(bookTitle, bookAuthor, bookGenre, true));
    }

    public void addNewCustomer(){
        System.out.println("Enter name:");
        String customerName = scanner.nextLine();
        users.add(new Customer(customerName, "customer123"));
    }

    public void showAllUsers(){
        for(User user: users){
            System.out.println(user.getName());
        }
    }

    public void searchForUserName(){
        System.out.println("Enter name: ");
        String nameSearch = scanner.nextLine();
        for(User user: users){
            if(user.getName().equals(nameSearch)){
                System.out.println("There is a user by that name");
            }
            else{
                System.out.println("Could not find user");
            }
        }
    }

    public void createUserList() {
        users.add(new Admin("Nils Jacobsen", "admin123"));
        users.add(new Admin("Karin Lennebo", "admin123"));
        users.add(new Customer("Hej Hejsson", "customer123"));
        users.add(new Customer("Adjö Adjösson", "customer123"));
        users.add(new Customer("Läget Lägetsson", "customer123"));
        users.add(new Customer("Låna Boksson", "customer123"));

        FileUtility.saveObject("users.ser", users);
    }


    public void createBookList() {

        books.add(new Book("Harry Potter", "JK Rowling", "Fantasy", true));
        books.add(new Book("Lord Of The Rings", "J.R.R Tolkien", "Fantasy", true));
        books.add(new Book("Moby Dick", "Herman Melville", "Drama", true));
        books.add(new Book("Hamlet", "William Shakespeare", "Tragedy", true));
        books.add(new Book("Huckleberry Finn", "Mark Twain", "Adventure", true));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Periodical", true));
        books.add(new Book("The Iliad", "Homer", "Epic", true));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Gothic", true));

        FileUtility.saveObject("books.ser", books);
    }
}