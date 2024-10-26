package com.sachkomaxim.lab4.components;

/**
 * The Letter class represents a single letter in the alphabet or a single digit.
 */
public class Letter {
    private final char character;

    /** Constructs a Letter object with the specified value of character.
     *
     * @param character The character representing the letter.
     * @throws IllegalArgumentException If the provided character is not a letter or digit.
     */
    public Letter(char character) {
        if(!Character.isLetterOrDigit(character)) {
            throw new IllegalArgumentException("Tried to pass a non-letter-or-digit char as an argument of Letter constructor.");
        }
        this.character = character;
    }

    /**
     * Gets the character of the letter.
     *
     * @return The character of the letter.
     */
    public char getCharacter() {
        return character;
    }

    /**
     * Returns a string representation of the letter.
     *
     * @return A string representation of the Letter.
     */
    @Override
    public String toString() {
        return String.valueOf(character);
    }

    /**
     * Converts the character of this Letter to lowercase.
     *
     * @return The lowercase version of the character.
     */
    public char toLowerCase() {
        return Character.toLowerCase(character);
    }
}
