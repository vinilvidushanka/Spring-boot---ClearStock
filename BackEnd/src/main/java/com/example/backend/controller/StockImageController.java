package com.example.backend.controller;

import com.example.backend.dto.*;
import com.example.backend.service.StockImageService;
import com.example.backend.service.StoreService;
import com.example.backend.service.impl.StockImageServiceImpl;
import com.example.backend.service.impl.StoreServiceImpl;
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
@RequestMapping("api/v1/stock-image")
@CrossOrigin("*")
public class StockImageController {
    @Autowired
    private StockImageService stockImageService;

    @Autowired
    private StockImageServiceImpl stockImageServiceImpl;

    private static final Logger log = (Logger) LoggerFactory.getLogger(StockImageController.class);

    @Autowired
    public StockImageController(@Lazy StockImageService stockImageService, @Lazy StockImageServiceImpl stockImageServiceImpl) {
        this.stockImageService = stockImageService;
        this.stockImageServiceImpl = stockImageServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestParam("name") String name,
                                            @RequestParam("desc") String desc,
                                            @RequestParam("price") double price,
                                            @RequestParam("image") MultipartFile image) {
        // Save image to a directory
        String imageUrl = saveImage(image);

        // Create StoreDTO
        StockImageDTO stockImageDTO = new StockImageDTO();
        stockImageDTO.setName(name);
        stockImageDTO.setDescription(desc);
        stockImageDTO.setPrice(price);
        stockImageDTO.setImagePath(imageUrl); // Save the image URL to the database

        System.out.println("image ek save wenwd");
        System.out.println(stockImageDTO.toString());


        /*UserDTO userDTO = userServiceImpl.findUserByEmail(email);
        CategoryDTO categoryDTO = categoryServiceImpl.findIdByName(category);

        if (userDTO != null && categoryDTO != null) {
            storeDTO.setOwnerId(userDTO.getId());
            storeDTO.setCategoryId(categoryDTO.getId()); // Set the category ID
        } else {
            // Handle the case where user or category is not found
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(400, "User or Category not found", null));
        }*/

        // Save store
        try {
            stockImageService.save(stockImageDTO);
            log.info("Data saved successfully: " + stockImageDTO);
            System.out.println("image ek save wenwd22222");
        } catch (Exception e) {
            log.error("Error saving data", e);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Stock Image Saved Successfully", null));
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
        List<StockImageDTO> stockImageDTO = stockImageServiceImpl.getAllImages();
        for (StockImageDTO stockImage : stockImageDTO) {
            System.out.println(stockImage.toString());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Images retrieved successfully", stockImageService.getAllImages()));
    }
}
