package isp.lab6.exercise2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Dictionary {
    private static Dictionary INSTANCE;
    private static Map<Word, WordDescription> descriptionByWords;

    public static Dictionary getInstance() {
        if (Objects.isNull(INSTANCE)) {
            INSTANCE = new Dictionary();
            descriptionByWords = new HashMap<>();

        }
        return INSTANCE;
    }


    public static Map<Word, WordDescription> getDictionary() {
        return descriptionByWords;
    }

    public boolean addWord(Word word, WordDescription wordDescription) {
        boolean check = false;
        if (descriptionByWords.containsKey(word)) {
            check = true;
            descriptionByWords.replace(word, wordDescription);
        }

        if (!check && word != null && wordDescription != null && wordDescription.getSynonyms() != null && !wordDescription.getSynonyms().isEmpty()) {
            descriptionByWords.put(word, wordDescription);
            return true;
        }

        return false;

    }

    public boolean deleteWord(Word word) {
        if (descriptionByWords.containsKey(word) && word != null) {
            descriptionByWords.remove(word);
            return true;
        }
        return false;
    }

    public WordDescription searchWord(Word word) {
        return descriptionByWords.get(word);

    }

    public List<Word> findSynonyms(Word word) {
        if (descriptionByWords.get(word) == null) {
            return null;
        }
        return descriptionByWords.get(word).getSynonyms();
    }


}

