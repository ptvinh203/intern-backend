package com.ptvinh203.internbackend.entity;

import com.ptvinh203.internbackend.util.base_model.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Entity
@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marketplace_types")
public class MarketplaceType extends AbstractEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
}
