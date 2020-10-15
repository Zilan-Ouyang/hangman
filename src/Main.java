import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InputMismatchException {
        ArrayList<Word> musicWords = new ArrayList<Word>();
        Word music1 = new Word("Radiohead", "Music");
        Word music2 = new Word("Joji", "Music");
        Word music3 = new Word("The Vaccines", "Music");
        Word music4 = new Word("The Libertines", "Music");
        Word music5 = new Word("Gorillaz", "Music");
        Word music6 = new Word("Glass Animals", "Music");
        Word music7 = new Word("Taylor Swift", "Music");
        musicWords.add(music1);
        musicWords.add(music2);
        musicWords.add(music3);
        musicWords.add(music4);
        musicWords.add(music5);
        musicWords.add(music6);
        musicWords.add(music7);
        MusicWord musicList = new MusicWord(musicWords);

        ArrayList<Word> sportsWords = new ArrayList<Word>();
        Word sports1 = new Word("Basketball", "Sports");
        Word sports2 = new Word("Hockey", "Sports");
        Word sports3 = new Word("Tennis", "Sports");
        Word sports4 = new Word("Soccer", "Sports");
        Word sports5 = new Word("running", "Sports");
        sportsWords.add(sports1);
        sportsWords.add(sports2);
        sportsWords.add(sports3);
        sportsWords.add(sports4);
        sportsWords.add(sports5);
        SportWords sportsList = new SportWords(sportsWords);

        ArrayList<Word> cryptoWords = new ArrayList<Word>();
        Word crypto1 = new Word("dai", "Crypto");
        Word crypto2 = new Word("chainlink", "Crypto");
        Word crypto3 = new Word("xrp", "Crypto");
        Word crypto4 = new Word("zcash", "Crypto");
        Word crypto5 = new Word("loopring", "Crypto");
        Word crypto6 = new Word("monero", "Crypto");
        Word crypto7 = new Word("esg", "Crypto");
        cryptoWords.add(crypto1);
        cryptoWords.add(crypto2);
        cryptoWords.add(crypto3);
        cryptoWords.add(crypto4);
        cryptoWords.add(crypto5);
        cryptoWords.add(crypto6);
        cryptoWords.add(crypto7);
        CryptoWords cryptoList = new CryptoWords(cryptoWords);

        //initiate player
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your name?");
        String playerName = sc.nextLine();
        Player currPlayer = new Player(playerName, 0);
        int selection;
        boolean exit = false;
        while (!exit)
        {
            System.out.println("Hi! " + currPlayer.getName());
            System.out.println("Menu: ");
            System.out.println("Type any number between 1 and 3");
            System.out.println("1) Start the game");
            System.out.println("2) View the rules of the game");
            System.out.println("3) Exit the game");
            try{
                selection = sc.nextInt();
                switch (selection)
                {
                    case 1 :
                        boolean inGame = true;
                        while(inGame){
                            System.out.println("Please select a word category: ");
                            System.out.println("1. Sports");
                            System.out.println("2. Music Artists");
                            System.out.println("3. Crypto");
                            int selectedCategory = sc.nextInt();
                            //Player player = new Player(playerName,1);
                            switch (selectedCategory){
                                case 1: //Sports
                                    Game sportsGame = new Game(0, 0, currPlayer);
                                    sportsGame.playGame(sportsList.initializeWordBank(), "sports");
                                    //sports game starts
                                    //player chances check
                                    break;
                                case 2: //music
                                    Game musicGame = new Game(0, 0, currPlayer);
                                    musicGame.playGame(musicList.initializeWordBank(), "music");
                                    break;
                                case 3: //crypto
                                    Game cryptoGame = new Game(0, 0, currPlayer);
                                    cryptoGame.playGame(cryptoList.initializeWordBank(), "crypto");
                                    break;
                                default:
                                    System.out.println("Invalid input, please try again!");
                            }
                        }
                        break;

                    case 2 :
                        Scanner exitToMenuKey = new Scanner(System.in);
                        System.out.println("Instructions of the game:");
                        System.out.println("1. This is a single player game. ");
                        System.out.println("2. Choose a word category.");
                        System.out.println("3. Each word represents a level, players have to reach level 5 (guess 5 words correctly) to win the game.");
                        System.out.println("4. Player needs to choose a letter from the letter bank to see if the letter is contained in the word.");
                        System.out.println("5. The correct letter would be revealed in everywhere it would appear.");
                        System.out.println("4. Players would have 10 chances to guess the word, for every incorrect input letter, player would lose one chance.");
                        System.out.println("5. Player would lose the game if they used up all of their chances.");
                        System.out.println("==========================================================================");
                        System.out.println("Press 0 to go back to the previous menu.");
                        while(true){
                            int input = exitToMenuKey.nextInt();
                            if(input == 0){
                                break;
                            }
                            else {
                                System.out.println("Invalid Input!");
                            }
                        }
                        break;
                    case 3 :
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input, please try again!");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input! Your Input has to be a number!");
                sc.next();
            }

        }
    }
}
