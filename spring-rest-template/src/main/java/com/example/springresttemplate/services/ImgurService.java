package com.example.springresttemplate.services;

import com.example.springresttemplate.models.ImgurData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImgurService {
    RestTemplate template;

    public ImgurService(RestTemplate template) {
        this.template = template;
    }

    // Our goal here is to:
    // ask the Imgur Service for Data
    // parse the data and return it
    public ImgurData getData() {
        // Imgur requires us to use http headers to
        // authorize our requests. we'll put them here.
        HttpHeaders headers = new HttpHeaders();

        // the headers are basically a HashMap<String, List<String>>.
        // so, we need to put our (one) value in a list in order to use it.
        List<String> authheaders = new ArrayList<>();


        authheaders.add("Client-ID f57abf3d29060ca");

        // the Authorization header is used by many servers to authorize
        // users.
        headers.put("authorization", authheaders);

        // an "HttpEntity" is a representation of our request object. many
        // times we will need to use this entity to send data to the server.
        // in this case, we just need it basically to send the headers.
        HttpEntity<ImgurData> data = new HttpEntity<>(new ImgurData(), headers);

        // we issue our request to the Imgur API and parse the response into a `ImgurData`
        // object.
        HttpEntity<ImgurData> response = template.exchange("https://api.imgur.com/3/gallery/r/aww", HttpMethod.GET, data, ImgurData.class);

        return response.getBody();
    }
}
