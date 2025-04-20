package com.workers.workers.controllers;

import com.workers.workers.model.Worker;
import com.workers.workers.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping(value = "/workers")
    public ResponseEntity<?> create(@RequestBody Worker worker) {
        workerService.create(worker);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/workers")
    public ResponseEntity<List<Worker>> read() {
        final List<Worker> workers = workerService.readAll();

        return workers != null &&  !workers.isEmpty()
                ? new ResponseEntity<>(workers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/workers/{id}")
    public ResponseEntity<Worker> read(@PathVariable(name = "id") long id) {
        final Worker worker = workerService.read(id);

        return worker != null
                ? new ResponseEntity<>(worker, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/workers/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable(name = "id") long id, @RequestBody Worker worker) {
        final boolean updated = workerService.update(worker, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/workers/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable(name = "id") long id) {
        final boolean deleted = workerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
