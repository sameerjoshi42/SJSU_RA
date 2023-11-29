package com.SJSU.MusicScore.Clarinet.Utils;


import com.SJSU.MusicScore.Clarinet.Exception.ClarinetException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

@Component
public class FileConverterUtils {

    // this method converts the .midi file to an encoded base 64 format which is sent as an input data to flat API.
    public String EncodeFile(MultipartFile multipartFile){

        try {
            byte[] fileData = multipartFile.getBytes();
            return Base64.getEncoder().encodeToString(fileData);
        } catch (IOException e) {
            throw new ClarinetException(e.getMessage());
        }
    }
}

