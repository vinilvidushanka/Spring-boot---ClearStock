package com.example.backend.service.impl;

import com.example.backend.dto.StockImageDTO;
import com.example.backend.dto.WallpaperDTO;
import com.example.backend.entity.StockImage;
import com.example.backend.entity.Wallpaper;
import com.example.backend.repo.WallpaperRepo;
import com.example.backend.service.WallpaperService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallpaperServiceImpl implements WallpaperService {
    @Autowired
    private WallpaperRepo wallpaperRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(StockImageServiceImpl.class);

    @Override
    public void save(WallpaperDTO wallpaperDTO) {
        Wallpaper wallpaper = new Wallpaper();
        wallpaper.setName(wallpaperDTO.getName());
        wallpaper.setDescription(wallpaperDTO.getDescription());
        wallpaper.setPrice(wallpaperDTO.getPrice());
        wallpaper.setImagePath(wallpaperDTO.getImagePath()); // Save the image URL to the database
        wallpaperRepo.save(wallpaper);

        // Save image data to the database
        // Assuming Store entity has a byte array field for image data
        if (wallpaperDTO.getImageData() != null) {
            wallpaper.setImageData(wallpaperDTO.getImageData());
            wallpaperRepo.save(wallpaper);
        }
    }

    @Override
    public List<WallpaperDTO> getAllImages() {
        List<Wallpaper> wallpaperList = wallpaperRepo.findAll();
        wallpaperList.forEach(wallpaper -> System.out.println(wallpaper.toString()));

        wallpaperList.forEach(wallpaper -> {
            System.out.println("ID : " + wallpaper.getId() +
                    " Name : " + wallpaper.getName() +
                    " Description : " + wallpaper.getDescription() +
                    " Price : " + wallpaper.getPrice() +
                    " ImagePath : " + wallpaper.getImagePath()
            );
        });

        List<WallpaperDTO> wallpaperDTOS = modelMapper.map(
                wallpaperList,
                new TypeToken<List<WallpaperDTO>>() {}.getType()
        );

        return wallpaperDTOS;
    }

    @Override
    public void deleteImage(int id) {

    }

    @Override
    public void updateImage(WallpaperDTO wallpaperDTO) {

    }
}
