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

//@RestController
//@RequestMapping("api/v1/store")
//@CrossOrigin("*")
//public class StoreController {
////    @Autowired
////    private StoreService storeService;
//    @Autowired
//    private final StoreService storeService;
//    @Autowired
//    private final StoreServiceImpl storeServiceImpl;
//    @Autowired
//    UserServiceImpl userServiceImpl;
//    @Autowired
//    CategoryServiceImpl categoryServiceImpl;
//
//    public StoreController(StoreService storeService, StoreServiceImpl storeServiceImpl) {
//        this.storeService = storeService;
//        this.storeServiceImpl = storeServiceImpl;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<ResponseDTO> save(@RequestBody @Valid StoreDTO storeDTO) {
//        UserDTO userDTO=userServiceImpl.findUserByEmail(storeDTO.getOwnerEmail());
//        storeDTO.setOwnerId(userDTO.getId());
//
//        CategoryDTO categoryDTO=categoryServiceImpl.findIdByName(storeDTO.getCategoryName());
//        storeDTO.setCategoryId(categoryDTO.getId());
//
//        System.out.println(storeDTO.getName());
//        storeService.save(storeDTO);
//        System.out.println("save wenwd");
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Category Saved Successfully", null));
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<ResponseDTO> getAllImages() {
////        List<Store> storeList = storeService.getAllImages();
////
////        for (Store store : storeList) {
////            System.out.println(store.toString());
////        }
////        return new ResponseUtil(200, "User saved successfully", storeList);
////    }
//        List<StoreDTO> storeDTO = storeServiceImpl.getAllImages();
//        for (StoreDTO store : storeDTO) {
//            System.out.println(store.toString());
//        }
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Image saved successfully",storeService.getAllImages()));
//    }
//}


/*-------------------------------------------------*/
//@RestController
//@RequestMapping("api/v1/store")
//@CrossOrigin("*")
//public class StoreController {
//    @Autowired
//    private final StoreService storeService;
//    @Autowired
//    private final StoreServiceImpl storeServiceImpl;
//    @Autowired
//    UserServiceImpl userServiceImpl;
//    @Autowired
//    CategoryServiceImpl categoryServiceImpl;
//
////    private final StoreService storeService;
//
//    @Autowired
//    public StoreController(@Lazy StoreService storeService, @Lazy StoreServiceImpl storeServiceImpl) {
//        this.storeService = storeService;
//        this.storeServiceImpl = storeServiceImpl;
//    }
//
//    private static final Logger log = LoggerFactory.getLogger(StoreController.class);
//
//
//    @PostMapping("/save")
//    public ResponseEntity<ResponseDTO> save(@RequestParam("name") String name,
//                                            @RequestParam("desc") String desc,
//                                            @RequestParam("your-email") String email,
//                                            @RequestParam("price") double price,
//                                            @RequestParam("category") String category,
//                                            @RequestParam("image") MultipartFile image) {
//        // Save image to a directory
//        String imageUrl = saveImage(image);
//
//        // Create StoreDTO
//        StoreDTO storeDTO = new StoreDTO();
//        storeDTO.setName(name);
//        storeDTO.setDescription(desc);
//        storeDTO.setOwnerEmail(email);
//        storeDTO.setPrice(price);
//        storeDTO.setCategoryName(category);
//        storeDTO.setImagePath(imageUrl);
//
//        // Retrieve user and category information
//        UserDTO userDTO = userServiceImpl.findUserByEmail(email);
//        storeDTO.setOwnerId(userDTO.getId());
//        CategoryDTO categoryDTO = categoryServiceImpl.findIdByName(category);
//        storeDTO.setCategoryId(categoryDTO.getId());
//
//        // Save store
//        try {
//            storeService.save(storeDTO);
//            log.info("Data saved successfully: " + storeDTO);
//        } catch (Exception e) {
//            log.error("Error saving data", e);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Store Saved Successfully", null));
//    }
//
//    private String saveImage(MultipartFile image) {
//        if (image.isEmpty()) {
//            return null;
//        }
//
//        try {
//            // Create directory to save the image
//            String directoryPath = "uploads/";
//            File directory = new File(directoryPath);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Save the image to the directory
//            String imagePath = directoryPath + image.getOriginalFilename();
//            Path path = Paths.get(imagePath);
//            Files.write(path, image.getBytes());
//
//            return imagePath;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<ResponseDTO> getAllImages() {
//        List<StoreDTO> storeDTO = storeServiceImpl.getAllImages();
//        for (StoreDTO store : storeDTO) {
//            System.out.println(store.toString());
//        }
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Image saved successfully", storeService.getAllImages()));
//    }
//}

/*-----------------------------------------------*/
//@RestController
//@RequestMapping("api/v1/store")
//@CrossOrigin("*")
//public class StoreController {
//
//    @Autowired
//    private StoreService storeService;
//    @Autowired
//    private StoreServiceImpl storeServiceImpl;
//    @Autowired
//    private UserServiceImpl userServiceImpl;
//    @Autowired
//    private CategoryServiceImpl categoryServiceImpl;
//
//    private static final Logger log = (Logger) LoggerFactory.getLogger(StoreController.class);
//
//    @Autowired
//    public StoreController(@Lazy StoreService storeService, @Lazy StoreServiceImpl storeServiceImpl) {
//        this.storeService = storeService;
//        this.storeServiceImpl = storeServiceImpl;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<ResponseDTO> save(@RequestParam("name") String name,
//                                            @RequestParam("desc") String desc,
//                                            @RequestParam("your-email") String email,
//                                            @RequestParam("price") double price,
//                                            @RequestParam("category") String category,
//                                            @RequestParam("image") MultipartFile image) {
//        // Save image to a directory
//        String imageUrl = saveImage(image);
//
//        // Create StoreDTO
//        StoreDTO storeDTO = new StoreDTO();
//        storeDTO.setName(name);
//        storeDTO.setDescription(desc);
//        storeDTO.setOwnerEmail(email);
//        storeDTO.setPrice(price);
//        storeDTO.setCategoryName(category);
//        storeDTO.setImagePath(imageUrl);
//
//        // Retrieve user and category information
//        UserDTO userDTO = userServiceImpl.findUserByEmail(email);
//        storeDTO.setOwnerId(userDTO.getId());
//        CategoryDTO categoryDTO = categoryServiceImpl.findIdByName(category);
//        storeDTO.setCategoryId(categoryDTO.getId());
//
//        // Save store
//        try {
//            storeService.save(storeDTO);
//            log.info("Data saved successfully: " + storeDTO);
//        } catch (Exception e) {
//            log.error("Error saving data", e);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Store Saved Successfully", null));
//    }
//
//    private String saveImage(MultipartFile image) {
//        if (image.isEmpty()) {
//            return null;
//        }
//
//        try {
//            // Create directory to save the image
//            String directoryPath = "uploads/";
//            File directory = new File(directoryPath);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Save the image to the directory
//            String imagePath = directoryPath + image.getOriginalFilename();
//            Path path = Paths.get(imagePath);
//            Files.write(path, image.getBytes());
//
//            return imagePath;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<ResponseDTO> getAllImages() {
//        List<StoreDTO> storeDTO = storeServiceImpl.getAllImages();
//        for (StoreDTO store : storeDTO) {
//            System.out.println(store.toString());
//        }
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Image saved successfully", storeService.getAllImages()));
//    }
//}

/*---------------------------------------*/
//@RestController
//@RequestMapping("api/v1/store")
//@CrossOrigin("*")
//public class StoreController {
//
//    @Autowired
//    private StoreService storeService;
//    @Autowired
//    private StoreServiceImpl storeServiceImpl;
//    @Autowired
//    private UserServiceImpl userServiceImpl;
//    @Autowired
//    private CategoryServiceImpl categoryServiceImpl;
//
//    private static final Logger log = (Logger) LoggerFactory.getLogger(StoreController.class);
//
//    @Autowired
//    public StoreController(@Lazy StoreService storeService, @Lazy StoreServiceImpl storeServiceImpl) {
//        this.storeService = storeService;
//        this.storeServiceImpl = storeServiceImpl;
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<ResponseDTO> save(@RequestParam("name") String name,
//                                            @RequestParam("desc") String desc,
//                                            @RequestParam("your-email") String email,
//                                            @RequestParam("price") double price,
//                                            @RequestParam("category") String category,
//                                            @RequestParam("image") MultipartFile image) {
//        // Save image to a directory
//        String imageUrl = saveImage(image);
//
//        // Create StoreDTO
//        StoreDTO storeDTO = new StoreDTO();
//        storeDTO.setName(name);
//        storeDTO.setDescription(desc);
//        storeDTO.setOwnerEmail(email);
//        storeDTO.setPrice(price);
//        storeDTO.setCategoryName(category);
//        storeDTO.setImagePath(imageUrl);
//
//        // Retrieve user and category information
//        UserDTO userDTO = userServiceImpl.findUserByEmail(email);
//        storeDTO.setOwnerId(userDTO.getId());
//        CategoryDTO categoryDTO = categoryServiceImpl.findIdByName(category);
//        storeDTO.setCategoryId(categoryDTO.getId());
//
//        // Save image data to the database
//        try {
//            storeDTO.setImageData(image.getBytes());
//            storeService.save(storeDTO);
//            System.out.println(storeDTO.toString());
//            log.info("Data saved successfully: " + storeDTO);
//        } catch (Exception e) {
//            log.error("Error saving data", e);
//        }
//
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDTO(VarList.OK, "Store Saved Successfully", null));
//    }
//
//    private String saveImage(MultipartFile image) {
//        if (image.isEmpty()) {
//            return null;
//        }
//
//        try {
//            // Create directory to save the image
//            String directoryPath = "uploads/";
//            File directory = new File(directoryPath);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Save the image to the directory
//            String imagePath = directoryPath + image.getOriginalFilename();
//            Path path = Paths.get(imagePath);
//            Files.write(path, image.getBytes());
//
//            return imagePath;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<ResponseDTO> getAllImages() {
//       List<StoreDTO> storeDTO = storeServiceImpl.getAllImages();
//       for (StoreDTO store : storeDTO) {
//           System.out.println(store.toString());
//       }
//        return ResponseEntity.status(HttpStatus.OK)
//               .body(new ResponseDTO(VarList.OK, "Image saved successfully", storeService.getAllImages()));}
//}

@RestController
@RequestMapping("api/v1/store")
@CrossOrigin("*")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private StoreServiceImpl storeServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    private static final Logger log = (Logger) LoggerFactory.getLogger(StoreController.class);

    @Autowired
    public StoreController(@Lazy StoreService storeService, @Lazy StoreServiceImpl storeServiceImpl) {
        this.storeService = storeService;
        this.storeServiceImpl = storeServiceImpl;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> save(@RequestParam("name") String name,
                                            @RequestParam("desc") String desc,
                                            @RequestParam("your-email") String email,
                                            @RequestParam("price") double price,
                                            @RequestParam("category") String category,
                                            @RequestParam("image") MultipartFile image) {
        // Save image to a directory
        String imageUrl = saveImage(image);

        // Create StoreDTO
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setName(name);
        storeDTO.setDescription(desc);
        storeDTO.setOwnerEmail(email);
        storeDTO.setPrice(price);
        storeDTO.setCategoryName(category);
        storeDTO.setImagePath(imageUrl); // Save the image URL to the database

        System.out.println("image ek save wenwd");
        System.out.println(storeDTO.toString());

        // Retrieve user and category information
//        UserDTO userDTO = userServiceImpl.findUserByEmail(email);
//        storeDTO.setOwnerId(userDTO.getId());
//        CategoryDTO categoryDTO = categoryServiceImpl.findIdByName(category);
//        storeDTO.setCategoryId(categoryDTO.getId());

        UserDTO userDTO = userServiceImpl.findUserByEmail(email);
        CategoryDTO categoryDTO = categoryServiceImpl.findIdByName(category);

        if (userDTO != null && categoryDTO != null) {
            storeDTO.setOwnerId(userDTO.getId());
            storeDTO.setCategoryId(categoryDTO.getId()); // Set the category ID
        } else {
            // Handle the case where user or category is not found
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDTO(400, "User or Category not found", null));
        }

        // Save store
        try {
            storeService.save(storeDTO);
            log.info("Data saved successfully: " + storeDTO);
            System.out.println("image ek save wenwd22222");
        } catch (Exception e) {
            log.error("Error saving data", e);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(VarList.OK, "Store Saved Successfully", null));
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
       List<StoreDTO> storeDTO = storeServiceImpl.getAllImages();
       for (StoreDTO store : storeDTO) {
           System.out.println(store.toString());
       }
        return ResponseEntity.status(HttpStatus.OK)
               .body(new ResponseDTO(VarList.OK, "Image saved successfully", storeService.getAllImages()));}
}


/*------------------------------------*/




// frontend to backend send image wth data ( no json, use form data )
// before database ,save image anyware ( selfstudy)
// save full data into database with image url