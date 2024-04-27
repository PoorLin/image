package Image.service;

import Image.dao.ImageDao;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private final ImageDao imageDao;

    public ImageService(ImageDao imageDao){
        this.imageDao=imageDao;
    }





}
