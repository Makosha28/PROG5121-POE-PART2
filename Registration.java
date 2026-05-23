/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author mamphekgonthabiseng
 */
import java.util.Scanner;

public class Registration {
    private String regiUsername;
    private String regiPassword;
    private String regiCellPhoneNumber;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = false, hasNumber = false, hasSpecial = false;
        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasUpper && hasNumber && hasSpecial;
    }

    public boolean checkCellPhoneNumber(String mobileNumber) {
        return mobileNumber.matches("^\\+27[6-8]\\d{8}$");
    }

    public String registerUser(Scanner keyboard) {
        System.out.println("\n=== REGISTRATION ===");
        System.out.print("Enter username: ");
        String username = keyboard.nextLine().trim();

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        regiUsername = username;
        System.out.println("Username successfully captured.");

        System.out.print("Enter password: ");
        String password = keyboard.nextLine().trim();
        if (!checkPassword(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        regiPassword = password;
        System.out.println("Password successfully captured.");

        System.out.print("Enter cell phone number: ");
        String phone = keyboard.nextLine().trim();
        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        regiCellPhoneNumber = phone;
        System.out.println("Cell phone number successfully added.");

        return "Registration successful!";
    }

    public String getStoredUsername() { return regiUsername; }
    public String getStoredPassword() { return regiPassword; }

    
    }

  
