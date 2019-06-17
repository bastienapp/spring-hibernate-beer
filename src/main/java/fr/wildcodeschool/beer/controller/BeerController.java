package fr.wildcodeschool.beer.controller;

import fr.wildcodeschool.beer.model.Beer;
import fr.wildcodeschool.beer.model.Brewer;
import fr.wildcodeschool.beer.repository.BeerRepository;
import fr.wildcodeschool.beer.repository.BrewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BrewerRepository brewerRepository;

    @PostMapping("/brewers/{brewerId}/beers")
    public Beer create(@PathVariable Long brewerId,
                       @RequestBody Beer beer) {
        Brewer brewer = brewerRepository.findById(brewerId).get();
        beer.setBrewer(brewer);
        return beerRepository.save(beer);
    }

    @GetMapping("/beers")
    public List<Beer> read() {
        return beerRepository.findAll();
    }

    @GetMapping("/beers/{id}")
    public Beer read(@PathVariable Long id) {
        return beerRepository.findById(id).get();
    }

    @PutMapping("/beers/{id}")
    public Beer update(@PathVariable Long id, @RequestBody Beer beer) {
        Beer beerToUpdate = beerRepository.findById(id).get();
        if (beer.getBrand() != null) {
            beerToUpdate.setBrand(beer.getBrand());
        }
        if (beer.getPrice() != null) {
            beerToUpdate.setPrice(beer.getPrice());
        }
        return beerRepository.save(beerToUpdate);
    }

    @DeleteMapping("/beers/{id}")
    public void delete(@PathVariable Long id) {
        beerRepository.deleteById(id);
    }
}
