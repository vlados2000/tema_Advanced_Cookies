package com.example.tema_4.controllers;

import com.example.tema_4.dto.CarsDto;
import com.example.tema_4.dto.DarkModeDto;
import com.example.tema_4.services.CarService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    // Pentru a usura procesul de rulare si testare am pupulat Repository cu niste obiecte direct in aplicatie
    // in package-ul Bootstrap

    @GetMapping("/cars")
    public ResponseEntity<CarsDto> getCars(@CookieValue("darkMode") String darkMode) {
        return carService.getAllCars(darkMode);
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<?> setDarkMode(@RequestBody DarkModeDto dto, HttpServletResponse response) {
        return carService.setDarkMode(dto, response);
    }
}
