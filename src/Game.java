import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private int currentQuestion; //word display
    private int currentLevel = 0;
    private Player player;
    private int chances = 10;
    public Game(int currentQuestion, int currentLevel, Player player) {
        this.currentQuestion = currentQuestion;
        this.currentLevel = currentLevel;
        this.player = player;
    }
    public void hangMan(int chances) {
        switch (chances){
            case 9:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 8:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 7:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println(" |   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 6:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|   |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 5:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 4:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/    |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 3:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|\\  |");
                System.out.println("/ \\  |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 2:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("\\|/  |");
                System.out.println("/ \\  |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            case 1:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("/|/  |");
                System.out.println("/ \\  |");
                System.out.println("     |");
                System.out.println("=========");
                break;
            default:
                System.out.println(" +---+");
                System.out.println(" |   |");
                System.out.println(" O   |");
                System.out.println("     |");
                System.out.println(" /|/ |");
                System.out.println(" / \\ |");
                System.out.println("=========");
                break;
        }


    }
    public String letterBank(){
        String letters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".toLowerCase(); //.toCharArray();
        return letters;
    }
    public void playGame(ArrayList<Word> wordsList, String type) {
        int levelOfPlayer = this.player.getLevel();
        for (int i = 0; i < wordsList.size(); i++) {
            int lives = this.chances;
            //System.out.println(wordsList.get(i).getWord());
            String currWord = wordsList.get(i).getWord().toLowerCase();
            String placeHolder = currWord.replaceAll("[a-zA-Z]", "_");
            System.out.println("Current word: " + placeHolder);
            Scanner sc = new Scanner(System.in);
            String currLetterBank = this.letterBank();
            List<String> removedLetters = new ArrayList<String>();
            List<String> inCorrectLetters = new ArrayList<String>();
            while(lives > 0){
                String incorrectLetterBank = inCorrectLetters.toString()
                        .replaceAll("\\[", "")
                        .replaceAll("\\]","")
                        .replace(",", " ");
                System.out.println("Letter Bank: " + currLetterBank);
                System.out.println("Incorrect Letters: " + incorrectLetterBank);
                String inputLetter = sc.nextLine();
                if(inputLetter.length() > 1){
                    System.out.println("Invalid input! Please input one letter each time!");
                    inputLetter = sc.nextLine();
                }
                if(removedLetters.contains(inputLetter)){
                    System.out.println("Invalid input! Please input the letter in Letter Bank!");
                    inputLetter = sc.nextLine();
                }
                if (currWord.contains(inputLetter)) {
                    int index = currWord.indexOf(inputLetter);
                    while (index >= 0) {
                        placeHolder = placeHolder.substring(0, index)
                                + inputLetter
                                + placeHolder.substring(index + 1);
                        index = currWord.indexOf(inputLetter, index + 1);
                        removedLetters.add(inputLetter);
                    }
                    currLetterBank = currLetterBank.replaceFirst(inputLetter+" ", "");
                } else {
                    lives = lives - 1;
                    currLetterBank = currLetterBank.replaceFirst(inputLetter+" ", "");
                    removedLetters.add(inputLetter);
                    inCorrectLetters.add(inputLetter);
                    System.out.println("You guessed it WRONG!");
                    hangMan(lives);
                    if(lives ==0){
                        break;
                    }
                }
                if (!placeHolder.contains("_")) {
                    System.out.println("Current word: " + placeHolder);
                    break;
                }
                else {System.out.println("Current word: " + placeHolder);}
            }
            if (!placeHolder.contains("_") && lives > 0) {
                currentLevel++;
                levelOfPlayer = currentLevel;
                System.out.println("=====You guessed the word right!" + "You are currently on level " + currentLevel +"====");
            }
            else{
                this.player.setLevel(levelOfPlayer);
                System.out.println("Correct word: "+ currWord);
                System.out.println("====You lost the game, you achieved "+ levelOfPlayer +" levels====");
                break;
            }

        }
        if(currentLevel == wordsList.size()){
            System.out.println("=====Congratulations! " +this.player.getName() +"! You won in " + type + " category====");
            System.out.println("=====You achieved " + levelOfPlayer+" levels==================================");
        }
    }

}
