package com.sachkomaxim.lab4;

import com.sachkomaxim.lab4.components.*;
import java.util.Scanner;

/**
 * The Main class contains the main method and utility methods for reading text and character
 * from the console, sorting words in a text based on the occurrences of a specified character,
 * and printing the sorted text.
 */
public class Main {
    /**
     * The main method reads a text and a character from the console, sorts the
     * words in the text based on the occurrences of the specified character,
     * and prints the sorted text.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Text text = getInputText(scanner);
            Letter targetChar = getInputChar(scanner);

            Text sortedText = sortWordsByCharCount(text, targetChar);

            System.out.println("\nВідсортовані слова:");
            System.out.println(sortedText);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    /**
     * Prompts the user to enter a text and returns it as a Text object.
     *
     * @param scanner The scanner for reading input.
     * @return A Text object containing the input text.
     */
    private static Text getInputText(Scanner scanner) {
        System.out.println("Введіть текст:");
        StringBuffer inputText = new StringBuffer(scanner.nextLine());
        return new Text(inputText);
    }

    /**
     * Prompts the user to enter a single character for sorting and validates the input.
     *
     * @param scanner The scanner for reading input.
     * @return A Letter object representing the character for sorting.
     * @throws IllegalArgumentException If the input is not a single character.
     */
    private static Letter getInputChar(Scanner scanner) {
        System.out.println("\nВведіть літеру або число, за кількістю якої буде відсортовано слова:");
        StringBuffer input = new StringBuffer(scanner.nextLine());

        Word inputChar = new Word(input);

        if (inputChar.length() != 1) {
            throw new IllegalArgumentException("You must type one letter or digit!");
        }

        return new Letter(inputChar.charAt(0));
    }

    /**
     * Sorts all words in the given text by the number of occurrences of the specified character.
     *
     * @param text The Text object containing the sentences and words to sort.
     * @param targetChar The Letter character to use for sorting.
     * @return A Text object with words sorted by the target character count.
     */
    public static Text sortWordsByCharCount(Text text, Letter targetChar) {
        Word[] words = collectAllWordsFromText(text);

        stableSort(words, targetChar);

        insertSortedWordsIntoText(text, words);

        return text;
    }

    /**
     * Collects all words from the text for sorting purposes.
     *
     * @param text The Text object containing sentences with words.
     * @return An array of Word objects extracted from the text.
     */
    private static Word[] collectAllWordsFromText(Text text) {
        Word[] allWords = new Word[calculateTotalWords(text)];
        int wordIndex = 0;

        for (Sentence sentence : text.getSentences()) {
            for (SentenceElement element : sentence.getElements()) {
                if (element.isWord()) {
                    allWords[wordIndex++] = element.getWord();
                }
            }
        }

        return allWords;
    }

    /**
     * Calculates the total number of words in the text.
     *
     * @param text The Text object containing sentences with words.
     * @return The total count of words in the text.
     */
    private static int calculateTotalWords(Text text) {
        int count = 0;
        for (Sentence sentence : text.getSentences()) {
            for (SentenceElement element : sentence.getElements()) {
                if (element.isWord()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Inserts sorted words back into their original positions in the text.
     *
     * @param text The Text object to update with sorted words.
     * @param sortedWords The array of sorted Word objects.
     */
    private static void insertSortedWordsIntoText(Text text, Word[] sortedWords) {
        int wordIndex = 0;
        for (Sentence sentence : text.getSentences()) {
            for (int i = 0; i < sentence.getElements().length; i++) {
                SentenceElement element = sentence.getElements()[i];
                if (element.isWord()) {
                    sentence.replaceElement(i, sortedWords[wordIndex++]);
                }
            }
        }
    }

    /**
     * Performs a stable insertion sort on an array of words based on the occurrence count of a
     * specified character.
     *
     * @param words The array of Word objects to be sorted.
     * @param targetChar The Letter character used as the sorting criterion.
     */
    private static void stableSort(Word[] words, Letter targetChar) {
        for (int i = 1; i < words.length; i++) {
            Word key = words[i];
            int j = i - 1;
            int keyCount = key.countCharOccurrences(targetChar.getCharacter());

            while (j >= 0 && words[j].countCharOccurrences(targetChar.getCharacter()) > keyCount) {
                words[j + 1] = words[j];
                j--;
            }
            words[j + 1] = key;
        }
    }
}