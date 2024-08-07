package com.ptvinh203.internbackend.mapper;

import com.ptvinh203.internbackend.configuration.SpringMapStructConfig;
import com.ptvinh203.internbackend.entity.Marketplace;
import com.ptvinh203.internbackend.payload.request.MarketplaceRequest;
import com.ptvinh203.internbackend.payload.response.MarketplaceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = SpringMapStructConfig.class)
public interface MarketplaceMapper {
    @Mapping(source = "type", target = "type")
    MarketplaceResponse toResponse(Marketplace entity);

    @Mapping(source = "typeId", target = "type", ignore = true)
    Marketplace toEntity(MarketplaceRequest request);
}
