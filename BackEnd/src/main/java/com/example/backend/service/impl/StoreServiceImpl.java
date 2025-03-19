package com.example.backend.service.impl;

import com.example.backend.dto.StoreDTO;
import com.example.backend.entity.Store;
import com.example.backend.repo.StoreRepo;
import com.example.backend.service.StoreService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreRepo storeRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void save(StoreDTO storeDTO) {
        if (storeRepo.existsById(storeDTO.getId())) {
            throw new RuntimeException("User already exists");
        }
        storeRepo.save(modelMapper.map(storeDTO, Store.class));
    }

    @Override
    public List<StoreDTO> getAllImages() {
        List<Store> storeList = storeRepo.findAll();
        storeList.forEach(store -> System.out.println(store.toString()));

        storeList.forEach(store -> {
            System.out.println("ID : " + store.getId()+
                    " Name : " + store.getName()+
                    " Owner : " + store.getOwner()+
                    " Description : " + store.getDescription()+
                    " Category : " + store.getCategory()+
                    " Price : " + store.getPrice()+
                    " ImagePath : " + store.getImagePath()
            );
        });

        List<StoreDTO> storeDTOS = modelMapper.map(
                storeList,
                new TypeToken<List<StoreDTO>>(){}.getType());

        return storeDTOS;
    }

    @Override
    public void deleteImage(int id) {

    }

    @Override
    public void updateImage(StoreDTO storeDTO) {

    }
}
