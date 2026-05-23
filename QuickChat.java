/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchat;

/**
 *
 * @author mamphekgonthabiseng
 */
import java.util.*; 

 

public class QuickChat { 

    private static final Scanner scanner = new Scanner(System.in); 

    private static int messageCount = 0; 

    private static final List<Message> messages = new ArrayList<>(); 

 

    public static void main(String[] args) { 

        System.out.println("Welcome to QuickChat."); 

         

        // Ask how many messages the user wants to send 

        System.out.print("How many messages would you like to enter? "); 

        int totalMessages; 

        while (true) { 

            try { 

                totalMessages = Integer.parseInt(scanner.nextLine()); 

                if (totalMessages > 0) break; 

                System.out.print("Please enter a positive number: "); 

            } catch (NumberFormatException e) { 

                System.out.print("Invalid input. Enter a number: "); 

            } 

        } 

 

        // Main menu loop 

        while (true) { 

            System.out.println("\nChoose an option:"); 

            System.out.println("1) Send Messages"); 

            System.out.println("2) Show recently sent messages"); 

            System.out.println("3) Quit"); 

            System.out.print("Enter your choice: "); 

 

            String choice = scanner.nextLine(); 

 

            switch (choice) { 

                case "1": 

                    sendMessages(totalMessages); 

                    break; 

                case "2": 

                    System.out.println("\nComing Soon."); 

                    break; 

                case "3": 

                    System.out.println("Goodbye!"); 

                    scanner.close(); 

                    return; 

                default: 

                    System.out.println("Invalid option. Please try again."); 

            } 

        } 

    } 

 

    private static void sendMessages(int totalMessages) { 

        for (int i = 0; i < totalMessages; i++) { 

            System.out.println("\n--- Message " + (i + 1) + " of " + totalMessages + " ---"); 

             

            // Recipient 

            String recipient; 

            while (true) { 

                System.out.print("Enter recipient number (max 10 chars, with international code): "); 

                recipient = scanner.nextLine().trim(); 

                if (recipient.length() <= 10 && recipient.length() > 0) { 

                    break; 

                } 

                System.out.println("Invalid recipient. Must be 1-10 characters."); 

            } 

 

            // Message content 

            String messageText; 

            while (true) { 

                System.out.print("Enter your message (max 250 characters): "); 

                messageText = scanner.nextLine(); 

                if (messageText.length() <= 250) { 

                    break; 

                } 

                System.out.println("Please enter a message of less than 250 characters."); 

            } 

 

            // Generate Message ID (10-digit random number) 

            long messageId = 1000000000L + (long) (Math.random() * 9000000000L); 

 

            // Generate Message Hash 

            String[] words = messageText.trim().split("\\s+"); 

            String firstWord = words.length > 0 ? words[0].toUpperCase() : ""; 

            String lastWord = words.length > 0 ? words[words.length - 1].toUpperCase() : ""; 

            String messageHash = String.format("%02d:%d:%s%s",  

                (int)(messageId % 100), messageCount + 1, firstWord, lastWord); 

 

            messageCount++; 

            Message mess = new Message(messageId, recipient, messageText, messageHash); 

            messages.add(mess); 

 

            // Display message details 

            System.out.println("\nMessage successfully sent!"); 

            System.out.println("Message ID: " + messageId); 

            System.out.println("Message Hash: " + messageHash); 

            System.out.println("Recipient: " + recipient); 

            System.out.println("Message: " + messageText); 

        } 

 

        // Final summary 

        System.out.println("\nTotal messages sent: " + messageCount); 

    } 

 

    // Inner class to store message data 

    static class Message { 

        long messageId; 

        String recipient; 

        String messageText; 

        String messageHash; 

 

        Message(long id, String reci, String mess, String hash) { 

            this.messageId = id; 

            this.recipient = reci; 

            this.messageText = mess; 

            this.messageHash = hash; 

        } 

    } 

} 
