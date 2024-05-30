package com.lib.app;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
        static Scanner myScanner = new Scanner(System.in);

        public static void mock_data() throws JsonIOException, IOException {

                // creating mock members
                Member[] members = new Member[] {
                                new Member("Sarah", "sarah@hotmail.com", "123 Main St", "555-1212"),
                                new Member("David", "david.lee@yahoo.com", "456 Elm St", "888-4545"),
                                new Member("Emily", "emily.brown@hotmail.com", "2000 Pine Rd", "789-0101"),
                                new Member("Daniel", "daniel.lee@yahoo.com", "3000 Spruce St", "456-7890"),
                                new Member("Jessica", "jessica.garcia@aol.com", "4000 Willow Way", "234-5678"),
                                new Member("Alexander", "alexander.williams@gmail.com", "5000 Birch Ln", "567-8901"),
                                new Member("Maria", "maria.davis@hotmail.com", "6000 Poplar Ave", "890-1234")

                };

                // creating mock books
                Book[] books = new Book[] {
                                new Book("The Lord of the Rings", "J.R.R. Tolkien",
                                                "An epic high-fantasy that has shaped the genre",
                                                "Fantasy", 5),
                                new Book("The Alchemist", "Paulo Coelho",
                                                "A fable about pursuing your dreams and finding your personal legend",
                                                "Fiction", 4),
                                new Book("The Martian", "Andy Weir",
                                                "An astronaut stranded on Mars must use his ingenuity to survive",
                                                "Sci-Fi", 4),
                                new Book("Dune", "Frank Herbert",
                                                "A complex and thought-provoking sci-fi epic set on a desert planet",
                                                "Sci-Fi", 5),
                                new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling",
                                                "The first book in the beloved Harry Potter series about a boy wizard",
                                                "Fantasy", 5),
                                new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari",
                                                "Explores the history of humankind from our origins to the present day",
                                                "Non-Fiction", 5)
                };

                // creating mock transactions
                Transaction[] transactions = new Transaction[] {
                                new Transaction(members[0].id, books[0].id, 1),
                                new Transaction(members[1].id, books[4].id, 1),
                                new Transaction(members[3].id, books[2].id, 2),
                                new Transaction(members[4].id, books[1].id, 2),

                };

                Gson gson = new Gson();
                JsonObject jsonObject = new JsonObject();

                try {
                        JsonArray jsonMembers = gson.toJsonTree(members).getAsJsonArray();
                        JsonArray jsonBooks = gson.toJsonTree(books).getAsJsonArray();
                        JsonArray jsonTransactions = gson.toJsonTree(transactions).getAsJsonArray();

                        jsonObject.add("book", jsonBooks);
                        jsonObject.add("member", jsonMembers);
                        jsonObject.add("transaction", jsonTransactions);

                        FileWriter fileWriter = new FileWriter("data.json");
                        gson.toJson(jsonObject, fileWriter);
                        fileWriter.flush();

                        System.out.println("Success writing data to JSON file!");

                } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error writing data to JSON file!");
                }
        }

        public static void read_data() throws FileNotFoundException{

        }

        public static void show_options() throws JsonIOException, IOException {
                while (true) {
                        System.out.println("Choose Option: ");
                        System.out.println("-1- Add Book -2- Add Member -3- Add Transaction -4- Mock data ");
                        int option = myScanner.nextInt();
                        if (option == 1) {
                                add_book();
                        } else if (option == 2) {
                                add_member();
                        } else if (option == 3) {
                                add_transaction();
                        } else if (option == 4) {
                                mock_data();
                        }
                        else {
                                System.out.println("Enter a valid option");
                        }
                }
        }

        private static void add_transaction() {
                System.out.println("Enter member id");
                String member_id = myScanner.nextLine();
                System.out.println("Enter book id");
                String book_id = myScanner.nextLine();
                System.out.println("Enter 1=booked, 2=finished");
                int status = myScanner.nextInt();
                Transaction transaction = new Transaction(member_id, book_id, status);


        }

        private static void add_member() {
                System.out.println("Enter a username");
                String name = myScanner.nextLine();
                System.out.println("Enter a address");
                String address = myScanner.nextLine();
                System.out.println("Enter phone number");
                String phone = myScanner.nextLine();
                System.out.println("Enter email");
                String email = myScanner.nextLine();

                Member member = new Member(name, email, address, phone);
        }

        private static void add_book() {
                System.out.println("Enter a title: ");
                String title = myScanner.nextLine();
                System.out.println("Enter author: ");
                String author = myScanner.nextLine();
                System.out.println("Enter description: ");
                String description = myScanner.nextLine();
                System.out.println("Enter categories: ");
                String categories = myScanner.nextLine();
                System.out.println("Enter quantity: ");
                int quantity = myScanner.nextInt();

                Book book = new Book(title, author, description, categories, quantity);

        }

        public static void main(String[] args) throws IOException {

                mock_data();
                show_options();

        }
}