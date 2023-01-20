package br.com.worker.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Worker implements Serializable {
    private Long id;
    private String name;
    private Double dailyIncome;
}
