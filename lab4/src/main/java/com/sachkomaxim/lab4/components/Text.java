package com.sachkomaxim.lab4.components;

import java.util.Arrays;

/**
 * The Text class represents a text composed of sentences.
 */
public class Text {
    private final Sentence[] sentences;

    /**
     * Constructs a Text object from the provided StringBuffer.
     * <p>
     * This constructor cleans the input text by removing extra whitespace and splitting it into individual
     * sentences based on common sentence-ending punctuation (periods, exclamation marks, and question marks).
     * Each sentence is then trimmed of leading and trailing whitespace and stored as a Sentence object in the
     * sentences array.
     *
     * @param inputText The StringBuffer containing the input text.
     */
    public Text(StringBuffer inputText) {
        StringBuffer cleanedText = new StringBuffer(inputText.toString().replaceAll("[\\s]+", " "));
        String[] sentenceStrings = cleanedText.toString().split("(?<=[.!?])\\s+");
        sentences = new Sentence[sentenceStrings.length];
        for (int i = 0; i < sentenceStrings.length; i++) {
            sentences[i] = new Sentence(new StringBuffer(sentenceStrings[i].trim()));
        }
    }

    /**
     * Gets the array of sentences representing the text.
     *
     * @return The array of Sentence objects representing the text.
     */
    public Sentence[] getSentences() {
        return sentences;
    }

    /**
     * Returns a string representation of the text, combining all sentences into a single string.
     * <p>
     * This method iterates through the sentences stored in the sentences array, calling the toString()
     * method of each Sentence object. The individual sentence strings are concatenated into a single
     * string with a space separating each sentence. If there are no sentences, an empty string is returned.
     *
     * @return A string representation of the text, where sentences are separated by a single space.
     */
    @Override
    public String toString() {
        return Arrays.stream(sentences)
                .map(Sentence::toString)
                .reduce((s1, s2) -> s1 + " " + s2)
                .orElse("");
    }
}
