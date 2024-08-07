package com.ptvinh203.internbackend.payload.response;

import com.ptvinh203.internbackend.annotation.JsonSnakeCaseNaming;
import com.ptvinh203.internbackend.entity.MarketplaceType;
import com.ptvinh203.internbackend.util.base_model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@JsonSnakeCaseNaming
public class MarketplaceResponse extends AbstractEntity {
    private String id;
    private String name;
    private String address;
    private double area;
    private MarketplaceType type;
    private double price;
    private LocalDate date;
    private String description;
}
