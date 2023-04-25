package com.librarysystem;
import java.util.Scanner;

public class Main {

    private static Books[] bookShelf = new Books[5];
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        //Preloaded books in the library
        Books book1 = new Books(1, "6717797617487", "To Kill a Mocking Bird");
        Books book2 = new Books(2, "2352395974821", "The Great Gatsby");
        Books book3 = new Books(3, "6202733598476", "Vikings: History and Lore");
        Books book4 = new Books(4,"9077593228100", "The Art of God of War: Ragnarok");
        Books book5 = new Books(5, "3827444078593", "Chainsaw Man: Vol. 1");

            //books in the library
            bookShelf[0] = book1;
            bookShelf[1] = book2;
            bookShelf[2] = book3;
            bookShelf[3] = book4;
            bookShelf[4] = book5;

        //Menu
        boolean exit = false;
        while (!exit) {
            System.out.println("============================");
            System.out.println("Welcome to the Library!");
            System.out.println("\t1: Show Available Books");
            System.out.println("\t2. Show Checked Out Books");
            System.out.println("\t3. Exit\n");
            System.out.print("What would you like to do?: ");

            int command = input.nextInt();
            input.nextLine(); // Clear the scanner issue

            switch (command) {
                case 1: //Show Available Books
                    System.out.println("Here is our current inventory:");
                    booksInInventory();
                    System.out.println(" ");

                    System.out.print("Press 1 to checkout a book or press 0 to exit. ");
                    int selection = input.nextInt();

                    if (selection == 1){
                        checkingOutBook();
                    } else if (selection == 0) {
                        System.out.println("Returning to menu.");
                        break;
                    } else {
                        System.out.println("Invalid Input, Please try again");
                        break;
                    }

                    break;
                case  2: // Show Checked out Books
                    booksCheckedOut();

                    System.out.print("Press 1 to check in a book, press 0 to exit:");
                    int choice = input.nextInt();

                    if (choice == 1){
                        checkingInBook();
                    } else if (choice == 0) {
                        System.out.println("Returning to menu.");
                        break;
                    } else {
                        System.out.println("Invalid Input, Please try again");
                        break;
                    }
                    break;
                case 3: // Exit command
                    System.out.println("Thank you. Have a Good Day!");
                    exit = true;
                    break;
                default: //User Error
                    System.out.println("Invalid input, try again.");
                    break;
            }
        }
    }
    public static void booksInInventory(){
        for (Books books : bookShelf) {
            if (!books.isCheckedOut()) {
                System.out.println("ID: " + books.getId() + " || " + "ISBN: " + books.getIsbn() + " || " + "Title: " + books.getTitle());
            }
        }
    }
    public static void booksCheckedOut() {
        System.out.println("Books currently checked out:");
        for (Books books : bookShelf) {
            if (books.isCheckedOut()) {
                System.out.println("ID: " + books.getId() + " || ISBN: " + books.getIsbn() + " || Title: " + books.getTitle() + " || Checked Out to: " + books.getCheckedOutTo());
            }
        }
        System.out.println(" ");
    }

    public static void checkingOutBook() {
        System.out.print("Enter the book ID# you wish to check out: ");
        int selectID = input.nextInt();

        for (Books books : bookShelf) {
            if(selectID == books.getId()) {
                System.out.print("Please enter your name here: ");
                String recipientName = input.nextLine();
                input.nextLine();

                books.checkOut(recipientName);
            }
        }
    }
    public static void checkingInBook() {
        System.out.print("Enter the book ID# you wish to check out: ");
        int selectID = input.nextInt();

        for (Books books : bookShelf) {
            if(selectID == books.getId()) {
                System.out.println("Book Titled " + books.getTitle() + " (ID: " + books.getId() + ") Has been returned to the library.");
                books.checkIn();
            }
        }
    }
}


