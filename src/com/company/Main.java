package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean whileLoop = true;

        while (whileLoop) {

        String UserChoice = MethodsMain.pickEncryptDecrypt();
            // 1 to encode.
            // 2 to decode.
            // 3 to exit.

            if (UserChoice.equals("1")) {

                char[] messageToEnrypt = MethodsEncoder.messageToEncrypt();
                int encryptionKey = MethodsEncoder.encryptionKey();
                String encryptedMessage = MethodsEncoder.encryptMessage(messageToEnrypt, encryptionKey);
                System.out.println(encryptedMessage);

                Scanner scanner = new Scanner(System.in);
                System.out.println("If you want to decrypt your message press '1'.\nIf you want to go back to the menu press '2'.");
                System.out.print(">");
                String userInput = scanner.nextLine();

                if (userInput.equals("1")) {
                    String[] array = encryptedMessage.split(";");
                    int[] arrayOfIntegers = new int[array.length];
                    for (int i = 0; i < array.length; i++) {
                        arrayOfIntegers[i] = Integer.parseInt(array[i]);
                    }
                    String decryptedMessage = MethodsDecoder.decryptMessage(arrayOfIntegers, encryptionKey);
                    System.out.println(decryptedMessage);
                } else if (userInput.equals("2")) {
                    continue;
                }
            } else if (UserChoice.equals("2")) {
                int[] messageToDecrypt = MethodsDecoder.messageToDecrypt();
                int encryptionKey = MethodsDecoder.encryptionKey();
                String decryptedMessage = MethodsDecoder.decryptMessage(messageToDecrypt, encryptionKey);
                System.out.println(decryptedMessage);
            } else {
                whileLoop = false;
            }
        }
    }
}
