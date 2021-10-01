package com.company;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MethodsEncoder {



    public static char[] messageToEncrypt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the message you would like to encrypt.");
        System.out.println(">");
        String userInput = scanner.nextLine();

        String userInputWithoutSpaces = userInput.replace(" ", "");
        return userInputWithoutSpaces.toCharArray();
    }

    public static int encryptionKey() {
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "y", "z", "æ", "ø", "å"};
        int[] arrayEncryptionKeys = new int[array.length];

        for (int i = 1; i < array.length; i++) {
            arrayEncryptionKeys[i] = i;
        }


        Scanner scanner = new Scanner(System.in);
        boolean whileLoop = true;
        int userInput = 0;
        int encryptionKey = 0;

        System.out.println("Would you like to pick your own encryption key or generate one?");
        while (whileLoop) {

            System.out.println("Press '1' to pick your own\nPress '2' to generate a key");

            try {
                System.out.print(">");
                userInput = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input has to be a number. Try again.");
                continue;
            }
            if (userInput == 1) {
                try {
                    System.out.print(">");
                    userInput = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Input has to be a number. Try again.");
                    continue;
                }
                if (userInput < 1 || userInput > array.length) {
                    System.out.println("Invalid value. Try again");
                } else {
                    encryptionKey = userInput;
                    System.out.print(">");
                    whileLoop = false;
                }
            } else if (userInput == 2) {
                Random random = new Random();
                int randomIndex = random.nextInt(arrayEncryptionKeys.length);
                encryptionKey = arrayEncryptionKeys[randomIndex];
                whileLoop = false;
            } else {
                System.out.println("");
            }
        }
        return userInput;
}

    public static String encryptMessage(char[] array, int encryptionKey) {
        String encodedMessage = "";
        String encodedMessageNew = "";
        char[] arrayAlphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'z', 'æ', 'ø', 'å'};
        int[] encodedMessageAsIntegers = new int[array.length];

        for (int index = 0; index < array.length; index++) {
            for (int i = 0; i < arrayAlphabet.length; i++) {
                if (array[index] == arrayAlphabet[i]) {
                    encodedMessageAsIntegers[index] = i + 1 + encryptionKey;
                    break;
                }
            }
        }
        for (int i = 0; i < encodedMessageAsIntegers.length; i++) {
            encodedMessage += String.valueOf(encodedMessageAsIntegers[i] + ";");
            encodedMessageNew = encodedMessage.substring(0, encodedMessage.length()-1);
        }
        System.out.println("This is your encrypted message:");
        return encodedMessageNew;
    }
}