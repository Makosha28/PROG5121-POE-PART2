
package com.mycompany.quickchat;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.*;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    private static int totalMessages = 0;
    private static final List<Message> sentMessages = new ArrayList<>();

    public Message(String recipient, String messageText) {
        this.recipient = recipient;
        this.message = messageText;
        totalMessages++;
        this.messageNumber = totalMessages;
        this.messageID = generateMessageID();
        this.messageHash = generateMessageHash();
    }

    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) sb.append(rand.nextInt(10));
        return sb.toString();
    }

    private String generateMessageHash() {
        String combined = (recipient + message).replaceAll("\\s+", "");
        return combined.toUpperCase();
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public String checkRecipientCell() {
        if (recipient == null || !recipient.startsWith("+") || recipient.length() < 10) {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
        return "Cell phone number successfully captured.";
    }

    public void printMessageDetails() {
        System.out.println("Message ID     : " + messageID);
        System.out.println("Message Number : " + messageNumber);
        System.out.println("Recipient      : " + recipient);
        System.out.println("Message        : " + message);
        System.out.println("Message Hash   : " + messageHash);
        System.out.println("----------------------------------------");
    }

    public static void addSentMessage(Message msg) {
        sentMessages.add(msg);
        saveToJson();
    }

    public static void saveToJson() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("sent_messages.json"))) {
            writer.println("[");
            for (int i = 0; i < sentMessages.size(); i++) {
                Message m = sentMessages.get(i);
                writer.println("  {");
                writer.println("    \"messageID\": \"" + m.messageID + "\",");
                writer.println("    \"messageNumber\": " + m.messageNumber + ",");
                writer.println("    \"recipient\": \"" + m.recipient + "\",");
                writer.println("    \"message\": \"" + m.message.replace("\"", "\\\"") + "\",");
                writer.println("    \"messageHash\": \"" + m.messageHash + "\"");
                writer.println("  }" + (i < sentMessages.size() - 1 ? "," : ""));
            }
            writer.println("]");
        } catch (IOException e) {
            System.out.println("Warning: Could not save to JSON file.");
        }
    }

    public static void printAllSentMessages() {
        if (sentMessages.isEmpty()) {
            System.out.println("No messages sent yet.");
            return;
        }
        System.out.println("\n=== ALL SENT MESSAGES ===");
        for (Message m : sentMessages) m.printMessageDetails();
    }

    public static int getTotalMessages() {
        return totalMessages;
    }
}
