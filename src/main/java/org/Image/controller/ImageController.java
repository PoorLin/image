package org.Image.controller;

import org.Image.request.ImageRequest;
import org.Image.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.Image.dto.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import static org.Image.constant.Constance.SUCCESS;

@RequestMapping("/image")
@RestController
public class ImageController {


    @Value("${file.path}")
    private String path;

    private final ImageService imageService;

    public ImageController(ImageService imageService){
        this.imageService=imageService;
    }

    private Logger log = LoggerFactory.getLogger(ImageController.class);
    @PostMapping("/upload")
    public Result testApi(@RequestBody ImageRequest imageRequest){
        try {
            FileOutputStream fileOutputStream=new FileOutputStream(new File(path+imageRequest.getFileName()));
              fileOutputStream.write(imageRequest.getData());
              fileOutputStream.close();
        }catch (Exception e){
            log.error("file upload fail...");
        }
        return new Result(SUCCESS);
    }

    @PostMapping("/uploadReplace")
    public Result uploadReplaceImage(@RequestParam("image") MultipartFile file,@RequestParam("imageId")Integer imageId){
        try {
            InputStream inputStream = file.getInputStream();
            BufferedInputStream bufferedInputStream= new BufferedInputStream(inputStream);
            byte[] fileBytes=bufferedInputStream.readAllBytes();
            String[] orgFileArr = file.getOriginalFilename().split("\\.");
            int length = orgFileArr.length;
            FileOutputStream fileOutputStream=new FileOutputStream(new File(path+imageId+"."+orgFileArr[length-1]));
            fileOutputStream.write(fileBytes);
        }catch (Exception e){
            log.error("file upload fail...");
        }
        return new Result(SUCCESS);
    }



    @PostMapping("/delete")
    public Result deleteFile(@RequestParam("fileName") String fileName){
        System.out.println(fileName);
        try {
            File thisFile = new File(path+fileName);
            thisFile.deleteOnExit();
        }catch (Exception e){
            log.error("file delete fail...");
        }
        return new Result(SUCCESS);
    }

    @PostMapping("/test1")
    public Result test(){
        System.out.println(123);
        return new Result();
    }




}
