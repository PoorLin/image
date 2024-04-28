package org.Image.service;



import org.Image.dao.ImageDao;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private ImageDao imageDao;

    public ImageService(ImageDao imageDao){
        this.imageDao=imageDao;
    }





}
