package fr.wildcodeschool.beer.repository;

import fr.wildcodeschool.beer.model.Brewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrewerRepository extends JpaRepository<Brewer, Long >{

}
