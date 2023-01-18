package br.com.worker.repositories;

import br.com.worker.entities.Worker;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends PagingAndSortingRepository<Worker, Long> {
}
