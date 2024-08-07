package com.ptvinh203.internbackend.service;

import com.ptvinh203.internbackend.entity.MarketplaceType;
import com.ptvinh203.internbackend.payload.request.MarketplaceRequest;
import com.ptvinh203.internbackend.payload.response.MarketplaceResponse;

import java.util.List;

public interface MarketplaceService {
    List<MarketplaceResponse> getAll();

    List<MarketplaceType> getAllType();

    MarketplaceResponse addPlace(MarketplaceRequest request);

    void deletePlace(String id);
}
