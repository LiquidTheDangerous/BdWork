package org.semenovao.bd_work.restControllers;

import org.semenovao.bd_work.domain.Faculty.Faculty;
import org.semenovao.bd_work.repository.FacultyRepository;
import org.semenovao.bd_work.service.Faculty.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    final FacultyService facultyService;

    final FacultyRepository facultyRepository;

    public FacultyController(FacultyService facultyService, FacultyRepository facultyRepository) {
        this.facultyService = facultyService;
        this.facultyRepository = facultyRepository;
    }

    @GetMapping("/getAll")
    List<Faculty> getAll() {
        return facultyService.getAll();
    }


    @GetMapping("/getById/{id}")
    Optional<Faculty> getById(@PathVariable("id") Long id) {
        return facultyService.getById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<Faculty> deleteById(@PathVariable("id") Long id){
        facultyService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Faculty> update(@PathVariable("id") Long id,@RequestBody Faculty faculty){
        faculty.setId(id);
        facultyService.update(faculty);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<Faculty> create(@RequestBody Faculty faculty){
        var result = this.facultyService.save(faculty);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
