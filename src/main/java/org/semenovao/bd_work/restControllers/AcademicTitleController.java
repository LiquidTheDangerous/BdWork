package org.semenovao.bd_work.restControllers;

import org.semenovao.bd_work.domain.Lecturer.AcademicTitle;
import org.semenovao.bd_work.repository.AcademicTitleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/academicTitle")
public class AcademicTitleController {

    private final AcademicTitleRepository repository;

    public AcademicTitleController(AcademicTitleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getAll")
    List<AcademicTitle> getAll(){
        return repository.findAll();
    }
}
