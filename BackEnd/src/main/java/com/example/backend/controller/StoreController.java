package com.example.backend.controller;

import com.example.backend.dto.CategoryDTO;
import com.example.backend.dto.ResponseDTO;
import com.example.backend.dto.StoreDTO;
import com.example.backend.dto.UserDTO;
import com.example.backend.service.StoreService;
import com.example.backend.service.impl.CategoryServiceImpl;
import com.example.backend.service.impl.StoreServiceImpl;
import com.example.backend.service.impl.UserServiceImpl;
import com.example.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/store")
@CrossOrigin("*")
public class StoreController {
//    @Autowired
//    private StoreService storeService;
    @Autowired
    private final StoreService storeService;
    @Autowired
    private final StoreServiceImpl storeServiceImpl;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    CategoryServiceImpl categoryServiceImpl;

    public StoreController(StoreService storeService, StoreServiceImpl storeServiceImpl) {
        this.storeService = storeService;
        this.storeServiceImpl = storeServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestBody @Valid StoreDTO storeDTO) {
        UserDTO userDTO=userServiceImpl.findUserByEmail(storeDTO.getOwnerEmail());
        storeDTO.setOwnerId(userDTO.getId());

        CategoryDTO categoryDTO=categoryServiceImpl.findIdByName(storeDTO.getCategoryName());
        storeDTO.setCategoryId(categoryDTO.getId());

        System.out.println(storeDTO.getName());
        storeService.save(storeDTO);
        System.out.println("save wenwd");
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Category Saved Successfully", null));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllImages() {
//        List<Store> storeList = storeService.getAllImages();
//
//        for (Store store : storeList) {
//            System.out.println(store.toString());
//        }
//        return new ResponseUtil(200, "User saved successfully", storeList);
//    }
        List<StoreDTO> storeDTO = storeServiceImpl.getAllImages();
        for (StoreDTO store : storeDTO) {
            System.out.println(store.toString());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Image saved successfully",storeService.getAllImages()));
    }
}
