package com.ptvinh203.internbackend.controller;

import com.ptvinh203.internbackend.payload.request.MarketplaceRequest;
import com.ptvinh203.internbackend.service.MarketplaceService;
import com.ptvinh203.internbackend.util.base_model.ApiDataResponse;
import com.ptvinh203.internbackend.util.constant.CommonConstant;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/marketplace")
@RequiredArgsConstructor
public class MarketplaceController {
    private final MarketplaceService service;

    @GetMapping("/type/all")
    public ResponseEntity<ApiDataResponse> getAllType() {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(service.getAllType()));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiDataResponse> getAll() {
        return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiDataResponse> addPlace(
            @RequestBody MarketplaceRequest request
    ) {
        String errorMsg = request.checkValid();
        if (!errorMsg.isEmpty())
            ResponseEntity.ok(ApiDataResponse.builder().status(CommonConstant.FAILURE).error(errorMsg).build());
        try {
            return ResponseEntity.ok(ApiDataResponse.successWithoutMeta(service.addPlace(request)));
        } catch (Exception ex) {
            return ResponseEntity.ok(ApiDataResponse.builder().status(CommonConstant.FAILURE).error(ex.getMessage()).build());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiDataResponse> addPlace(
            @PathVariable("id") String id
    ) {
        try {
            service.deletePlace(id);
            return ResponseEntity.ok(ApiDataResponse.successWithoutMetaAndData());
        } catch (Exception ex) {
            return ResponseEntity.ok(ApiDataResponse.builder().status(CommonConstant.FAILURE).error(ex.getMessage()).build());
        }
    }
}
