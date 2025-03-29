package com.example.backend.repo;

import com.example.backend.entity.StockImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockImageRepo extends JpaRepository<StockImage, Integer> {
}
