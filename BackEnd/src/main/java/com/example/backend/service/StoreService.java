package com.example.backend.service;

import com.example.backend.dto.StoreDTO;

import java.util.List;

public interface StoreService {
//    void save (StoreDTO storeDTO);
//    List<StoreDTO> getAllImages();
//    void deleteImage(int id);
//    void updateImage(StoreDTO storeDTO);

    void save(StoreDTO storeDTO);
    List<StoreDTO> getAllImages();
    void deleteImage(int id);
    void updateImage(StoreDTO storeDTO);
}
