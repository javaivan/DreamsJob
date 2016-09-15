package com.ivanmix.service.impl;


import net.coobird.thumbnailator.Thumbnails;
import com.ivanmix.component.ImageComponent;
import com.ivanmix.models.UploadImage;
import com.ivanmix.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    @Autowired
    private ImageComponent imageComponent;

    @Override
    public UploadImage uploadNewImage(MultipartFile file) {
        try {
            UploadImage image = processUpload(file);
            return image;
        } catch (IOException e){
            System.out.println(e);
            return null;
            /*throw new CantCompleteClientRequestException("Can't save  image upload: " + e.getMessage(), e);*/
        }
    }

    protected UploadImage processUpload(MultipartFile file) throws IOException{
        String bigImageName = imageComponent.getBigImageName();
        Path bigImagePath = imageComponent.getUploadPath(bigImageName);
        multipartFileUploadToJpeg(file, bigImagePath);

        String smallImageName = imageComponent.getSmallImageName(bigImageName);
        Path smallImagePath = imageComponent.getUploadPath(smallImageName);

        Thumbnails.of(bigImagePath.toString()).size(100, 100).toFile(smallImagePath.toString());
        return new  UploadImage(bigImageName, smallImageName);
    }

    protected void multipartFileUploadToJpeg(MultipartFile file, Path path) throws IOException{
        String fileType = file.getContentType();
        file.transferTo(path.toFile());
        if (fileType.contains("png")){
            imageComponent.PngToJpeg(path, path);
        } else if(!fileType.contains("jpg") && !fileType.contains("jpeg")){
            System.out.println("Only png and jpg image formats are supported: Current content type = " + fileType);
            //throw new CantCompleteClientRequestException("Only png and jpg image formats are supported: Current content type=" + fileType);
        }

    }

    /*
    * File photo = new File(MEDIA_DIR + "/certificates/" + uid);
			if (!photo.getParentFile().exists()) {
				photo.getParentFile().mkdirs();
			}
    * */
}
