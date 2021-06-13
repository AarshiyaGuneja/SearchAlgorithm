package search.algorithm.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import search.algorithm.Models.NetflixTitles;
import search.algorithm.Repositories.NetflixTitlesRepository;
import search.algorithm.Setup;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class NetflixTitlesService {

    @Autowired
    private NetflixTitlesRepository netflixTitlesRepository;

    public LinkedHashMap<String, HashSet> hashMap = Setup.getInstance();

    public List<NetflixTitles> findAll()
    {
        List<NetflixTitles> results = netflixTitlesRepository.findAll();
        return  results;
    }

    public HashSet<String> getAllResults(String searchQuery) {

        System.out.println("keyword: " + searchQuery);

        HashSet<String> searchResults = search(searchQuery, hashMap);
        if (searchResults.size() > 0) {
            return searchResults;
        } else {
            return new HashSet<>();
        }
    }

    public HashSet<String> search(String query, LinkedHashMap hashMap){

        String[] parts = query.split(" ");

        if (query.length() == 0) return null;

        if (parts.length == 1) return handleSimpleSearch(hashMap, parts[0]);

        if (parts.length == 3)
        {
            HashSet<String> resultsOne = (HashSet) hashMap.get(parts[0]);
            HashSet<String> tmpResultsOne = (HashSet<String>) resultsOne.clone();
            HashSet<String> resultsTwo = (HashSet) hashMap.get(parts[2]);
            HashSet<String> tmpResultsTwo = (HashSet<String>) resultsTwo.clone();

            if (parts[1].equals("OR")) return handleOrSearch(tmpResultsOne, tmpResultsTwo);

            if (parts[1].equals("AND")) return handleAndSearch(tmpResultsOne, tmpResultsTwo);
        }
        return null;
    }

    /**
     * Performs a query on a single word.
     * @param hashMap
     * @param query
     * @return
     */
    private static HashSet<String> handleSimpleSearch (LinkedHashMap hashMap, String query) {
        return (HashSet) hashMap.get(query);
    }

    /**
     * Performs the OR search on two words.
     * @return
     */
    private static HashSet<String> handleOrSearch (HashSet<String> resultOne, HashSet<String> resultTwo) {

        if (resultOne == null && resultTwo == null) return null;

        if (resultOne == null) return resultTwo;

        if (resultTwo == null) return resultOne;


        resultOne.addAll(resultTwo);
        return resultOne;
    }

    /**
     * Performs the AND search on two words.
     * @return
     */
    private static HashSet<String> handleAndSearch (HashSet<String> resultOne, HashSet<String> resultTwo) {

        if (resultOne == null || resultTwo == null) return null;

        resultOne.retainAll(resultTwo);

        return resultOne;
    }
}
