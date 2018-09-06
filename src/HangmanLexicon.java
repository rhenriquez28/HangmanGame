/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

public class HangmanLexicon {
    /** Returns the number of words in the lexicon. */
    public int getWordCount() {
        return 10;
    }
    /** Returns the word at the specified index. */
    public String getWord(int index) {
        String selectedWord = "";
        switch (index) {
            case 0: selectedWord = "BUOY"; break;
            case 1: selectedWord = "COMPUTER"; break;
            case 2: selectedWord = "CONNOISSEUR"; break;
            case 3: selectedWord = "DEHYDRATE"; break;
            case 4: selectedWord = "FUZZY"; break;
            case 5: selectedWord = "HUBBUB"; break;
            case 6: selectedWord = "KEYHOLE"; break;
            case 7: selectedWord = "QUAGMIRE"; break;
            case 8: selectedWord = "SLITHER"; break;
            case 9: selectedWord = "ZIRCON"; break;
        }
        return selectedWord;
    }
}