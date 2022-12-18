package com.example.mapstruct.car;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class CarEntity {

    private long id;
    private String name;
    private String type;
    private LocalDate productionDate;
    private long price;

    @Builder
    public CarEntity(long id, String name, String type, LocalDate productionDate, long price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.productionDate = productionDate;
        this.price = price;
    }
}
