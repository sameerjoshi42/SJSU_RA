package com.SJSU.MusicScore.Clarinet.Service;

import com.SJSU.MusicScore.Clarinet.Constants.ClarinetConstants;
import com.SJSU.MusicScore.Clarinet.Exception.ClarinetException;
import com.SJSU.MusicScore.Clarinet.Model.FlatRequest;
import com.SJSU.MusicScore.Clarinet.Model.FlatResponse;
import com.SJSU.MusicScore.Clarinet.Utils.FileConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class FlatServiceImpl implements FlatService {


    private WebClient.Builder webClient;

    private FileConverterUtils fileConverterUtils;

    @Autowired
    public FlatServiceImpl(WebClient.Builder webClient,FileConverterUtils fileConverterUtils){
        this.webClient = webClient;
        this.fileConverterUtils = fileConverterUtils;
    }
    
    @Override
    public FlatResponse createScore(MultipartFile file,String token){

        String encodedData = this.fileConverterUtils.EncodeFile(file);
        FlatRequest flatRequest = getFlatRequest(encodedData);

        try {
            return webClient.build().post()
                    .uri(ClarinetConstants.BASE_URL + ClarinetConstants.SCORE_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .header(ClarinetConstants.AUTHORIZATION, token)
                    .body(BodyInserters.fromValue(flatRequest))
                    .retrieve()
                    .bodyToMono(FlatResponse.class).block();
        }
        catch (Exception e){
            throw new ClarinetException(ClarinetConstants.FLAT_EXCEPTION_MESSAGE + e.getMessage());

        }
    }

    private static FlatRequest getFlatRequest(String encodedData) {
        FlatRequest flatRequest = new FlatRequest(encodedData,ClarinetConstants.BASE_64);
        return flatRequest;
    }
}
