package fr.wildcodeschool.beer.controller;

import fr.wildcodeschool.beer.model.Brewer;
import fr.wildcodeschool.beer.repository.BrewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrewerController {

    @Autowired
    private BrewerRepository brewerRepository;

    @GetMapping("/brewers")
    public List<Brewer> read() {
        return brewerRepository.findAll();
    }

    @GetMapping("/brewers/{id}")
    public Brewer read(@PathVariable Long id) {
        return brewerRepository.findById(id).get();
    }

    @PostMapping("/brewers")
    public Brewer create(@RequestBody Brewer brewer) {
        return brewerRepository.save(brewer);
    }

    @PutMapping("/brewers/{id}")
    public Brewer update(@PathVariable Long id, @RequestBody Brewer brewer) {
        Brewer brewerToUpdate = brewerRepository.findById(id).get();
        if (brewer.getName() != null) {
            brewerToUpdate.setName(brewer.getName());
        }
        if (brewer.getLocation() != null) {
            brewerToUpdate.setLocation(brewer.getLocation());
        }
        return brewerRepository.save(brewerToUpdate);
    }

    @DeleteMapping("/brewers/{id}")
    public void delete(@PathVariable Long id) {
        brewerRepository.deleteById(id);
    }
}
