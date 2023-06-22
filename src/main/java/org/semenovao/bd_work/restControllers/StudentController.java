package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.Student.Student;
import org.semenovao.bd_work.domain.Student.StudentAvgRecord;
import org.semenovao.bd_work.domain.Student.StudentGroup;
import org.semenovao.bd_work.domain.Student.StudentRecord;
import org.semenovao.bd_work.service.Student.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @PersistenceContext
    EntityManager em;
    
    private final StudentService service;

    public StudentController(@Qualifier("StudentServiceImpl") StudentService service) {
        this.service = service;
    }

    @GetMapping("/getAll")
    List<Student> getAll(){
        return service.getAll();
    }
    @GetMapping("/fullDescription/getAll")
    List<StudentGroup> getAllFullDescription(){
        return em.createNativeQuery("SELECT * FROM student_group", StudentGroup.class)
                .getResultList();
    }

    @GetMapping("/fullDescription/getAllByGroupId")
    List<StudentGroup> getAllFullDescriptionByStudyGroupId(@RequestParam("studyGroupId") Long studyGroupId){
        return em.createNativeQuery("SELECT * FROM student_group WHERE student_group.group_id=:id", StudentGroup.class)
                .setParameter("id",studyGroupId)
                .getResultList();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<Student> update(@PathVariable("id") Long id, @RequestBody Student student){
        student.setId(id);
        var result = service.update(student);
        return new ResponseEntity<Student>(result,HttpStatus.OK);
    }
    @PostMapping("/create")
    ResponseEntity<Student> create(@RequestBody Student student){
        var result = service.save(student);
        return new ResponseEntity<Student>(result, HttpStatus.OK);
    }
    @GetMapping("/record/getAll")
    List<StudentRecord> getAllStudentRecord(){
        return em.createNativeQuery("SELECT * FROM student_record", StudentRecord.class)
                .getResultList();
    }

    @GetMapping("/avgRecord/getAll")
    List<StudentRecord> getAllStudentAvgRecord(){
        return em.createNativeQuery("SELECT * FROM student_avg_record", StudentAvgRecord.class)
                .getResultList();
    }
}
