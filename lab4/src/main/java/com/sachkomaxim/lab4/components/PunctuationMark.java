package com.sachkomaxim.lab4.components;

/**
 * The PunctuationMark class represents a punctuation mark.
 */
public class PunctuationMark {
    private final char character;

    /**
     * Constructs a PunctuationMark object with the specified character.
     *
     * @param character The character representing the punctuation mark.
     * @throws IllegalArgumentException If the provided character is not a punctuation mark.
     */
    public PunctuationMark(char character) {
        if(Character.isLetterOrDigit(character) || Character.isWhitespace(character)) {
            throw new IllegalArgumentException("Tried to pass a non-punctuation-mark char as an argument of PunctuationMark constructor.");
        }
        this.character = character;
    }

    /**
     * Gets the character representing the punctuation mark.
     *
     * @return The character of the punctuation mark.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns a string representation of the punctuation mark.
     *
     * @return A string representation of the punctuation mark.
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }
}