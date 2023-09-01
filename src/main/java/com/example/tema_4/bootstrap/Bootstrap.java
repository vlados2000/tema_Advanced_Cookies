package com.example.tema_4.bootstrap;

import com.example.tema_4.models.Car;
import com.example.tema_4.repository.CarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class Bootstrap implements CommandLineRunner {
    private final CarsRepository carsRepository;

    @Override
    public void run(String... args) throws Exception {
        if (carsRepository.count() == 0) {
            Car tesla = Car.builder().model("Model 3").name("Tesla").build();
            Car dacia = Car.builder().model("Logan").name("Dacia").build();
            carsRepository.saveAll(List.of(tesla, dacia));
        }
    }
}
