package com.librarysystem;

import java.util.Scanner;

public class Main {

    private static Books[] bookShelf;
    private static Books[] checkedOut;
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        //Preloaded books in the library
        Books book1 = new Books(1, "6717797617487", "To Kill a Mocking Bird", false);
        Books book2 = new Books(2, "2352395974821", "The Great Gatsby", false);
        Books book3 = new Books(3, "6202733598476", "Vikings: History and Lore", false);
        Books book4 = new Books(4,"9077593228100", "The Art of God of War: Ragnarok", false);
        Books book5 = new Books(5, "3827444078593", "Chainsaw Man: Vol. 1", false);

            //books in the library
            bookShelf[0] = book1;
            bookShelf[1] = book2;
            bookShelf[2] = book3;
            bookShelf[3] = book4;
            bookShelf[4] = book5;

        //Menu
        boolean exit = false;
        while (!exit); {
            System.out.println("Welcome to the Library!");
            System.out.println("1: Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit\n");
            System.out.println("What would you like to do?: ");

            int command = input.nextInt();
            input.nextLine(); // Clear the scanner issue

            switch (command) {
                case 1: //Show Available Books
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
}
