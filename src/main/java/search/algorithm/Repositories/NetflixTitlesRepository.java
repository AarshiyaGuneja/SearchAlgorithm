package search.algorithm.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import search.algorithm.Models.NetflixTitles;

import java.util.List;

@Repository
public interface NetflixTitlesRepository extends JpaRepository<NetflixTitles, Integer> {
    List<NetflixTitles> findAll();
}

