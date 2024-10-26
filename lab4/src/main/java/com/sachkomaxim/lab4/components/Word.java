package com.sachkomaxim.lab4.components;

/**
 * The Word class represents a word composed of letters.
 */
public class Word {
    private final Letter[] letters;

    /**
     * Constructs a Word object using the provided StringBuffer.
     *
     * @param word The StringBuffer containing the word's letters.
     */
    public Word(StringBuffer word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    /**
     * Gets the array of letters representing the word.
     *
     * @return The array of letters representing the word.
     */
    public Letter[] getLetters() {
        return letters;
    }

    /**
     * Returns a string representation of the word.
     *
     * @return A string representation of the word.
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Letter letter : letters) {
            result.append(letter.getCharacter());
        }
        return result.toString();
    }

    /**
     * Counts the occurrences of a specified character in the word, ignoring case.
     *
     * @param targetChar The character to count occurrences of.
     * @return The number of occurrences of targetChar in the word.
     */
    public int countCharOccurrences(char targetChar) {
        int count = 0;
        for (Letter letter : letters) {
            if (letter.toLowerCase() == Character.toLowerCase(targetChar)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Gets the length of the word.
     *
     * @return The number of letters in the word.
     */
    public int length() {
        return letters.length;
    }

    /**
     * Gets the character (letter) at the specified index in the word.
     *
     * @param i The index of the character to retrieve.
     * @return The character (letter) at the specified index.
     */
    public char charAt(int i) {
        return letters[i].getCharacter();
    }
}
