package fr.wildcodeschool.beer.controller;

import fr.wildcodeschool.beer.model.Beer;
import fr.wildcodeschool.beer.model.Brewer;
import fr.wildcodeschool.beer.model.Ingredient;
import fr.wildcodeschool.beer.repository.BeerRepository;
import fr.wildcodeschool.beer.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping("/ingredients")
    public Ingredient create(@RequestBody Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @PutMapping("/beers/{beerId}/ingredients/{ingredientId}")
    public Ingredient map(@PathVariable Long beerId,
                             @PathVariable Long ingredientId) {
        Beer beer = beerRepository.findById(beerId).get();
        Ingredient ingredient = ingredientRepository.findById(ingredientId).get();
        ingredient.getBeers().add(beer);
        beer.getIngredients().add(ingredient);
        beerRepository.save(beer);
        return ingredientRepository.save(ingredient);
    }

    @PostMapping("/beers/{beerId}/ingredients")
    public Ingredient createAndMap(@PathVariable Long beerId,
                             @RequestBody Ingredient ingredient) {
        Beer beer = beerRepository.findById(beerId).get();
        ingredient.getBeers().add(beer);
        beer.getIngredients().add(ingredient);
        beerRepository.save(beer);
        return ingredientRepository.save(ingredient);
    }
}
