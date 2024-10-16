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
        StringBuffer[] wordsAndPunctuation = splitTextAndPunctuation(text);
        StringBuffer[] sortedWords = sortWordsOnly(wordsAndPunctuation, targetChar);

        return mergeWordsAndPunctuation(wordsAndPunctuation, sortedWords);
    }

    public static StringBuffer[] splitTextAndPunctuation(StringBuffer text) {
        StringBuffer[] wordsAndPunctuation = new StringBuffer[text.length()];
        int count = 0;
        StringBuffer currentPart = new StringBuffer();
        boolean isWord = Character.isLetterOrDigit(text.charAt(0));

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (Character.isLetterOrDigit(currentChar)) {
                if (!isWord) {
                    if (currentPart.length() > 0) {
                        wordsAndPunctuation[count++] = currentPart;
                    }
                    currentPart = new StringBuffer();
                    isWord = true;
                }
                currentPart.append(currentChar);
            } else {
                if (isWord) {
                    if (currentPart.length() > 0) {
                        wordsAndPunctuation[count++] = currentPart;
                    }
                    currentPart = new StringBuffer();
                    isWord = false;
                }
                currentPart.append(currentChar);
            }
        }

        if (currentPart.length() > 0) {
            wordsAndPunctuation[count++] = currentPart;
        }

        StringBuffer[] result = new StringBuffer[count];
        System.arraycopy(wordsAndPunctuation, 0, result, 0, count);
        return result;
    }

    public static StringBuffer[] sortWordsOnly(StringBuffer[] wordsAndPunctuation, StringBuffer targetChar) {
        int wordCount = 0;

        for (StringBuffer part : wordsAndPunctuation) {
            if (Character.isLetterOrDigit(part.charAt(0))) {
                wordCount++;
            }
        }

        StringBuffer[] words = new StringBuffer[wordCount];
        int index = 0;
        for (StringBuffer part : wordsAndPunctuation) {
            if (Character.isLetterOrDigit(part.charAt(0))) {
                words[index++] = part;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (countCharOccurrences(words[i], targetChar.charAt(0)) > countCharOccurrences(words[j], targetChar.charAt(0))) {
                    StringBuffer temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }

        return words;
    }

    public static StringBuffer mergeWordsAndPunctuation(StringBuffer[] original, StringBuffer[] sortedWords) {
        StringBuffer result = new StringBuffer();
        int wordIndex = 0;

        for (StringBuffer part : original) {
            if (Character.isLetterOrDigit(part.charAt(0))) {
                result.append(sortedWords[wordIndex++]);
            } else {
                result.append(part);
            }
        }

        return result;
    }

    public static int countCharOccurrences(StringBuffer word, char targetChar) {
        int count = 0;
        char lowerCaseTargetChar = Character.toLowerCase(targetChar);
        for (int i = 0; i < word.length(); i++) {
            if (Character.toLowerCase(word.charAt(i)) == lowerCaseTargetChar) {
                count++;
            }
        }
        return count;
    }
}
