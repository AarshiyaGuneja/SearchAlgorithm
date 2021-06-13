package search.algorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

public class Setup {

    private static LinkedHashMap<String, HashSet> instance;

    private Setup(){}

    static {
        instance = new LinkedHashMap<String, HashSet>();
    }

    /**
     *
     * @param filename
     * @return
     * @throws IOException
     */
    public static LinkedHashMap initialise (String filename) {

        instance.clear();

        String mappedObjects = null;

        StringBuilder relatedObject = new StringBuilder();

        List<String> words = new ArrayList<>();

        try {
            BufferedReader file = new BufferedReader( new FileReader(filename) ); // Open the file given as argument

            while ( true )
            {
                String word = file.readLine();  // read word
                if ( word == null ) break; // checks for end

                words.clear();
                relatedObject.setLength(0);
                word.trim();
                while ( !(word.startsWith("s") && Character.isDigit((word.charAt((1))))) && word != null)
                 {
                     words.add(word);
                     relatedObject.append(",");
                     relatedObject.append(word);
                     word = file.readLine();
                     if(word == null)
                         break;
                     word.trim();
                 }
                mappedObjects = relatedObject.toString();

                if (mappedObjects == null) continue;

                addEntryToHashMap(instance, words, mappedObjects);
            }
            file.close();
        }
        catch (Exception e) {
            System.out.println("The initialisation file could not be read, please ensure that it is in the correct location. " + e.getMessage());
        }

        return instance;
    }

    public static LinkedHashMap getInstance() {
        return instance;
    }


    /**
     * @param hashMap
     * @param words
     * @param values
     * Adds the word as the key and the list of objects as the value of the hashmap.
     * Checks for duplicates inside each list and only appends new object to the end.
     */
    public static void addEntryToHashMap(LinkedHashMap hashMap, List<String> words, String values) {

        for(String word : words) {
            HashSet<String> urlHashMap = (HashSet) hashMap.get(word);

            if (urlHashMap == null) {
                HashSet<String> hashSet = new HashSet<String>();
                hashSet.add(values);
                hashMap.put(word, hashSet);
            } else {
                urlHashMap.add(values);
            }
        }
    }
}
