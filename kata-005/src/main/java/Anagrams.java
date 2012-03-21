import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {

    private List<String> words = new ArrayList<String>();

    public Anagrams() {
        InputStreamReader in = new InputStreamReader(ClassLoader.getSystemResourceAsStream("common-passwords.txt"));
        BufferedReader reader = new BufferedReader(in);
        String line;

        try {
            while ( (line = reader.readLine()) != null) {
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
        
        return anagrams;
    }
    
    public Set<String> allPermutations(String word) {
        Set<String> anagrams = new HashSet<String>();

        String permutation = rotate(word);

        return anagrams;
    }

    private String rotate(String in) {
        return in.substring(1) + in.charAt(0);
    }

    public class AnagramException extends RuntimeException {
        public AnagramException(String s, Throwable throwable) {
            super(s, throwable);
        }
    }

}
