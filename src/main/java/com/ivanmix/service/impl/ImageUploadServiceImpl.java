package com.ivanmix.service.impl;


import com.ivanmix.Constants;
import net.coobird.thumbnailator.Thumbnails;
import com.ivanmix.component.ImageComponent;
import com.ivanmix.models.UploadImage;
import com.ivanmix.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public UploadImage approveImage(UploadImage image){

        Path oldPathImageBig = Paths.get(Constants.FILE_UPLOAD_DIRECTORY + image.getBigImage());
        Path oldPathImageSmall = Paths.get(Constants.FILE_UPLOAD_DIRECTORY + image.getSmallImage());

        String dateFolder =  new SimpleDateFormat("/yyyy/MM/").format(new Date());


        Path newPathImageBig = Paths.get(Constants.FILE_UPLOAD_DIRECTORY + "/media" +dateFolder + oldPathImageBig.getFileName());
        Path newPathImageSmall = Paths.get(Constants.FILE_UPLOAD_DIRECTORY + "/media" + dateFolder + oldPathImageSmall.getFileName());


        Path path = Paths.get(Constants.FILE_UPLOAD_DIRECTORY + "/media" +dateFolder);
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

        String shortBigImagePath = newPathImageBig.toString().replace(Constants.FILE_UPLOAD_DIRECTORY,"");
        String shortSmallImagePath = newPathImageSmall.toString().replace(Constants.FILE_UPLOAD_DIRECTORY,"");

        return new  UploadImage(shortBigImagePath, shortSmallImagePath);
    }


    protected UploadImage processUpload(MultipartFile file) throws IOException{
        String bigImageName = imageComponent.getBigImageName();
        Path bigImagePath = imageComponent.getUploadPath(bigImageName);
        multipartFileUploadToJpeg(file, bigImagePath);

        String smallImageName = imageComponent.getSmallImageName(bigImageName);
        Path smallImagePath = imageComponent.getUploadPath(smallImageName);

        Thumbnails.of(bigImagePath.toString()).size(100, 100).toFile(smallImagePath.toString());

        String shortBigImagePath = bigImagePath.toString().replace(Constants.FILE_UPLOAD_DIRECTORY,"");
        String shortSmallImagePath = smallImagePath.toString().replace(Constants.FILE_UPLOAD_DIRECTORY,"");

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
