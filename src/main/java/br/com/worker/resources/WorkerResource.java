package br.com.worker.resources;

import br.com.worker.entities.Worker;
import br.com.worker.entities.dto.WorkerDto;
import br.com.worker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
    @Autowired
    private WorkerService workerService;

    @GetMapping
    ResponseEntity<Iterable<WorkerDto>> findAllWorkers(Pageable pageable){
        Iterable<WorkerDto> workers = workerService.findAllWorkers(pageable);
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<WorkerDto> findWorkerById(@PathVariable Long id){
        WorkerDto worker = workerService.findWorkerById(id);
        return new ResponseEntity<>(worker, HttpStatus.OK);
    }
}
