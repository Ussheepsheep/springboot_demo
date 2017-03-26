package com.githup.ussheepsheep.web;

import com.githup.ussheepsheep.util.Uid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by daren on 3/26/2017.
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public ResponseEntity upload(@RequestBody MultipartFile file) {
        try {
            String name = file.getOriginalFilename();
            String type = name.substring(name.lastIndexOf("."));
            String fileName = System.getProperty("user.dir") + "/file/" + Uid.orderUid() + type;
            Path path = Paths.get(fileName);
            File parentFile = path.getParent().toFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Files.write(path, file.getBytes());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
