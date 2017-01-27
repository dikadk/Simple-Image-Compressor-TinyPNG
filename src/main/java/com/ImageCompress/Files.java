package com.ImageCompress;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by home on 1/26/17.
 */
public class Files {
    public static void listFiles(String directoryName, ArrayList<File> files){
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for(File file :fList){
            if(file.isFile() & !file.isHidden()){
                files.add(file);
            }else if(file.isDirectory()){
                listFiles(file.getAbsolutePath(), files);
            }
        }
    }

    public static ArrayList<String> getFilenames(ArrayList<File> files){
        ArrayList<String> fileNames = new ArrayList<String>();
        for(File file: files){
            if(file.getName().endsWith(".jpg") || file.getName().endsWith(".png") || file.getName().endsWith(".JPEG")){
                fileNames.add(file.getAbsolutePath());
            }
        }
        return fileNames;
    }
}
