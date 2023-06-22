package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.Discipline.*;
import org.semenovao.bd_work.service.Discipline.DisciplineLecturerService;
import org.semenovao.bd_work.service.Discipline.DisciplineLecturerStudyGroupService;
import org.semenovao.bd_work.service.Discipline.DisciplineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {
    private final DisciplineService disciplineService;
    private final DisciplineLecturerService disciplineLecturerService;

    @PersistenceContext
    EntityManager em;
    private final DisciplineLecturerStudyGroupService disciplineLecturerStudyGroupService;

    public DisciplineController(DisciplineService disciplineService, DisciplineLecturerService disciplineLecturerService, DisciplineLecturerStudyGroupService disciplineLecturerStudyGroupService) {
        this.disciplineService = disciplineService;
        this.disciplineLecturerService = disciplineLecturerService;
        this.disciplineLecturerStudyGroupService = disciplineLecturerStudyGroupService;
    }

    @GetMapping("/fullDescription/getAll")
    List<DisciplineLecturerView> getAllFullDescription() {
        return disciplineService.getAllFullView();
    }

    @GetMapping("/getAll")
    List<Discipline> getAll() {
        return disciplineService.getAll();
    }

    @PostMapping("/create")
    ResponseEntity<Discipline> create(@RequestBody Discipline discipline) {
        return new ResponseEntity<Discipline>(disciplineService.save(discipline), HttpStatus.OK);
    }

    @PostMapping("/disciplineLecturer/create")
    ResponseEntity<DisciplineLecturer> createDisciplineLecturer(@RequestBody DisciplineLecturer dl) {
        return new ResponseEntity<DisciplineLecturer>(disciplineLecturerService.save(dl), HttpStatus.OK);
    }

    @GetMapping("/disciplineLecturer/getAll")
    List<DisciplineLecturer> getAllDisciplineLecturer() {
        return disciplineLecturerService.getAll();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Discipline> update(@PathVariable("id") Long id, @RequestBody Discipline discipline) {
        discipline.setId(id);
        var result = disciplineService.update(discipline);
        return new ResponseEntity<Discipline>(result, HttpStatus.OK);
    }

    @GetMapping("/disciplineLecturerStudyGroup/getAll")
    List<DisciplineLecturerStudyGroup> getAllDisciplineLecturerStudyGroup() {
        return disciplineLecturerStudyGroupService.getAll();
    }

    @PostMapping("/disciplineLecturerStudyGroup/create")
    ResponseEntity<DisciplineLecturerStudyGroup> createDisciplineLecturerStudyGroup(@RequestBody DisciplineLecturerStudyGroup disciplineLecturerStudyGroup) {
        return new ResponseEntity<>(disciplineLecturerStudyGroupService.save(disciplineLecturerStudyGroup), HttpStatus.OK);
    }

    @PutMapping("/disciplineLecturerStudyGroup/update/{id}")
    ResponseEntity<DisciplineLecturerStudyGroup> updateDisciplineLecturerStudyGroup(@PathVariable("id") Long id, @RequestBody DisciplineLecturerStudyGroup disciplineLecturerStudyGroup) {
        disciplineLecturerStudyGroup.setId(id);
        return new ResponseEntity<>(disciplineLecturerStudyGroupService.update(disciplineLecturerStudyGroup), HttpStatus.OK);
    }

    @DeleteMapping("/disciplineLecturerStudyGroup/delete/{id}")
    ResponseEntity<DisciplineLecturerStudyGroup> deleteDisciplineLecturerStudyGroup(@PathVariable("id") Long id){
        disciplineLecturerStudyGroupService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/disciplineLecturerStudyGroup/fullDescription/getAll")
    List<DisciplineLecturerGroupView> getAllDisciplineLecturerView(){
        return em.createNativeQuery("SELECT * FROM discipline_lecturer_group_view", DisciplineLecturerGroupView.class).getResultList();
    }

}
