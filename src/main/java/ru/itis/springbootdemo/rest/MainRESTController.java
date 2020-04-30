package ru.itis.springbootdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.models.UploadForm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@RestController
public class MainRESTController {

    private static String UPLOAD_DIR = "/home/tanya/IdeaProjects/Shelter/shelterSpring/src/main/resources/static/img/upload";

    @PostMapping("/rest/uploadMultiFiles")
    public ResponseEntity<?> multiUploadFileModel(@ModelAttribute UploadForm form) {

        System.out.println("Description:" + form.getDescription());

        String result = null;
        try {

            result = this.saveUploadedFiles(form.getFiles());
            System.out.println("SAVE");
        }
        catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error " , HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>("Uploaded ",HttpStatus.OK);

    }

    // Save Files
    private String saveUploadedFiles(MultipartFile[] files) throws IOException {

        // Make sure directory exists!
        File uploadDir = new File(UPLOAD_DIR);

        StringBuilder sb = new StringBuilder();

        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;
            }
            String uploadFilePath = UPLOAD_DIR + "/" + file.getOriginalFilename();

            byte[] bytes = file.getBytes();
            Path path = Paths.get(uploadFilePath);
            Files.write(path, bytes);

            System.out.println("HERE");
            sb.append(uploadFilePath).append("<br/>");
        }
        return sb.toString();
    }
}