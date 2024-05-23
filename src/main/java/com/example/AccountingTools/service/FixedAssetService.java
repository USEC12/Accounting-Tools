package com.example.AccountingTools.service;


import com.example.AccountingTools.model.FixedAsset;
import com.example.AccountingTools.repositories.FixedAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FixedAssetService {
    private final FixedAssetRepository fixedAssetRepository;

    @Autowired
    public FixedAssetService(FixedAssetRepository fixedAssetRepository) {
        this.fixedAssetRepository = fixedAssetRepository;
    }

    public List<FixedAsset> getAllFixedAssets() {
        return fixedAssetRepository.findAll();
    }

    public Optional<FixedAsset> getFixedAssetById(Long id) {
        return fixedAssetRepository.findById(id);
    }

    public FixedAsset createFixedAsset(FixedAsset fixedAsset) {
        return fixedAssetRepository.save(fixedAsset);
    }

    public FixedAsset updateFixedAsset(Long id, FixedAsset fixedAssetDetails) {
        FixedAsset fixedAsset = fixedAssetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fixed asset not found with id " + id));

        fixedAsset.setName(fixedAssetDetails.getName());
        fixedAsset.setQuantity(fixedAssetDetails.getQuantity());
        fixedAsset.setUnitPrice(fixedAssetDetails.getUnitPrice());
        fixedAsset.setPurchaseDate(fixedAssetDetails.getPurchaseDate());
        fixedAsset.setServiceLifeMonths(fixedAssetDetails.getServiceLifeMonths());
        fixedAsset.setSupplier(fixedAssetDetails.getSupplier());
        fixedAsset.setAccountingDepartment(fixedAssetDetails.getAccountingDepartment());
        fixedAsset.setTotalCost(fixedAssetDetails.getTotalCost());
        fixedAsset.setIncludeVat(fixedAssetDetails.getIncludeVat());

        return fixedAssetRepository.save(fixedAsset);
    }

    public void deleteFixedAsset(Long id) {
        FixedAsset fixedAsset = fixedAssetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fixed asset not found with id " + id));
        fixedAssetRepository.delete(fixedAsset);
    }
}
