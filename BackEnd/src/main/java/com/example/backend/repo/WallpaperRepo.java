package com.example.backend.repo;

import com.example.backend.entity.Wallpaper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WallpaperRepo extends JpaRepository<Wallpaper, Integer> {
}
