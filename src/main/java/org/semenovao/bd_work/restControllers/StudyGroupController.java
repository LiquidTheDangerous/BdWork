package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.StudyGroup.*;
import org.semenovao.bd_work.service.StudyGroup.ShortStudyGroupService;
import org.semenovao.bd_work.service.StudyGroup.StudyGroupBaseService;
import org.semenovao.bd_work.service.StudyGroup.StudyGroupPostfixService;
import org.semenovao.bd_work.service.StudyGroup.StudyGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studyGroup")
public class StudyGroupController {

    final
    ShortStudyGroupService shortStudyGroupService;

    private final StudyGroupService studyGroupService;
    private final StudyGroupPostfixService studyGroupPostfixService;
    @PersistenceContext
    EntityManager em;
    final private StudyGroupBaseService studyGroupBaseService;


    public StudyGroupController(ShortStudyGroupService shortStudyGroupService, StudyGroupService studyGroupService, StudyGroupPostfixService studyGroupPostfixService, StudyGroupBaseService studyGroupBaseService) {
        this.shortStudyGroupService = shortStudyGroupService;
        this.studyGroupService = studyGroupService;
        this.studyGroupPostfixService = studyGroupPostfixService;
        this.studyGroupBaseService = studyGroupBaseService;
    }

    @PostMapping("/create")
    ResponseEntity<StudyGroup> create(@RequestBody StudyGroup studyGroup){
        var result = this.studyGroupService.save(studyGroup);
        return new ResponseEntity<StudyGroup>(result,HttpStatus.OK);
    }

    @GetMapping("/shortView/getAll")
    List<StudyGroupShortView> getAllShortView() {
        return shortStudyGroupService.getAllShortGroups();
    }

    @GetMapping("/fullDescription/getAll")
    List<GroupFullView> getAllFullView(){
        return em.createNativeQuery("SELECT * FROM group_full_view", GroupFullView.class)
                .getResultList();
    }
    @GetMapping("/base/getAll")
    List<StudyGroupBase> getAllBaseStudyGroups() {
        return studyGroupBaseService.getAll();
    }

    @GetMapping("/base/fullDescription/getAll")
    List<GroupBaseFullView> getAllBaseFullDescription(){
        return em.createNativeQuery("SELECT * FROM group_base_full_view", GroupBaseFullView.class)
                .getResultList();
    }

    @GetMapping("/avgRecord/getAll")
    List<GroupAvgRecord> getAllAvgRecord(){
        return em.createNativeQuery("SELECT * FROM group_avg_record", GroupAvgRecord.class).getResultList();
    }
    @GetMapping("/base/getAllByDepartmentId/{departmentId}")
    List<StudyGroupBase> getAllByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return studyGroupBaseService.getAllByDepartmentId(departmentId);
    }

    @PostMapping("/base/create")
    ResponseEntity<StudyGroupBase> createBaseGroup(@RequestBody StudyGroupBase sgb) {
        this.studyGroupBaseService.save(sgb);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/base/deleteById/{id}")
    ResponseEntity<StudyGroupBase> deleteBaseGroupById(@PathVariable("id") Long id) {
        this.studyGroupBaseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/base/update/{id}")
    ResponseEntity<StudyGroupBase> updateBaseGroup(@RequestBody StudyGroupBase sgb, @PathVariable("id") Long id) {
        sgb.setId(id);
        studyGroupBaseService.update(sgb);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/postfix/getAll")
    List<StudyGroupPostfix> getAllPostfix(){
        return studyGroupPostfixService.getAll();
    }

}
