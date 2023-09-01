package com.example.tema_4.services;

import com.example.tema_4.dto.CarDto;
import com.example.tema_4.dto.CarsDto;
import com.example.tema_4.dto.DarkModeDto;
import com.example.tema_4.repository.CarsRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarsRepository carsRepository;

    public ResponseEntity<CarsDto> getAllCars(String darkMode) {
        CarsDto response = new CarsDto();

        response.setDarkMode(Boolean.parseBoolean(darkMode));

        List<CarDto> cars = carsRepository.findAll().stream().map(car ->
                CarDto.builder()
                        .model(car.getModel())
                        .name(car.getName())
                        .build()
        ).toList();

        response.setCars(cars);

        return ResponseEntity.ok().body(response);
    }

    public ResponseEntity<?> setDarkMode(DarkModeDto dto, HttpServletResponse response) {
        response.addCookie(new Cookie("darkMode", dto.getDarkMode().toString()));
        return ResponseEntity.ok().build();
    }
}
