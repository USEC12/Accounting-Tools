package com.example.AccountingTools.repositories;

import com.example.AccountingTools.model.FixedAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixedAssetRepository extends JpaRepository<FixedAsset,Long> {
    // Здесь можно добавить дополнительные методы поиска
}
