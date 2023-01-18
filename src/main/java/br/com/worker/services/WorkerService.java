package br.com.worker.services;

import br.com.worker.entities.Worker;
import br.com.worker.entities.dto.WorkerDto;
import br.com.worker.repositories.WorkerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.stream.Collectors;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    public ModelMapper modelMapper;

    public Iterable<WorkerDto> findAllWorkers(Pageable pageable){
        Page<WorkerDto> workers = workerRepository.findAll(pageable).map(w -> modelMapper.map(w, WorkerDto.class));
        if (workers == null){
            throw new EntityNotFoundException("Workers not found");
        }
        return workers;
    }

    public WorkerDto findWorkerById(Long id){
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return modelMapper.map(worker, WorkerDto.class);
    }

}
