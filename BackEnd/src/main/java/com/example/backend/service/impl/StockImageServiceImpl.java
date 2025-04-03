package com.example.backend.service.impl;

import com.example.backend.dto.StockImageDTO;
import com.example.backend.entity.StockImage;
import com.example.backend.repo.StockImageRepo;
import com.example.backend.service.StockImageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StockImageServiceImpl implements StockImageService {

    @Autowired
    private StockImageRepo stockImageRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(StockImageServiceImpl.class);

    @Override
    public void save(StockImageDTO stockImageDTO) {
        StockImage stockImage = new StockImage();
        stockImage.setName(stockImageDTO.getName());
        stockImage.setDescription(stockImageDTO.getDescription());
        stockImage.setPrice(stockImageDTO.getPrice());
        stockImage.setImagePath(stockImageDTO.getImagePath()); // Save the image URL to the database
        stockImageRepo.save(stockImage);

        // Save image data to the database
        // Assuming Store entity has a byte array field for image data
        if (stockImageDTO.getImageData() != null) {
            stockImage.setImageData(stockImageDTO.getImageData());
            stockImageRepo.save(stockImage);
        }
    }

    @Override
    public List<StockImageDTO> getAllImages() {
        List<StockImage> stockImageList = stockImageRepo.findAll();
        stockImageList.forEach(stockImage -> System.out.println(stockImage.toString()));

        stockImageList.forEach(stockImage -> {
            System.out.println("ID : " + stockImage.getId() +
                    " Name : " + stockImage.getName() +
                    " Description : " + stockImage.getDescription() +
                    " Price : " + stockImage.getPrice() +
                    " ImagePath : " + stockImage.getImagePath()
            );
        });

        List<StockImageDTO> stockImageDTOS = modelMapper.map(
                stockImageList,
                new TypeToken<List<StockImageDTO>>() {}.getType()
        );

        return stockImageDTOS;
    }

    @Override
    public void deleteImage(int id) {

    }

    @Override
    public void updateImage(StockImageDTO stockImageDTO) {

    }
}
