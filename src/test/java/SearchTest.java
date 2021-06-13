import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import search.algorithm.Application;
import search.algorithm.Services.NetflixTitlesService;
import search.algorithm.Setup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SearchTest {

    @Autowired
    private NetflixTitlesService netflixTitlesService;

    @Test
    public void testSearch(){
        List<String> words = new ArrayList<>();
        words.add("India");
        LinkedHashMap<String, HashSet> hashMap = new LinkedHashMap<String, HashSet>();
        Setup.addEntryToHashMap(hashMap, words, "15-Aug");
        HashSet<String> results = netflixTitlesService.search("India", hashMap);
        assertTrue(results.contains("15-Aug"));
    }

    @Test
    public void testReader()
    {
        LinkedHashMap hashMap = Setup.initialise("src/main/resources/Data/data.txt");
        assertTrue(hashMap != null);
    }
}