
package com.mycompany.quickchat;
import java.util.Scanner;

public class Login {
    private final Registration registration;

    public Login(Registration registration) {
        this.registration = registration;
    }

    public boolean loginUser(Scanner keyboard) {
        System.out.println("\n=== LOGIN ===");

        System.out.print("Enter username: ");
        String username = keyboard.nextLine();

        System.out.print("Enter password: ");
        String password = keyboard.nextLine();

        String regUser = registration.getStoredUsername();
        String regPass = registration.getStoredPassword();

        if (regUser == null || regPass == null) {
            System.out.println("No registered user found. Please register first.");
            return false;
        }

        if (username.equals(regUser) && password.equals(regPass)) {
            System.out.println("Welcome Makosha Mamphekgo, it is great to see you again.");
            return true;
        } else {
            System.out.println("Username or password incorrect, please try again.");
            return false;
        }
    }
}
