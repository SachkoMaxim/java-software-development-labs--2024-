package com.sachkomaxim.lab2;

import java.util.ArrayList;
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
        return new StringBuffer(scanner.nextLine());
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
        // Розбиття тексту на слова разом із розділовими знаками
        ArrayList<StringBuffer> wordsAndPunctuation = splitTextAndPunctuation(text);

        // Сортування слів без розділових знаків
        ArrayList<StringBuffer> sortedWords = sortWordsOnly(wordsAndPunctuation, targetChar);

        // Повернення слів із збереженими розділовими знаками
        return mergeWordsAndPunctuation(wordsAndPunctuation, sortedWords);
    }

    public static ArrayList<StringBuffer> splitTextAndPunctuation(StringBuffer text) {
        ArrayList<StringBuffer> wordsAndPunctuation = new ArrayList<>();
        StringBuffer currentPart = new StringBuffer();
        boolean isWord = Character.isLetterOrDigit(text.charAt(0));

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                if (!isWord) {
                    wordsAndPunctuation.add(currentPart);
                    currentPart = new StringBuffer();
                    isWord = true;
                }
                currentPart.append(currentChar);
            } else {
                if (isWord) {
                    wordsAndPunctuation.add(currentPart);
                    currentPart = new StringBuffer();
                    isWord = false;
                }
                currentPart.append(currentChar);
            }
        }

        wordsAndPunctuation.add(currentPart);

        return wordsAndPunctuation;
    }

    public static ArrayList<StringBuffer> sortWordsOnly(ArrayList<StringBuffer> wordsAndPunctuation, StringBuffer targetChar) {
        ArrayList<StringBuffer> words = new ArrayList<>();

        for (StringBuffer part : wordsAndPunctuation) {
            if (Character.isLetterOrDigit(part.charAt(0))) {
                words.add(part);
            }
        }

        words.sort((word1, word2) -> countCharOccurrences(word1, targetChar.charAt(0)) - countCharOccurrences(word2, targetChar.charAt(0)));

        return words;
    }

    public static StringBuffer mergeWordsAndPunctuation(ArrayList<StringBuffer> original, ArrayList<StringBuffer> sortedWords) {
        StringBuffer result = new StringBuffer();
        int wordIndex = 0;

        for (StringBuffer part : original) {
            if (Character.isLetterOrDigit(part.charAt(0))) {
                result.append(sortedWords.get(wordIndex++));
            } else {
                result.append(part);
            }
        }

        return result;
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
