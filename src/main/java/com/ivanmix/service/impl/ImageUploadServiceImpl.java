package com.ivanmix.service.impl;


import com.ivanmix.Constants;
import net.coobird.thumbnailator.Thumbnails;
import com.ivanmix.component.ImageComponent;
import com.ivanmix.models.UploadImage;
import com.ivanmix.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ImageUploadServiceImpl implements ImageUploadService {

    @Autowired
    private ImageComponent imageComponent;

    @Autowired
    private String fileUploadDirectory;

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

    @Override
    public UploadImage approveImage(UploadImage image){

        Path oldPathImageBig = Paths.get(fileUploadDirectory + image.getBigImage());
        Path oldPathImageSmall = Paths.get(fileUploadDirectory + image.getSmallImage());

        String dateFolder =  new SimpleDateFormat("/yyyy/MM/").format(new Date());


        Path newPathImageBig = Paths.get(fileUploadDirectory + "/media" +dateFolder + oldPathImageBig.getFileName());
        Path newPathImageSmall = Paths.get(fileUploadDirectory + "/media" + dateFolder + oldPathImageSmall.getFileName());


        Path path = Paths.get(fileUploadDirectory + "/media" +dateFolder);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.move(oldPathImageBig,newPathImageBig, StandardCopyOption.REPLACE_EXISTING);
            Files.move(oldPathImageSmall,newPathImageSmall, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }

        String shortBigImagePath = newPathImageBig.toString().replace(fileUploadDirectory,"");
        String shortSmallImagePath = newPathImageSmall.toString().replace(fileUploadDirectory,"");

        return new  UploadImage(shortBigImagePath, shortSmallImagePath);
    }

    @Override
    public void deleteImage(String url){
        Path path = Paths.get(fileUploadDirectory + url);
        try {
            Files.delete(path);
        } catch (IOException e) {
            System.err.println(e);
        }
    }


    protected UploadImage processUpload(MultipartFile file) throws IOException{
        String bigImageName = imageComponent.getBigImageName();
        Path bigImagePath = imageComponent.getUploadPath(fileUploadDirectory,bigImageName);
        multipartFileUploadToJpeg(file, bigImagePath);

        String smallImageName = imageComponent.getSmallImageName(bigImageName);
        Path smallImagePath = imageComponent.getUploadPath(fileUploadDirectory,smallImageName);

        Thumbnails.of(bigImagePath.toString()).size(100, 100).toFile(smallImagePath.toString());

        String shortBigImagePath = bigImagePath.toString().replace(fileUploadDirectory,"");
        String shortSmallImagePath = smallImagePath.toString().replace(fileUploadDirectory,"");

        return new  UploadImage(shortBigImagePath, shortSmallImagePath);
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
