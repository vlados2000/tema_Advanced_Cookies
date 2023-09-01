package com.example.tema_4.repository;

import com.example.tema_4.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarsRepository extends JpaRepository<Car, Long> {

}
