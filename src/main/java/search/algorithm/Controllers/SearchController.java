package search.algorithm.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import search.algorithm.Models.NetflixTitles;
import search.algorithm.Services.NetflixTitlesService;

import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    NetflixTitlesService netflixTitlesService;

    /** Searching keywords **/

    @GetMapping("/{keyword}")
    public ResponseEntity<HashSet<String>> search(@PathVariable String keyword) {
        HashSet<String> list = netflixTitlesService.getAllResults(keyword);
        return new ResponseEntity<HashSet<String>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<NetflixTitles>> findAll()
    {
        List<NetflixTitles> list = netflixTitlesService.findAll();
        return  new ResponseEntity<List<NetflixTitles>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
