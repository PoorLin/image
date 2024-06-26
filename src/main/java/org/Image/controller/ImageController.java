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


    @Value("${file.path}")
    private String path;

    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService=imageService;
    }


    @PostMapping("/upload")
    public Result testApi(@RequestParam("image") MultipartFile file,@RequestParam("imageId")Integer imageId){

        try {
            InputStream inputStream = file.getInputStream();
            BufferedInputStream bufferedInputStream= new BufferedInputStream(inputStream);
            byte[] fileBytes=bufferedInputStream.readAllBytes();
            String[] orgFileArr = file.getOriginalFilename().split("\\.");
            int length = orgFileArr.length;


            FileOutputStream fileOutputStream=new FileOutputStream(new File(path+imageId+"."+orgFileArr[length-1]));
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
