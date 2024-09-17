package com.victorjv.hrworker.repositories;

import com.victorjv.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
