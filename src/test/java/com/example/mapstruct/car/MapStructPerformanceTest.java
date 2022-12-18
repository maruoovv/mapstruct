package com.example.mapstruct.car;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

public class MapStructPerformanceTest {

    CarMapper MAPPER = Mappers.getMapper(CarMapper.class);

    @Test
    public void performanceTest() {
        CarEntity carEntity = CarEntity.builder()
                .id(1L)
                .name("그랜져")
                .type("hybrid")
                .productionDate(LocalDate.of(2022, 12, 18))
                .price(3000L)
                .build();


        long mapstructTransformStart = System.currentTimeMillis();
        for (int i = 0; i < 500_000; i++) {
            CarDto carDto = MAPPER.entityToDto(carEntity);
        }
        long mapstructTransformEnd = System.currentTimeMillis() - mapstructTransformStart;

        System.out.printf("%.2f\n", (double)mapstructTransformEnd / 1000.0);

        long normalTransformStart = System.currentTimeMillis();
        for (int i = 0; i < 500_000; i++) {
            CarDto carDto = CarDto.builder()
                    .name(carEntity.getName())
                    .type(carEntity.getType())
                    .price(carEntity.getPrice())
                    .productionDate(carEntity.getProductionDate())
                    .build();
        }
        long normalTransformEnd = System.currentTimeMillis() - normalTransformStart;

        System.out.printf("%.2f\n", (double)normalTransformEnd / 1000.0);
    }
}
