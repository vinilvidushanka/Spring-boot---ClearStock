package com.example.backend.service;

import com.example.backend.dto.StockImageDTO;

import java.util.List;

public interface StockImageService {
    void save(StockImageDTO stockImageDTO);
    List<StockImageDTO> getAllImages();
    void deleteImage(int id);
    void updateImage(StockImageDTO stockImageDTO);
}
