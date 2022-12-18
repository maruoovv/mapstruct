package com.example.mapstruct.car;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CarResponse {

    private String carName;
    private String carType;
    private String price;

    @Builder
    public CarResponse(String carName, String carType, String price) {
        this.carName = carName;
        this.carType = carType;
        this.price = price;
    }
}
