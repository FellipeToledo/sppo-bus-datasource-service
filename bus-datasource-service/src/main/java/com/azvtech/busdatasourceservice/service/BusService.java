package com.azvtech.busdatasourceservice.service;

import com.azvtech.busdatasourceservice.dto.BusRequest;
import com.azvtech.busdatasourceservice.dto.BusResponse;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
public interface BusService {
    void createBus(BusRequest bus);
    void updateBus(BusRequest bus, Long busId);
    BusResponse getBusById(Long busId);
    List<BusResponse> getAllBuses();
    void deleteBus(Long busId);
}
