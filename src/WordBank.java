import java.util.ArrayList;
import java.util.Collections;

public class WordBank implements IWordsBank {
    private ArrayList<Word> wordsList;
    private String type;

    public WordBank(ArrayList<Word> wordsList, String type) {
        this.wordsList = wordsList;
        this.type = type;
    }

//    public ArrayList<Word> getWordsList() {
//        return wordsList;
//    }
//
//    public void setWordsList(ArrayList<Word> wordsList) {
//        this.wordsList = wordsList;
//    }
//
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    //@Override
    public ArrayList initializeWordBank(){
        Collections.shuffle(this.wordsList);
        return this.wordsList;
    }
}
