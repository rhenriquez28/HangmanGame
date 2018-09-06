import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int amountOfGuessesLeft = 8;
        boolean wordComplete = false;
        Random randGenerator = new Random();
        HangmanLexicon lex = new HangmanLexicon();
        int amountOfWords = lex.getWordCount();
        String wordSelected = lex.getWord(randGenerator.nextInt(amountOfWords));
        char[] wordLetters = wordSelected.toCharArray();
        String filteredWord = "";
        for(int i = 0; i < wordSelected.length(); i++){
            filteredWord+="_";
        }
        String guess = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Hangman!");
        while(amountOfGuessesLeft > 0 && !wordComplete){
            System.out.println("The word now looks like this: " + filteredWord);
            System.out.println("You have " + amountOfGuessesLeft + " guesses left");
            System.out.print("Your guess: ");
            try {
                guess = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            if(guess.length() == 0 || guess.length() > 1){
                System.out.println("Please just type one letter. Try again.");
            }else if(wordSelected.contains(guess) || wordSelected.contains(guess.toUpperCase())){
                System.out.println("That guess is correct.");
                filteredWord = showGuess(filteredWord, wordLetters,  guess.toUpperCase().charAt(0));
                if(!filteredWord.contains("_")){
                    wordComplete = true;
                }
            }else{
                System.out.println("There are no " + guess.toUpperCase() + "'s in this word.");
                amountOfGuessesLeft--;
            }
        }
        if(wordComplete){
            System.out.println("You guessed the word: " + wordSelected);
            System.out.println("You win.");
        }else{
            System.out.println("You are completely hung.");
            System.out.println("The word was: " + wordSelected);
            System.out.println("You lose.");
        }
    }
	
	/*private static Character[] filterLetters(char[] wordLetters){
		ArrayList<Character> wordLettersFiltered = new ArrayList<Character>();
		for(char letter : wordLetters){
			if(wordLettersFiltered.size() == 0){
				wordLettersFiltered.add(letter);
			}else if(!wordLettersFiltered.contains(letter)){
				wordLettersFiltered.add(letter);
			}
		}
		Character[] finalLetterArray = wordLettersFiltered.toArray(new Character[wordLettersFiltered.size()]);
		return finalLetterArray;
	}*/

    private static String showGuess(String filteredWord, char[] wordLetters, char guess){
        String newWord = "";
        StringBuilder sb = new StringBuilder(filteredWord);
        for(int i = 0; i < wordLetters.length; i++){
            if(guess == wordLetters[i]){
                sb.setCharAt(i, guess);
            }
        }
        newWord = sb.toString();
        return newWord;
    }

}