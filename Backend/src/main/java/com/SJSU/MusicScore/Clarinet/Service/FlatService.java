package com.SJSU.MusicScore.Clarinet.Service;

import com.SJSU.MusicScore.Clarinet.Model.FlatResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FlatService {

    public FlatResponse createScore(MultipartFile file,String token);
}
