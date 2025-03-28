package com.example.backend.service.impl;

import com.example.backend.dto.StoreDTO;
import com.example.backend.entity.Store;
import com.example.backend.repo.CategoryRepo;
import com.example.backend.repo.StoreRepo;
import com.example.backend.service.StoreService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepo storeRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Override
    public void save(StoreDTO storeDTO) {
        Store store = new Store();
        store.setName(storeDTO.getName());
        store.setDescription(storeDTO.getDescription());
        store.setPrice(storeDTO.getPrice());
        store.setImagePath(storeDTO.getImagePath()); // Save the image URL to the database
        store.setCategoryId(storeDTO.getCategoryId()); // Save the category ID
        store.setOwnerId(storeDTO.getOwnerId()); // Save the owner ID
        storeRepo.save(store);

        // Save image data to the database
        // Assuming Store entity has a byte array field for image data
        if (storeDTO.getImageData() != null) {
            store.setImageData(storeDTO.getImageData());
            storeRepo.save(store);
        }
    }


    @Override
    public List<StoreDTO> getAllImages() {
        List<Store> storeList = storeRepo.findAll();
        storeList.forEach(store -> System.out.println(store.toString()));

        storeList.forEach(store -> {
            System.out.println("ID : " + store.getId() +
                    " Name : " + store.getName() +
                    " Owner : " + store.getOwnerId() +
                    " Description : " + store.getDescription() +
                    " Category : " + store.getCategoryId() +
                    " Price : " + store.getPrice() +
                    " ImagePath : " + store.getImagePath()
            );
        });

        List<StoreDTO> storeDTOS = modelMapper.map(
                storeList,
                new TypeToken<List<StoreDTO>>() {}.getType()
        );

        return storeDTOS;
    }

    @Override
    public void deleteImage(int id) {
        storeRepo.deleteById((int) id);
    }

    @Override
    public void updateImage(StoreDTO storeDTO) {
        Store store = storeRepo.findById(storeDTO.getId()).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setName(storeDTO.getName());
        store.setDescription(storeDTO.getDescription());
        store.setPrice(storeDTO.getPrice());
        store.setImagePath(storeDTO.getImagePath());
        // You need to set the owner and category here as well
        storeRepo.save(store);

        // Update image data in the database
        if (storeDTO.getImageData() != null) {
            store.setImageData(storeDTO.getImageData());
            storeRepo.save(store);
        }
    }

}
