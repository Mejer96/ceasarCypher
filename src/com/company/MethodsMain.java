package com.company;

import java.util.Scanner;

public class MethodsMain {
    public static String pickEncryptDecrypt() {
        boolean whileLoop = true;
        Scanner scanner = new Scanner(System.in);
        String userInput = null;

        System.out.println("Please select your choice:");

        while (whileLoop) {
            System.out.println("Type '1' to encrypt.\nType '2' to decrypt.\n Type '3' to exit.");
            System.out.print(">");
            userInput = scanner.nextLine();

            if (userInput.equals("1") || userInput.equals("2") || userInput.equals("3")) {
                whileLoop = false;
            }
            else {
                System.out.println("Error. Please enter a valid value.");
            }
        }
        return userInput;
    }
}
