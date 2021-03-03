package isp.lab6.exercise2;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Word word1 = new Word("Pisica");
        Word synonym1 = new Word("cat");
        Word synonym2 = new Word("chat");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(synonym1);
        synonymword1.add(synonym2);
        WordDescription wordDescription1 = new WordDescription("The pisica is a feline", synonymword1);

        Word word2 = new Word("Caine");
        Word synonym3 = new Word("Dog");
        Word synonym4 = new Word("Cane");
        Word synonym5 = new Word("Potaie");
        ArrayList<Word> synonymword2 = new ArrayList<>();
        synonymword2.add(synonym3);
        synonymword2.add(synonym4);
        synonymword2.add(synonym5);
        WordDescription wordDescription2 = new WordDescription("The Caine is a canine", synonymword2);

        Word word3 = new Word("Caine");
        Word synonym7 = new Word("Catel");
        Word synonym8 = new Word("Catalus");
        ArrayList<Word> synonymword3 = new ArrayList<>();
        synonymword3.add(synonym7);
        synonymword3.add(synonym8);
        WordDescription wordDescription3 = new WordDescription("Stapane,stapane,mai cheama s-un cane", synonymword3);

        dictionary.getInstance();

        Word word4 = new Word("Duck");
        dictionary.addWord(word1, wordDescription1);
        dictionary.addWord(word2, wordDescription2);
        dictionary.addWord(word3, wordDescription3);
        dictionary.addWord(word4, null);


        System.out.println(dictionary.getDictionary());
        System.out.println(dictionary.searchWord(word3));
        System.out.println(dictionary.findSynonyms(word4));

    }
}
