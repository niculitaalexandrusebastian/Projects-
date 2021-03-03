package isp.lab6.Exercise1;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

import isp.lab6.exercise2.Dictionary;
import isp.lab6.exercise2.Word;
import isp.lab6.exercise2.WordDescription;
import org.junit.Test;

public class Exercise2Test {

    @Test
    public void testAddWordWithoutSynonyms() {
        Word word = new Word("random");
        WordDescription wordDescription = new WordDescription("Random Description", null);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        assertEquals(false, dictionary.addWord(word, wordDescription));

    }

    @Test
    public void testAddWordWithSynonyms() {
        Word word = new Word("random");
        Word wordDescription1 = new Word("It's");
        Word wordDescription2 = new Word("random");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(wordDescription1);
        synonymword1.add(wordDescription2);
        WordDescription wordDescription = new WordDescription("Random Description", synonymword1);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        assertEquals(false, dictionary.addWord(word, wordDescription));
    }

    @Test

    public void testDeleteWordButTheWordDoesntExist() {
        Word word = new Word("random");
        Word wordtodelete = new Word("delete");
        Word wordDescription1 = new Word("It's");
        Word wordDescription2 = new Word("random");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(wordDescription1);
        synonymword1.add(wordDescription2);
        WordDescription wordDescription = new WordDescription("Random Description", synonymword1);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        boolean k = dictionary.deleteWord(wordtodelete);
        assertEquals(false, k);

    }

    @Test
    public void testDeleteWordButTheWordExist() {
        Word word = new Word("random");
        Word wordtodelete = new Word("delete");
        Word wordDescription1 = new Word("It's");
        Word wordDescription2 = new Word("random");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(wordDescription1);
        synonymword1.add(wordDescription2);
        WordDescription wordDescription = new WordDescription("Random Description", synonymword1);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        dictionary.addWord(word, wordDescription);
        boolean k = dictionary.deleteWord(word);
        assertEquals(true, k);

    }

    @Test

    public void TestSearchWordButWordDoesntExist() {
        Word word = new Word("random");
        Word wordtodelete = new Word("delete");
        Word wordDescription1 = new Word("It's");
        Word wordDescription2 = new Word("random");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(wordDescription1);
        synonymword1.add(wordDescription2);
        WordDescription wordDescription = new WordDescription("Random Description", synonymword1);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        dictionary.addWord(word, wordDescription);
        assertEquals(null, dictionary.searchWord(wordtodelete));


    }


    @Test

    public void TestSearchWordButWordExist() {
        Word word = new Word("random");
        Word wordtodelete = new Word("delete");
        Word wordDescription1 = new Word("It's");
        Word wordDescription2 = new Word("random");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(wordDescription1);
        synonymword1.add(wordDescription2);
        WordDescription wordDescription = new WordDescription("Random Description", synonymword1);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        dictionary.addWord(word, wordDescription);
        assertEquals(wordDescription, dictionary.searchWord(word));


    }


    @Test
    public void TestFindSynonymButWeHaveSynonyms() {
        Word word = new Word("random");
        Word wordDescription1 = new Word("It's");
        Word wordDescription2 = new Word("random");
        ArrayList<Word> synonymword1 = new ArrayList<>();
        synonymword1.add(wordDescription1);
        synonymword1.add(wordDescription2);
        WordDescription wordDescription = new WordDescription("Random Description", synonymword1);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        dictionary.addWord(word, wordDescription);
        assertEquals(wordDescription.getSynonyms(), dictionary.findSynonyms(word));


    }

    @Test
    public void TestFindSynonymButWeDontGaveSynonyms() {
        Word word1 = new Word("random");
        WordDescription wordDescription = new WordDescription("Random Description", null);
        Dictionary dictionary = new Dictionary();
        dictionary.getInstance();
        assertEquals(null, dictionary.findSynonyms(word1));
    }

}
