package com.example.backend.controller;

import com.example.backend.dto.ResponseDTO;
import com.example.backend.dto.StockImageDTO;
import com.example.backend.dto.WallpaperDTO;
import com.example.backend.service.StockImageService;
import com.example.backend.service.WallpaperService;
import com.example.backend.service.impl.StockImageServiceImpl;
import com.example.backend.service.impl.WallpaperServiceImpl;
import com.example.backend.util.VarList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("api/v1/wallpaper")
@CrossOrigin("*")
public class WallpaperController {
    @Autowired
    private WallpaperService wallpaperService;

    @Autowired
    private WallpaperServiceImpl wallpaperServiceImpl;

    private static final Logger log = (Logger) LoggerFactory.getLogger(StockImageController.class);

    @Autowired
    public WallpaperController(@Lazy WallpaperService wallpaperService, @Lazy WallpaperServiceImpl wallpaperServiceImpl) {
        this.wallpaperService = wallpaperService;
        this.wallpaperServiceImpl = wallpaperServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestParam("name") String name,
                                            @RequestParam("desc") String desc,
                                            @RequestParam("price") double price,
                                            @RequestParam("image") MultipartFile image) {
        // Save image to a directory
        String imageUrl = saveImage(image);

        // Create StoreDTO
        WallpaperDTO wallpaperDTO = new WallpaperDTO();
        wallpaperDTO.setName(name);
        wallpaperDTO.setDescription(desc);
        wallpaperDTO.setPrice(price);
        wallpaperDTO.setImagePath(imageUrl); // Save the image URL to the database

        System.out.println("image ek save wenwd");
        System.out.println(wallpaperDTO.toString());


        // Save store
        try {
            wallpaperService.save(wallpaperDTO);
            log.info("Data saved successfully: " + wallpaperDTO);
            System.out.println("image ek save wenwd22222");
        } catch (Exception e) {
            log.error("Error saving data", e);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "wallpaper Saved Successfully", null));
    }

    private String saveImage(MultipartFile image) {
        if (image.isEmpty()) {
            return null;
        }

        try {
            // Create directory to save the image
            String directoryPath = "uploads/";
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Save the image to the directory
            String imagePath = directoryPath + image.getOriginalFilename();
            Path path = Paths.get(imagePath);
            Files.write(path, image.getBytes());

            return imagePath; // Return the image URL to be saved in the database
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllImages() {
        List<WallpaperDTO> wallpaperDTO = wallpaperServiceImpl.getAllImages();
        for (WallpaperDTO wallpaper : wallpaperDTO) {
            System.out.println(wallpaper.toString());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Images retrieved successfully", wallpaperService.getAllImages()));
    }

}
