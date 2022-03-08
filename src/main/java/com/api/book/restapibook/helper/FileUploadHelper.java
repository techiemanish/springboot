package com.api.book.restapibook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadHelper {
    //public final String upload_dir = "C:\\Users\\manis\\OneDrive\\Desktop\\SpringBootProject\\rest-api-book\\src\\main\\resources\\static\\images";
    public final String upload_dir = new ClassPathResource("static/images/").getFile().getAbsolutePath();
    

    public FileUploadHelper() throws IOException {
    }


    public boolean uploadFile(MultipartFile file){
        boolean flag = false;
            
        try {
            // InputStream is = file.getInputStream();
            // byte data [] = new byte[is.available()];
            // is.read(data);

            // //Write
            // FileOutputStream fos = new FileOutputStream(upload_dir +File.separator+file.getOriginalFilename());
            // fos.write(data);
            // fos.flush();
            // fos.close();
            Files.copy(file.getInputStream(), Paths.get(upload_dir+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            flag = true;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
