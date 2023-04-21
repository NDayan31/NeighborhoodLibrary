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
                    System.out.println("");

                    System.out.print("Type ID# if the book that you wish to check out, or press 0 to exit. ");
                    int selection = input.nextInt();
                    if (selection == 0){
                        break;
                    } else if (selection == bookShelf[selection].getId()){
                        System.out.print("Enter your name here: ");
                        String name = input.nextLine();

                        bookShelf[selection].checkOut(name);
                    } else {
                        System.out.println("That is not available");
                    }
                    break;
                case  2: // Show Checked out Books
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
        for (int i = 0; i < bookShelf.length; i++) {
            if (!bookShelf[i].isCheckedOut()) {
                System.out.println("ID: " + bookShelf[i].getId() + " || " + "ISBN: " + bookShelf[i].getIsbn() + " || " + "Title: " + bookShelf[i].getTitle());
            }
        }
    }
    /*public static void checkOutSelection(){
        if ()
    }*/
}
