package com.workers.workers.services;

import com.workers.workers.model.Worker;
import com.workers.workers.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {


    @Autowired
    private WorkerRepository workerRepository;


    public void create(Worker worker) {
        workerRepository.save(worker);
    }

    public List<Worker>  readAll() {
        return workerRepository.findAll();
    }

    public Worker read(long id) {
        return workerRepository.findById(id).get();
    }

    public boolean update(Worker worker, long id) {
        if (workerRepository.existsById(id)) {
            worker.setId(id);
            workerRepository.save(worker);
            return true;
        }

        return false;
    }

    public boolean delete(long id) {
        if (workerRepository.existsById(id)) {
            workerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
