package org.Image.controller;

import org.Image.service.ImageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.Image.dto.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RequestMapping("/image")
@RestController
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService=imageService;
    }
   @Value("${upload.dir}")
    private String fileLoacted;


    @PostMapping("/upload")
    public Result testApi(@RequestParam("image") MultipartFile file){

        try {
            InputStream inputStream = file.getInputStream();
            BufferedInputStream bufferedInputStream= new BufferedInputStream(inputStream);
            byte[] fileBytes=bufferedInputStream.readAllBytes();
            FileOutputStream fileOutputStream=new FileOutputStream(new File(fileLoacted+file.getOriginalFilename()));
              fileOutputStream.write(fileBytes);


            System.out.println("success");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result();
    }

    @PostMapping("/test1")
    public Result test(){
        System.out.println(123);
        return new Result();
    }




}
