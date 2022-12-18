package com.example.mapstruct.car;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CarDto {

    private String name;
    private String type;
    private LocalDate productionDate;
    private long price;

    @Builder
    public CarDto(String name, String type, LocalDate productionDate, long price) {
        this.name = name;
        this.type = type;
        this.productionDate = productionDate;
        this.price = price;
    }
}
