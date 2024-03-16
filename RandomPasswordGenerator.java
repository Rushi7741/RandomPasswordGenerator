package Cognify;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {

    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+-=";
    private static final String ALL_CHARACTERS = LOWERCASE_LETTERS + UPPERCASE_LETTERS + NUMBERS + SPECIAL_CHARACTERS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println();
        System.out.println("|****************************************************|");
        System.out.println("|======= *** Random  Password Generator *** =========|");
        System.out.println("|****************************************************|");
        System.out.println();
    
       

        System.out.println("Enter the desired password length: ");
        int length = scanner.nextInt();
        System.out.println();

        System.out.println("Include numbers (Yen/No)? ");
        boolean includeNumbers = scanner.next().toLowerCase().equals("y");
        System.out.println();

        System.out.println("Include lowercase letters (Yes/No)? ");
        boolean includeLowercaseLetters = scanner.next().toLowerCase().equals("y");
        System.out.println();

        System.out.println("Include uppercase letters (Yes/No)? ");
        boolean includeUppercaseLetters = scanner.next().toLowerCase().equals("y");
        System.out.println();

        System.out.println("Include special characters (Yes/No)? ");
        boolean includeSpecialCharacters = scanner.next().toLowerCase().equals("y");
        System.out.println();

        System.out.println("Generated password := " + generatePassword(length, includeNumbers, includeLowercaseLetters, includeUppercaseLetters, includeSpecialCharacters));

        scanner.close();
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercaseLetters, boolean includeUppercaseLetters, boolean includeSpecialCharacters) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        String characterSet = "";

        if (includeNumbers) {
            characterSet += NUMBERS;
        }

        if (includeLowercaseLetters) {
            characterSet += LOWERCASE_LETTERS;
        }

        if (includeUppercaseLetters) {
            characterSet += UPPERCASE_LETTERS;
        }

        if (includeSpecialCharacters) {
            characterSet += SPECIAL_CHARACTERS;
        }

        if (characterSet.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be included.");
        }

        for (int i = 0; i < length; i++) {
            password.append(characterSet.charAt(random.nextInt(characterSet.length())));
        }

        return password.toString();
    }
}