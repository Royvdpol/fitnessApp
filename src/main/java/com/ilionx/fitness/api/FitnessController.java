package com.ilionx.fitness.api;

import com.ilionx.fitness.model.Dumbbell;
import com.ilionx.fitness.service.DumbbellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/fitness")
public class FitnessController {

    @Autowired
    private DumbbellService dumbbellService;

    @GetMapping
    public ResponseEntity<Iterable<Dumbbell>> list() {
        return ResponseEntity.ok(this.dumbbellService.findAll());
    }

    @PostMapping
    public ResponseEntity<Dumbbell> create(@RequestBody Dumbbell dumbbell) {
        return ResponseEntity.ok(this.dumbbellService.save(dumbbell));
    }

    @GetMapping("getbyid/{id}")
    public ResponseEntity<Dumbbell> findById(@PathVariable long id) {
        Optional<Dumbbell> optionalDumbbell = this.dumbbellService.findById(id);
        if (optionalDumbbell.isPresent()) {
            return ResponseEntity.ok(optionalDumbbell.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Dumbbell> updateById(@PathVariable long id, @RequestBody Dumbbell source) {
        Optional<Dumbbell> optionalDumbbell = this.dumbbellService.findById(id);
        if (optionalDumbbell.isPresent()) {
            Dumbbell target = optionalDumbbell.get();
            target.setWeight(source.getWeight());
            target.setMaterial(source.getMaterial());
            return ResponseEntity.ok(this.dumbbellService.save(target));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        Optional<Dumbbell> optionalDumbbell = this.dumbbellService.findById(id);
        if (optionalDumbbell.isPresent()) {
            this.dumbbellService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
