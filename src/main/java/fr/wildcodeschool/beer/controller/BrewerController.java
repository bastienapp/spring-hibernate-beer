package fr.wildcodeschool.beer.controller;

import fr.wildcodeschool.beer.model.Brewer;
import fr.wildcodeschool.beer.repository.BrewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrewerController{

    @Autowired
    private BrewerRepository repository;

    @GetMapping("/brewer")
    public List<Brewer> read() {
        return repository.findAll();
    }

    @GetMapping("/brewer/{id}")
    public Brewer read(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    @PostMapping("/brewer")
    public Brewer create(@RequestBody Brewer brewer) {
        return repository.save(brewer);
    }

    @PutMapping("/brewer/{id}")
    public Brewer update(@PathVariable Long id, @RequestBody Brewer broModif) {
        Brewer broBdd = repository.findById(id).get();
        broBdd.setName(broModif.getName());
        broBdd.setLocation(broModif.getLocation());
        return repository.save(broBdd);
    }

    @DeleteMapping("/brewer/{id}")
    public void delate(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
