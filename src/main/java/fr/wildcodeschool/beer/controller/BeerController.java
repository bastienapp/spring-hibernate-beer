package fr.wildcodeschool.beer.controller;

import fr.wildcodeschool.beer.model.Beer;
import fr.wildcodeschool.beer.model.Brewer;
import fr.wildcodeschool.beer.repository.BeerRepository;
import fr.wildcodeschool.beer.repository.BrewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BrewerRepository brewerRepository;

    @PostMapping("/brewer/{brewerId}/beer")
    public Beer create(@PathVariable Long brewerId,
                       @RequestBody Beer beer) {
        Brewer brewer = brewerRepository.findById(brewerId).get();
        beer.setBrewer(brewer);
        return beerRepository.save(beer);
    }
}
