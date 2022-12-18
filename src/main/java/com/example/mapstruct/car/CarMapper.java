package com.example.mapstruct.car;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto entityToDto(CarEntity carEntity);

    @Mapping(source = "name", target = "carName")
    @Mapping(source = "type", target = "carType", defaultValue = "type")
    CarResponse dtoToResponse(CarDto carDto);
}
