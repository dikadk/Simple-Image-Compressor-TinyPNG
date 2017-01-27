package com.ImageCompress;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class ImageCompressor
{
    public static void main( String[] args ) throws IOException {

        ArrayList<File> files = new ArrayList<File>();
        Files.listFiles(".",files);
        ArrayList<String> fileNames = Files.getFilenames(files);

        TinyJPG tinyJPG = new TinyJPG();
        tinyJPG.validateApiKey();
        tinyJPG.compressImages(fileNames);
    }


}
