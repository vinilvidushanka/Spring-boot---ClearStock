package com.example.backend.service;

import com.example.backend.dto.StockImageDTO;
import com.example.backend.dto.WallpaperDTO;

import java.util.List;

public interface WallpaperService {
    void save(WallpaperDTO wallpaperDTO);
    List<WallpaperDTO> getAllImages();
    void deleteImage(int id);
    void updateImage(WallpaperDTO wallpaperDTO);
}
