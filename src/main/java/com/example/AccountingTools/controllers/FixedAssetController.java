package com.example.AccountingTools.controllers;

import com.example.AccountingTools.model.FixedAsset;


import com.example.AccountingTools.service.FixedAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fixedAssets")
public class FixedAssetController {

    private final FixedAssetService fixedAssetService;

    @Autowired
    public FixedAssetController(FixedAssetService fixedAssetService) {
        this.fixedAssetService = fixedAssetService;
    }

    @GetMapping
    public ResponseEntity<List<FixedAsset>> getAllFixedAssets() {
        return ResponseEntity.ok(fixedAssetService.getAllFixedAssets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FixedAsset> getFixedAssetById(@PathVariable Long id) {
        return fixedAssetService.getFixedAssetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FixedAsset> createFixedAsset(@RequestBody FixedAsset fixedAsset) {
        FixedAsset createdFixedAsset = fixedAssetService.createFixedAsset(fixedAsset);
        return ResponseEntity.ok(createdFixedAsset);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FixedAsset> updateFixedAsset(@PathVariable Long id, @RequestBody FixedAsset fixedAssetDetails) {
        FixedAsset updatedFixedAsset = fixedAssetService.updateFixedAsset(id, fixedAssetDetails);
        return ResponseEntity.ok(updatedFixedAsset);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFixedAsset(@PathVariable Long id) {
        fixedAssetService.deleteFixedAsset(id);
        return ResponseEntity.ok().build();
    }
}
