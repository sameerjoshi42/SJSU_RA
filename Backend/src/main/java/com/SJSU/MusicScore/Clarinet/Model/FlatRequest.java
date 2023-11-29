package com.SJSU.MusicScore.Clarinet.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
public class FlatRequest {
    @JsonProperty("data")
    private String data;
    @JsonProperty("dataEncoding")
    private String dataEncoding;

    public FlatRequest(String encodedData, String dataEncoding) {
        this.data = encodedData;
        this.dataEncoding = dataEncoding;
    }
}
