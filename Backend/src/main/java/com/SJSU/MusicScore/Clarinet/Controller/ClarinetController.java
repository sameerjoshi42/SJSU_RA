package com.SJSU.MusicScore.Clarinet.Controller;

import com.SJSU.MusicScore.Clarinet.Constants.ClarinetConstants;
import com.SJSU.MusicScore.Clarinet.Model.FlatResponse;
import com.SJSU.MusicScore.Clarinet.Service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@RestController
public class ClarinetController {
    private FlatService flatService;

    @Autowired
    public ClarinetController(FlatService flatService){
        this.flatService = flatService;
    }

    @CrossOrigin(origins = ClarinetConstants.CLIENT_URL)
    @PostMapping(value = "/notes",consumes = "multipart/form-data")
    public ResponseEntity<FlatResponse> createScore(@RequestPart(name = "file")MultipartFile file
    ,@RequestHeader(name= ClarinetConstants.AUTHORIZATION) String token){
        FlatResponse response = this.flatService.createScore(file,token);
        return ResponseEntity.ok(response);
    }
}
