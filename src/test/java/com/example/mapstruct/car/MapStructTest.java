package com.example.mapstruct.car;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MapStructTest {

    @Autowired
    CarMapper mapper;

    @Test
    public void mapstruct() {
        CarEntity carEntity = CarEntity.builder()
                .id(1L)
                .name("그랜져")
                .type("hybrid")
                .productionDate(LocalDate.of(2022, 12, 18))
                .price(3000L)
                .build();

        final CarDto result = mapper.entityToDto(carEntity);

        assertThat(result.getName()).isEqualTo(carEntity.getName());
        assertThat(result.getType()).isEqualTo(carEntity.getType());
        assertThat(result.getProductionDate()).isEqualTo(carEntity.getProductionDate());
        assertThat(result.getPrice()).isEqualTo(carEntity.getPrice());
    }
}
