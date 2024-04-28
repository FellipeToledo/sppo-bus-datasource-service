package com.azvtech.busdatasourceservice.service;

import com.azvtech.busdatasourceservice.dto.BusRequest;
import com.azvtech.busdatasourceservice.dto.BusResponse;
import com.azvtech.busdatasourceservice.exception.ResourceNotFoundException;
import com.azvtech.busdatasourceservice.mapper.BusMapper;
import com.azvtech.busdatasourceservice.model.Bus;
import com.azvtech.busdatasourceservice.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class IBusService implements BusService{

    private final BusRepository repository;
    private final BusMapper mapper;

    @Override
    public void createBus(BusRequest busRequest) {
        Bus mappedBus = mapper.busDtoToBusDao(busRequest);
        repository.save(mappedBus);
        log.info("Bus {} is saved", mappedBus.getId());

    }

    @Override
    public void updateBus(BusRequest busRequest, Long busId) {
        Bus findBus = repository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "Id", busId));
        findBus.setOrderCode(busRequest.getOrderCode());
        findBus.setPlate(busRequest.getPlate());
        repository.save(findBus);
        log.info("Bus {} is updated", findBus.getId());
    }

    @Override
    public BusResponse getBusById(Long busId) {
        Bus findBus = repository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "Id", busId));
        return mapper.busDaoToBusDto(findBus);
    }

    @Override
    public List<BusResponse> getAllBuses() {
        List<Bus> buses = repository.findAll();
        return mapper.toBusDtoList(buses);
    }

    @Override
    public void deleteBus(Long busId) {
        Bus findBus = repository.findById(busId)
                .orElseThrow(() -> new ResourceNotFoundException("Bus", "Id", busId));
        repository.deleteById(busId);
        log.info("Bus {} is deleted", findBus.getId());
    }
}
