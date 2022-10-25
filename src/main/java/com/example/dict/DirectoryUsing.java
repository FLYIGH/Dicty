package com.example.dict;

import java.util.HashMap;

public class DirectoryUsing {
    private HashMap<String, String> dictionary;
    DirectoryUsing()
    {
        dictionary = new HashMap<>();
        addWord("angad", "im the meaning ✌");
        addWord("acciojob", "placement");
        addWord("aesthetic", "concered with beauty or art");
        addWord("Solitary ", "Alone");
        addWord("Almanack", "Diary");
        addWord("Serene", "Calm");
        addWord("Ecstatic", "Very excited");
        addWord("solitude", "Happy while being alone");
        addWord("dog", "opposite of cat");
        addWord("Famished", "extremly hungry");
        addWord("hobies", "love of life");
        addWord("family ", "Everything ");
        addWord("Music", "realise a stress");
        addWord("assimilate", "to learn something new");
        addWord("Cricket ", "is a game");
    }
    public boolean addWord(String word, String meaning)
    {
        dictionary.put(word,meaning);
        return true;
    }
    public  String findMeaning(String word)
    {
        if(!dictionary.containsKey(word))
            return "sorry bro ,next time for sure!, keep learning";
        else
            return dictionary.get(word);
    }


}
