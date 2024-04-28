package com.azvtech.busdatasourceservice.controller;

import com.azvtech.busdatasourceservice.dto.BusRequest;
import com.azvtech.busdatasourceservice.dto.BusResponse;
import com.azvtech.busdatasourceservice.service.BusService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("/api/v1/rioonibus-datasource/bus")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BusController {
    private final BusService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBus(
            @Valid
            @RequestBody
            BusRequest bus) {
        service.createBus(bus);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateBus(
            @Valid
            @RequestBody
            BusRequest bus,
            @PathVariable("id") long id) {
        this.service.updateBus(bus, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBus(
            @PathVariable("id")
            long id) {
        this.service.deleteBus(id);

    }

    @GetMapping("/all")
    public List<BusResponse> getAllBuses() {
        return service.getAllBuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusResponse> getBusById(
            @PathVariable
            long id) {
        return ResponseEntity.ok(this.service.getBusById(id));
    }
}
