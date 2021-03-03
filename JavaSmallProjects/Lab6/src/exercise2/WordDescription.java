package isp.lab6.exercise2;

import java.util.ArrayList;

public class WordDescription {
    private String description;
    private ArrayList<Word> synonyms = new ArrayList<>();

    public WordDescription(String description, ArrayList<Word> synonyms) {
        this.description = description;
        this.synonyms = synonyms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Word> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(ArrayList<Word> Synonyms) {
        this.synonyms = synonyms;
    }

    @Override
    public String toString() {
        return "WordDescription{" +
                "description='" + description + '\'' +
                ", synonyms=" + synonyms +
                '}' + '\n';
    }
}
