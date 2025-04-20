package com.workers.workers.repository;

import com.workers.workers.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository  extends JpaRepository<Worker, Long> {
}
