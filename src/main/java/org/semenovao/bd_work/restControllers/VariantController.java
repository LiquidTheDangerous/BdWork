package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.Variant.ControlEventVariant;
import org.semenovao.bd_work.domain.Variant.ControlEventVariantIdView;
import org.semenovao.bd_work.domain.Variant.ControlEventVariantView;
import org.semenovao.bd_work.repository.ControlEventVariantViewRepository;
import org.semenovao.bd_work.service.Variant.ControlEventVariantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/variant")
public class VariantController {

    private final ControlEventVariantService controlEventVariantService;

    private final ControlEventVariantViewRepository controlEventVariantViewRepository;

    @PersistenceContext
    EntityManager entityManager;

    public VariantController(ControlEventVariantService controlEventVariantService, ControlEventVariantViewRepository controlEventVariantViewRepository) {
        this.controlEventVariantService = controlEventVariantService;
        this.controlEventVariantViewRepository = controlEventVariantViewRepository;
    }


    @GetMapping("/getAll")
    List<ControlEventVariant> getAll(){
        return controlEventVariantService.getAll();
    }

    @GetMapping("/controlEventVariantView/getAll")
    List<ControlEventVariantView> getAllControlEventVariantView(){
        return entityManager.createNativeQuery("SELECT * FROM control_event_variant_view", ControlEventVariantView.class).getResultList();
    }

    @GetMapping("/controlEventVariantView/getAllByDisciplineLecturerId")
    List<ControlEventVariantView> getAllControlEventVariantViewByDisciplineLecturerId(@RequestParam("disciplineId") Long disciplineId, @RequestParam("lecturerId") Long lecturerId){
        return entityManager.createNativeQuery("SELECT * FROM control_event_variant_view WHERE control_event_variant_view.lecturer_id=:lecturerId AND control_event_variant_view.discipline_id=:disciplineId", ControlEventVariantView.class)
                .setParameter("lecturerId",lecturerId)
                .setParameter("disciplineId",disciplineId)
                .getResultList();
    }
    @PutMapping("/update/{id}")
    ResponseEntity<ControlEventVariant> update(@PathVariable("id") Long id, @RequestBody ControlEventVariant controlEventVariant){
        controlEventVariant.setId(id);
        return new ResponseEntity<>(controlEventVariantService.update(controlEventVariant), HttpStatus.OK);
    }
    @PutMapping("/updateVariantNum/{id}")
    ResponseEntity<ControlEventVariant> updateVariantNum(@PathVariable("id") Long id, @RequestBody ControlEventVariant variant){
        controlEventVariantService.updateVariantNum(id,variant.getVariantNum());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<ControlEventVariant> create(@RequestBody ControlEventVariant cev){
        return new ResponseEntity<>(controlEventVariantService.save(cev),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ControlEventVariant> delete(@PathVariable("id") Long id){
        controlEventVariantService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/idView/getAll")
    List<ControlEventVariantIdView> getAllControlEventVariantIdView(){
        return entityManager.createNativeQuery("SELECT * FROM control_event_variant_id_view", ControlEventVariantIdView.class).getResultList();
    }

}
