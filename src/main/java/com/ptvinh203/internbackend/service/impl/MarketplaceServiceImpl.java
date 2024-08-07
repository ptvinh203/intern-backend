package com.ptvinh203.internbackend.service.impl;

import com.ptvinh203.internbackend.entity.MarketplaceType;
import com.ptvinh203.internbackend.mapper.MarketplaceMapper;
import com.ptvinh203.internbackend.payload.request.MarketplaceRequest;
import com.ptvinh203.internbackend.payload.response.MarketplaceResponse;
import com.ptvinh203.internbackend.repository.MarketplaceRepository;
import com.ptvinh203.internbackend.repository.MarketplaceTypeRepository;
import com.ptvinh203.internbackend.service.MarketplaceService;
import com.ptvinh203.internbackend.util.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MarketplaceServiceImpl implements MarketplaceService {
    private final MarketplaceRepository repository;
    private final MarketplaceTypeRepository typeRepository;
    private final MarketplaceMapper mapper;

    @Override
    public List<MarketplaceResponse> getAll() {
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public List<MarketplaceType> getAllType() {
        return typeRepository.findAll();
    }

    @Override
    public MarketplaceResponse addPlace(MarketplaceRequest request) {
        if (repository.existsById(request.getId())) {
            throw new BadRequestException("Place is existed!");
        }
        var type = typeRepository.findById(UUID.fromString(request.getTypeId())).orElse(null);
        if (type == null) throw new BadRequestException("Place type not found!");
        var data = mapper.toEntity(request);
        data.setType(type);
        data = repository.save(data);
        return mapper.toResponse(data);
    }

    @Override
    public void deletePlace(String id) {
        repository.deleteById(id);
    }
}
