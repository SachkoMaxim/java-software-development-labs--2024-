package com.sachkomaxim.lab4.components;

/**
 * The SentenceElement class represents an element of a sentence,
 * which can be either a word or a punctuation mark.
 */
public class SentenceElement {
    private final Word word;
    private final PunctuationMark punctuation;

    /**
     * Constructs a SentenceElement object with a specified word.
     *
     * @param word The word associated with this sentence element.
     */
    public SentenceElement(Word word) {
        this.word = word;
        this.punctuation = null;
    }

    /**
     * Constructs a SentenceElement object with a specified punctuation mark.
     *
     * @param punctuation The punctuation mark associated with this sentence element.
     */
    public SentenceElement(PunctuationMark punctuation) {
        this.punctuation = punctuation;
        this.word = null;
    }

    /**
     * Checks if this sentence element is a word.
     *
     * @return True if this element is a word;
     *         false otherwise.
     */
    public boolean isWord() {
        return word != null;
    }

    /**
     * Gets the word associated with this sentence element.
     *
     * @return The word if this element is a word;
     *         null otherwise.
     */
    public Word getWord() {
        return word;
    }

    /**
     * Checks if this sentence element is a punctuation mark.
     *
     * @return True if this element is a punctuation mark;
     *         false otherwise.
     */
    public boolean isPunctuation() {
        return punctuation != null;
    }

    /**
     * Gets the punctuation mark associated with this sentence element.
     *
     * @return The punctuation mark if this element is a punctuation mark;
     *         null otherwise.
     */
    public PunctuationMark getPunctuation() {
        return punctuation;
    }

    /**
     * Returns a string representation of this sentence element.
     *
     * @return A string representation of the word or punctuation mark.
     */
    @Override
    public String toString() {
        return isWord() ? word.toString() : punctuation.toString();
    }
}
