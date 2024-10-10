package com.sachkomaxim.lab2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            StringBuffer text = getInputText(scanner);
            StringBuffer targetChar = getInputChar(scanner);

            StringBuffer sortedText = sortWordsByCharCount(text, targetChar);

            System.out.println("\nВідсортовані слова:");
            System.out.println(sortedText.toString());
        } catch (Exception e) {
            throw new RuntimeException("Помилка: " + e.getMessage());
        }
    }

    private static StringBuffer getInputText(Scanner scanner) {
        System.out.println("Введіть текст:");
        StringBuffer textReturn = new StringBuffer(scanner.nextLine());
        return textReturn;
    }

    private static StringBuffer getInputChar(Scanner scanner) {
        System.out.println("\nВведіть літеру або число, за кількістю якої буде відсортовано слова:");
        StringBuffer inputChar = new StringBuffer(scanner.nextLine());

        if (inputChar.length() != 1) {
            throw new IllegalArgumentException("Потрібно ввести лише одну літеру або число.");
        }

        if (!Character.isLetterOrDigit(inputChar.charAt(0))) {
            throw new IllegalArgumentException("Потрібно ввести лише літеру або число.");
        }

        return inputChar;
    }

    public static StringBuffer sortWordsByCharCount(StringBuffer text, StringBuffer targetChar) {
        StringBuffer[] words = splitTextIntoWords(text);

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - i - 1; j++) {
                if (countCharOccurrences(words[j], targetChar.charAt(0)) > countCharOccurrences(words[j + 1], targetChar.charAt(0))) {
                    StringBuffer temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }

        StringBuffer sortedText = new StringBuffer();
        for (StringBuffer word : words) {
            sortedText.append(word).append(" ");
        }

        if (sortedText.length() > 0) {
            sortedText.setLength(sortedText.length() - 1);
        }

        return sortedText;
    }

    public static StringBuffer[] splitTextIntoWords(StringBuffer text) {
        int wordCount = 1;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        StringBuffer[] words = new StringBuffer[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = new StringBuffer();
        }

        int currentWordIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == ' ') {
                currentWordIndex++;
            } else {
                words[currentWordIndex].append(currentChar);
            }
        }

        return words;
    }

    public static int countCharOccurrences(StringBuffer word, char targetChar) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == targetChar) {
                count++;
            }
        }
        return count;
    }
}
