package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entrada {

    @JsonProperty("API")
    String API;
    @JsonProperty("Description")
    String Description;
    @JsonProperty("Auth")
    String Auth;
    @JsonProperty("HTTPS")
    boolean HTTPS;
    @JsonProperty("Cors")
    String Cors;
    @JsonProperty("Link")
    String Link;
    @JsonProperty("Category")
    String Category;

    public boolean isHTTPS() {
        return HTTPS;
    }

    public void setHTTPS(boolean HTTPS) {
        this.HTTPS = HTTPS;
    }

    //    private String API;
//    private String Description;
//    private String Auth;
//    private boolean HTTPS;
//    private String Cors;
//    private String Link;
//    private String Category;

//             API": "AdoptAPet",
//            "Description": "Resource to help get pets adopted",
//            "Auth": "apiKey",
//            "HTTPS": true,
//            "Cors": "yes",
//            "Link": "https://www.adoptapet.com/public/apis/pet_list.html",
//            "Category": "Animals"
}
