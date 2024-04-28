package com.azvtech.busdatasourceservice.mapper;

import com.azvtech.busdatasourceservice.dto.BusRequest;
import com.azvtech.busdatasourceservice.dto.BusResponse;
import com.azvtech.busdatasourceservice.model.Bus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Fellipe Toledo
 */
@Component
@RequiredArgsConstructor
public class BusMapper {
    private final ModelMapper mapper;

    public BusResponse busDaoToBusDto(Bus bus) {
        return mapper.map(bus, BusResponse.class);
    }
    public Bus busDtoToBusDao(BusRequest bus) {
        return mapper.map(bus, Bus.class);
    }

    public List<BusResponse> toBusDtoList(List<Bus> buses) {
        return buses.stream().map(this::busDaoToBusDto)
                .collect(Collectors.toList());
    }
}
