package com.ptvinh203.internbackend.configuration;

import com.ptvinh203.internbackend.entity.Marketplace;
import com.ptvinh203.internbackend.entity.MarketplaceType;
import com.ptvinh203.internbackend.repository.MarketplaceRepository;
import com.ptvinh203.internbackend.repository.MarketplaceTypeRepository;
import com.ptvinh203.internbackend.util.util.CommonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@Order(1)
@RequiredArgsConstructor
public class CreateDefaultData implements CommandLineRunner {
    private final MarketplaceTypeRepository typeRepository;
    private final MarketplaceRepository marketplaceRepository;

    @Override
    public void run(String... args) throws Exception {
        // Marketplace types
        if (!typeRepository.findAll().isEmpty()) return;
        log.info("--------------------- Creating default market place type ---------------------");
        List<MarketplaceType> types = List.of(
                MarketplaceType.builder()
                        .id(UUID.randomUUID())
                        .name("Office")
                        .createdAt(CommonUtils.getCurrentTimestamp())
                        .build(),
                MarketplaceType.builder()
                        .id(UUID.randomUUID())
                        .name("Store")
                        .createdAt(CommonUtils.getCurrentTimestamp())
                        .build(),
                MarketplaceType.builder()
                        .id(UUID.randomUUID())
                        .name("House")
                        .createdAt(CommonUtils.getCurrentTimestamp())
                        .build()
        );

        try {
            types = typeRepository.saveAll(types);
            log.info("--------------------- Successfully created market place type ---------------------");
        } catch (Exception ex) {
            log.error("Error when creating default market place type: ", ex);
        }


        // Marketplace
        if (!marketplaceRepository.findAll().isEmpty() || CommonUtils.isEmptyOrNullList(types)) return;
        log.info("--------------------- Creating default market place ---------------------");
        List<Marketplace> marketplaces = List.of(
                Marketplace.builder()
                        .id("MB001")
                        .name("Place 1")
                        .address("Hoa Minh, Lien Chieu")
                        .area(100)
                        .type(types.getFirst())
                        .price(10000000)
                        .date(LocalDate.of(2024, 8, 20))
                        .description("This is place 1's description")
                        .build(),
                Marketplace.builder()
                        .id("MB002")
                        .name("Place 2")
                        .address("Hai Chau, Da Nang")
                        .area(50)
                        .type(types.get(1))
                        .price(20000000)
                        .date(LocalDate.of(2024, 9, 20))
                        .description("This is place 2's description")
                        .build(),
                Marketplace.builder()
                        .id("MB003")
                        .name("Place 3")
                        .address("Son Tra, Da Nang")
                        .area(50)
                        .type(types.get(2))
                        .price(15000000)
                        .date(LocalDate.of(2024, 10, 20))
                        .description("This is place 3's description")
                        .build()
        );

        try {
            marketplaceRepository.saveAll(marketplaces);
            log.info("--------------------- Successfully created market place ---------------------");
        } catch (Exception ex) {
            log.error("Error when creating default market place: ", ex);
        }


    }
}
