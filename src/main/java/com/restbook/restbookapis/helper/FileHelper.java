package com.restbook.restbookapis.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
    
    public FileHelper() throws IOException {
        
    }

    // public final String UPLOAD_DIR = "D:\\Spring Boot Projects\\restbookapis\\src\\main\\resources\\static\\image";
    public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();


    public boolean uploadFile(MultipartFile multipartFile) {
        boolean f = false;
        try {
            // With Input Stream API
           /*  InputStream is = multipartFile.getInputStream();
            byte data[] = new byte[is.available()];
            is.read(data);

            // write
            FileOutputStream fos= new FileOutputStream(UPLOAD_DIR + "\\" +multipartFile.getOriginalFilename());
            fos.write(data);
            fos.close();*/
            Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR + File.separator+multipartFile.getOriginalFilename()) , StandardCopyOption.REPLACE_EXISTING);
            f = true;
        } catch (IOException e) {
            e.getMessage();
        }
        return f;
    }
}
