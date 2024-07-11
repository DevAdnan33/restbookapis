package com.restbook.restbookapis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.restbook.restbookapis.helper.FileHelper;

@RestController
public class FileUploadControl {

    @Autowired
    private FileHelper fileHelper;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

        try {

            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }
            // If image is not jpeg
            /*if (!file.getContentType().equals("image/jpeg")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain jpeg file");
            }*/
            // file upload code
            boolean f = fileHelper.uploadFile(file);
            if (f) {
                // return ResponseEntity.ok("File is Successfully uplaoded.");
                return  ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            e.getMessage();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }

}
