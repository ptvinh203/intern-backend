package com.ptvinh203.internbackend.repository;

import com.ptvinh203.internbackend.entity.MarketplaceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarketplaceTypeRepository extends JpaRepository<MarketplaceType, UUID> {
}
