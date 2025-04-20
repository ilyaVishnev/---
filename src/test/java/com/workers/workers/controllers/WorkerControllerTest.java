package com.workers.workers.controllers;

import com.workers.workers.model.Worker;
import com.workers.workers.services.WorkerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
public class WorkerControllerTest {

    @InjectMocks
    private WorkerController controller;

    @Mock
    private WorkerService service;

    private Worker worker;

        @BeforeEach
        public void init() {
            worker = new Worker(888L,
                    "First", "Name", "Patron", new Date(33L), "example@mail.ru",
                    "+7(964)267-23-56");
        }

    @Test
    public void getAllWorkersTest() {
        when(service.readAll()).thenReturn(Arrays.asList(new Worker(8L,
                "F1", "N1", "P1", new Date(10L), "1@mail.ru",
                "phone1"), new Worker(10L,
                "F2", "N2", "P2", new Date(11L), "2@mail.ru",
                "phone2"), new Worker(14L,
                "F3", "N3", "P3", new Date(14L), "3@mail.ru",
                "phone3")));
        ResponseEntity<List<Worker>> entity= controller.read();
        assertNotNull(entity);
        List<Worker> workers = entity.getBody();
        assertNotNull(workers);
        assertEquals(3, workers.size());
    }

    @Test
    public void getOneWorkerTest() {
        when(service.read(888L)).thenReturn(worker);
        ResponseEntity<Worker> entity= controller.read(888L);
        assertNotNull(entity);
        Worker worker_from = entity.getBody();
        assertEquals(worker, worker_from);
    }

    @Test
    public void updateWorkerTest() {
        when(service.update(worker,888L)).thenReturn(true);
        ResponseEntity<?> entity= controller.update(888L,worker);
        assertNotNull(entity);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

    @Test
    public void deleteWorkerTest() {
        when(service.delete(888L)).thenReturn(true);
        ResponseEntity<?> entity= controller.delete(888L);
        assertNotNull(entity);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}
