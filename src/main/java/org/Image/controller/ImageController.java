package org.Image.controller;

import org.Image.service.ImageService;
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


    @PostMapping("/upload")
    public Result testApi(@RequestParam("file") byte[] file,@RequestParam("fileName")String fileName){

        try {



            FileOutputStream fileOutputStream=new FileOutputStream(new File(path+fileName));
              fileOutputStream.write(file);
              fileOutputStream.close();
            System.out.println("success");
        }catch (Exception e){
            System.out.println(e);
        }
        return new Result();
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


            System.out.println("success");
        }catch (Exception e){
            System.out.println(e);
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
            System.out.println(e);
        }
        return new Result(SUCCESS);
    }

    @PostMapping("/test1")
    public Result test(){
        System.out.println(123);
        return new Result();
    }




}
