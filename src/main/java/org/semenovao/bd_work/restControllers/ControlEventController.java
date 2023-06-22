package org.semenovao.bd_work.restControllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.semenovao.bd_work.domain.ControlEvent.*;
import org.semenovao.bd_work.service.ControlEvent.ControlEventResultService;
import org.semenovao.bd_work.service.ControlEvent.ControlEventService;
import org.semenovao.bd_work.service.ControlEvent.ControlEventTypeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controlEvent")
public class ControlEventController {

    private final ControlEventTypeService controlEventTypeService;
    private final ControlEventService controlEventService;

    private final ControlEventResultService controlEventResultService;
    @PersistenceContext
    EntityManager em;

    public ControlEventController(@Qualifier("ControlEventTypeServiceImpl") ControlEventTypeService controlEventService, @Qualifier("ControlEventServiceImpl") ControlEventService controlEventService1, ControlEventResultService controlEventResultService) {
        this.controlEventTypeService = controlEventService;
        this.controlEventService = controlEventService1;
        this.controlEventResultService = controlEventResultService;
    }

    @GetMapping("/fullDescription/getAll")
    List<ControlEventView> getAllFullDescription() {
        return em.createNativeQuery("SELECT * FROM control_event_view", ControlEventView.class).getResultList();
    }

    @GetMapping("/fullDescription/getAllByTimeStampDate")
    List<ControlEventView> getAllByTimeStampDate(@RequestParam("timestamp") Long timestamp) {
        return em.createNativeQuery("SELECT * FROM control_event_view WHERE DATE(control_event_view.start_date) = DATE(FROM_UNIXTIME(:timestamp))", ControlEventView.class)
                .setParameter("timestamp", timestamp)
                .getResultList();

    }

    @GetMapping("/idView/getAll")
    List<ControlEventIdView> getAllIdView() {
        return em.createNativeQuery("SELECT * FROM control_event_id_view", ControlEventIdView.class).getResultList();
    }

    @GetMapping("/result/getAll")
    List<ControlEventResult> getAllControlEventResult() {
        return controlEventResultService.getAll();
    }

    @PostMapping("/result/create")
    ResponseEntity<ControlEventResult> createControlEventResult(@RequestBody ControlEventResult controlEventResult) {
        return new ResponseEntity<>(controlEventResultService.save(controlEventResult), HttpStatus.OK);
    }

    @DeleteMapping("/result/delete{id}")
    ResponseEntity<ControlEventResult> deleteControlEvent(@PathVariable("id") Long id) {
        controlEventResultService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/result/update/{id}")
    ResponseEntity<ControlEventResult> updateControlEvent(@PathVariable("id") Long id, @RequestBody ControlEventResult controlEventResult) {
        controlEventResult.setId(id);
        return new ResponseEntity<>(controlEventResultService.update(controlEventResult), HttpStatus.OK);
    }

    @GetMapping("/result/fullDescription/getAll")
    List<ControlEventResultConcatView> getAllControlEventResultFullDescription() {
        return em.createNativeQuery("SELECT * FROM control_event_result_concat_view", ControlEventResultConcatView.class).getResultList();
    }

    @GetMapping("/result/fullDescription/getAllByStudentId")
    List<ControlEventConcatView> getAllControlEventResultFullDescriptionByStudentId(@RequestParam("id") Long id) {
        return em.createNativeQuery("SELECT * FROM control_event_result_concat_view WHERE control_event_result_concat_view.student_id = :id", ControlEventResultConcatView.class)
                .setParameter("id", id).getResultList();
    }

    @GetMapping("/result/fullDescription/getAllByGroupId")
    List<ControlEventConcatView> getAllControlEventResultFullDescriptionByGroupId(@RequestParam("id") Long id) {
        return em.createNativeQuery("SELECT * FROM control_event_result_concat_view WHERE control_event_result_concat_view.group_id = :id", ControlEventResultConcatView.class)
                .setParameter("id", id).getResultList();
    }

    @GetMapping("/concatView/getAll")
    List<ControlEventConcatView> getAllConcatView() {
        return em.createNativeQuery("SELECT * FROM control_event_concat_view", ControlEventConcatView.class).getResultList();
    }

    @GetMapping("/getAll")
    List<ControlEvent> getAll() {
        return controlEventService.getAll();
    }

    @PostMapping("/create")
    ResponseEntity<ControlEvent> create(@RequestBody ControlEvent controlEvent) {
        return new ResponseEntity<>(controlEventService.save(controlEvent), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<ControlEvent> update(@PathVariable("id") Long id, @RequestBody ControlEvent controlEvent) {
        controlEvent.setId(id);
        return new ResponseEntity<>(controlEventService.update(controlEvent), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<ControlEvent> delete(@PathVariable("id") Long id) {
        controlEventTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/controlEventType/getAll")
    List<ControlEventType> getAllControlEventType() {
        return controlEventTypeService.getAll();
    }

    @PostMapping("/controlEventType/create")
    ResponseEntity<ControlEventType> createControlEventType(@RequestBody ControlEventType cet) {
        return new ResponseEntity<>(controlEventTypeService.save(cet), HttpStatus.OK);
    }

    @PutMapping("/controlEventType/update/{id}")
    ResponseEntity<ControlEventType> updateControlEventType(@PathVariable("id") Long id, @RequestBody ControlEventType cet) {
        cet.setId(id);
        return new ResponseEntity<>(controlEventTypeService.update(cet), HttpStatus.OK);
    }

    @DeleteMapping("/controlEventType/delete/{id}")
    ResponseEntity<ControlEventType> deleteControlEventType(@PathVariable("id") Long id) {
        controlEventTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
