package com.ivanmix.component;

import java.io.IOException;
import java.nio.file.Path;

public interface ImageComponent {

    void pngToJpeg(Path inPath, Path outPath) throws IOException;

    String getBigImageName();

    String getSmallImageName(String bigImage);

    Path getUploadPath(String fileUploadDirectory, String bigImageUrl);
}