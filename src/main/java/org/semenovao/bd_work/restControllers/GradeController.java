package org.semenovao.bd_work.restControllers;

import org.semenovao.bd_work.domain.Grade.Grade;
import org.semenovao.bd_work.domain.Grade.GradeControlEventType;
import org.semenovao.bd_work.domain.Grade.GradeControlEventTypeView;
import org.semenovao.bd_work.repository.GradeControlEventTypeRepository;
import org.semenovao.bd_work.repository.GradeControlEventTypeViewRepository;
import org.semenovao.bd_work.service.Grade.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;
    private final GradeControlEventTypeViewRepository gradeControlEventTypeViewRepository;
    private final GradeControlEventTypeRepository gradeControlEventTypeRepository;
    public GradeController(GradeService gradeService, GradeControlEventTypeViewRepository gradeControlEventTypeViewRepository, GradeControlEventTypeRepository gradeControlEventTypeRepository) {
        this.gradeService = gradeService;
        this.gradeControlEventTypeViewRepository = gradeControlEventTypeViewRepository;
        this.gradeControlEventTypeRepository = gradeControlEventTypeRepository;
    }

    @GetMapping("/getAll")
    List<Grade> getAll(){
        return gradeService.getAll();
    }
    @GetMapping("/gradeEventTypeView/getAll")
    List<GradeControlEventTypeView> getAllGradeControlEventTypeView(){
        return gradeControlEventTypeViewRepository.findAllView();
    }

    @GetMapping("/controlEventType/getAll")
    List<GradeControlEventType> getAllGradeControlEventType(){
        return gradeControlEventTypeRepository.findAll();
    }

    @PostMapping("/create")
    ResponseEntity<Grade> create(@RequestBody Grade grade){
        return new ResponseEntity<>(gradeService.save(grade), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Grade> update(@PathVariable("id") Long id, @RequestBody Grade grade ){
        return new ResponseEntity<>(gradeService.update(grade),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Grade> delete(@PathVariable("id") Long id){
        gradeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
