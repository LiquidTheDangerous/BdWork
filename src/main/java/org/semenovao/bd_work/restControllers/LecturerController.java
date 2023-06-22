package org.semenovao.bd_work.restControllers;


import org.semenovao.bd_work.domain.Lecturer.Lecturer;
import org.semenovao.bd_work.domain.Lecturer.LecturerFullDescription;
import org.semenovao.bd_work.service.Lecturer.LecturerFullDescriptionService;
import org.semenovao.bd_work.service.Lecturer.LecturerService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    private final LecturerFullDescriptionService lecturerFullDescriptionService;
    private final LecturerService lecturerService;

    public LecturerController(LecturerFullDescriptionService lecturerFullDescriptionService, LecturerService lecturerService) {
        this.lecturerFullDescriptionService = lecturerFullDescriptionService;
        this.lecturerService = lecturerService;
    }

    @GetMapping("/fullDescription/getAllByDepartmentId")
    List<LecturerFullDescription> getAllByDepartmentId(@RequestParam("departmentId") Long departmentId) {
        return lecturerFullDescriptionService.getAllByDepartmentId(departmentId);
    }

    @GetMapping("/getAll")
    List<Lecturer> getAll() {
        return lecturerService.getAll();
    }

    @GetMapping("/fullDescription/getAll")
    List<LecturerFullDescription> getAllFullDescription() {
        return lecturerFullDescriptionService.getAll();
    }

    @PostMapping("/create")
    ResponseEntity<Lecturer> create(@RequestBody Lecturer lecturer) {
        var result = lecturerService.save(lecturer);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
