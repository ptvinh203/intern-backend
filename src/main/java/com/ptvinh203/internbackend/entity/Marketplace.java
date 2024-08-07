package com.ptvinh203.internbackend.entity;

import com.ptvinh203.internbackend.util.base_model.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marketplaces")
public class Marketplace extends AbstractEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private double area;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private MarketplaceType type;
    private double price;
    private LocalDate date;
    private String description;
}
