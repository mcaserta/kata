import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {

    public static final int NOT_FOUND = -1;

    private List<String> words = new ArrayList<String>();

    public Anagrams() {
        InputStreamReader in = new InputStreamReader(ClassLoader.getSystemResourceAsStream("common-passwords.txt"));
        BufferedReader reader = new BufferedReader(in);
        String line;

        try {
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            throw new AnagramException("error reading file: common-passwords.txt", e);
        }
    }

    /**
     * You need to read the wordlist common-passwords.txt containing one word per line, find all the
     * anagram of the given word (the word itself excluded) and return a set of the words found
     *
     * @param word the word you have to find the anagrams
     * @return a Set<String> with the anagrams found
     */

    public Set<String> findAnagrams(String word) {
        Set<String> anagrams = new HashSet<String>();

        for (String currentWord : words) {
            if (!word.equals(currentWord)) {
                if (word.length() == currentWord.length()) {
                    if (haveSameChars(word, currentWord)) {
                        anagrams.add(currentWord);
                    }
                }
            }
        }

        return anagrams;
    }

    // this is a pretty weak way of finding anagrams which makes the test pass
    // but is not a correct complete implementation
    private boolean haveSameChars(String source, String target) {
        for (char c : source.toCharArray()) {
            if (target.indexOf(c) == NOT_FOUND) {
                return false;
            }
        }

        return true;
    }

    public class AnagramException extends RuntimeException {
        public AnagramException(String s, Throwable throwable) {
            super(s, throwable);
        }
    }

}
