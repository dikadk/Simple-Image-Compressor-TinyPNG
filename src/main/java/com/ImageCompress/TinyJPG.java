package com.ImageCompress;

import com.tinify.ClientException;
import com.tinify.Source;
import com.tinify.Tinify;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by home on 1/26/17.
 */
public class TinyJPG {

    InputStream inputStream;

    public TinyJPG() throws IOException {
        Tinify.setKey(getApiKey());
    }

    public String getApiKey() throws IOException {
        String api_key ="";
        try{
            Properties properties = new Properties();
            String propFileName = "config.properties";

            inputStream = new FileInputStream((propFileName));
            if(inputStream!=null){
                properties.load(inputStream);
            }else{
                throw new FileNotFoundException("property file '" + propFileName + "' not found in classpath");
            }
            api_key = properties.getProperty("key");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return api_key;
    }

    public void compressImages(ArrayList<String> fileNames){
        for(String fileName :fileNames){
            try {
                Source source = Tinify.fromFile(fileName);
                source.toFile(fileName);
            } catch (ClientException e) {
                System.out.println("Unsupported file format "+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void validateApiKey(){
        try {
            Tinify.validate();
            System.out.println("Api-Key is valid");
        } catch(java.lang.Exception e) {
            System.out.println("Api-Key is invalid");
        }

    }
}
