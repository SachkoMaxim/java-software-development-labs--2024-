package com.sachkomaxim.lab4.components;

/**
 * The Sentence class represents a sentence composed of words and punctuation marks.
 */
public class Sentence {
    private final SentenceElement[] elements;
    private final int[] spaceIndices;

    /**
     * Constructs a Sentence object from the provided StringBuffer,
     * identifying and categorizing sentence elements as words or
     * punctuation marks.
     * <p>
     * Also, there is a tracking for spaces to correctly reconstruct
     * the sentence with spaces later.
     *
     * @param sentence The input StringBuffer representing the sentence.
     */
    public Sentence(StringBuffer sentence) {
        int elementCount = 0;
        int spaceCount = 0;

        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isLetterOrDigit(sentence.charAt(i))) {
                while (i < sentence.length() && Character.isLetterOrDigit(sentence.charAt(i))) {
                    i++;
                }
                elementCount++;
                i--;
            } else if (!Character.isWhitespace(sentence.charAt(i))) {
                elementCount++;
            } else {
                spaceCount++;
            }
        }

        elements = new SentenceElement[elementCount];
        spaceIndices = new int[spaceCount];

        int elementIndex = 0;
        int spaceIndexCounter = 0;
        StringBuffer currentWord = new StringBuffer();

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {
                currentWord.append(currentChar);
            } else if (!Character.isWhitespace(currentChar)) {
                if (!currentWord.isEmpty()) {
                    elements[elementIndex++] = new SentenceElement(new Word(new StringBuffer(currentWord)));
                    currentWord.setLength(0);
                }
                elements[elementIndex++] = new SentenceElement(new PunctuationMark(currentChar));
            } else {
                if (!currentWord.isEmpty()) {
                    elements[elementIndex++] = new SentenceElement(new Word(new StringBuffer(currentWord)));
                    currentWord.setLength(0);
                }
                spaceIndices[spaceIndexCounter++] = elementIndex;
            }
        }

        if (!currentWord.isEmpty()) {
            elements[elementIndex] = new SentenceElement(new Word(new StringBuffer(currentWord)));
        }
    }

    /**
     * Gets the elements of the sentence.
     *
     * @return An array of SentenceElement representing the words and punctuation marks.
     */
    public SentenceElement[] getElements() {
        return elements;
    }

    /**
     * Gets the indices of spaces in the sentence.
     *
     * @return An array of indices where spaces occur.
     */
    public int[] getSpaceIndices() {
        return spaceIndices;
    }

    /**
     * Returns a string representation of the sentence.
     *
     * @return A string that represents the entire sentence, including spaces.
     */
    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < elements.length; i++) {
            result.append(elements[i].toString());
            for (int spaceIndex : spaceIndices) {
                if (spaceIndex == i + 1) {
                    result.append(" ");
                }
            }
        }

        return result.toString();
    }

    /**
     * Replaces an existing word at the specified index with a new word
     * in the sentence.
     *
     * @param index The index of the word to replace.
     * @param newWord The new Word to replace the existing one.
     */
    public void replaceElement(int index, Word newWord) {
        if(elements[index].isWord()) {
            elements[index] = new SentenceElement(newWord);
        }
    }
}
