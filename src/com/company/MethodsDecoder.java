package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MethodsDecoder {

    public static int[] messageToDecrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the message you would like to decrypt:");
        System.out.print(">");
        String userInput = scanner.nextLine();

        String[] array = userInput.split(";");

        int[] arrayOfIntegers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayOfIntegers[i] = Integer.parseInt(array[i]);
        }
        return arrayOfIntegers;
    }

    public static String decryptMessage(int[] arrayFromMethod, int encryptionKey) {
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z", "æ", "ø", "å"};
        String[] decodedNumbers = new String[arrayFromMethod.length];
        String decodedMessage = "";

        for (int index = 0; index < arrayFromMethod.length; index++) {

            for (int i = 0; i < array.length; i++) {
                if (i + 1 + encryptionKey == arrayFromMethod[index]) {
                    decodedNumbers[index] = array[i];
                }
            }
        }

        for (int i = 0; i < decodedNumbers.length; i++ ) {
            decodedMessage += decodedNumbers[i];
        }
        System.out.println("Your decoded message is:");
        return decodedMessage;
    }

    public static int encryptionKey() {

        Scanner scanner = new Scanner(System.in);
        boolean whileLoop = true;
        int userInput = 0;
        int encryptionKey = 0;

        System.out.println("Please insert your encryption key.");
        while (whileLoop) {
            try {
                System.out.print(">");
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input has to be a number. Try again.");
                continue;
            }
            if (userInput < 1) {
                System.out.println("Invalid value. Try again");
            } else {
                encryptionKey = userInput;
                System.out.print(">");
                whileLoop = false;
                System.out.println("Invalid value. Try again");
            }
        }
        return encryptionKey;
    }
}
