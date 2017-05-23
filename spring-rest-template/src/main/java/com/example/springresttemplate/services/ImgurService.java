package com.example.springresttemplate.services;

import com.example.springresttemplate.models.ImgurData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImgurService {
    RestTemplate template;

    public ImgurService(RestTemplate template) {
        this.template = template;
    }

    // Our goal here is to:
    // ask the Imgur Service for Data
    // parse the data and return it
    public ImgurData getData(String subreddit, String sortType) {
        // Imgur requires us to use http headers to
        // authorize our requests. we'll put them here.
        HttpHeaders headers = new HttpHeaders();

        // the headers are basically a HashMap<String, List<String>>.
        // so, we need to put our (one) value in a list in order to use it.
        List<String> authheaders = new ArrayList<>();

        authheaders.add(String.format("Client-ID %s", System.getenv("IMGUR_SECRET_KEY")));

        // the Authorization header is used by many servers to authorize
        // users.
        headers.put("authorization", authheaders);

        // an "HttpEntity" is a representation of our request object. many
        // times we will need to use this entity to send data to the server.
        // in this case, we just need it basically to send the headers.
        HttpEntity<ImgurData> data = new HttpEntity<>(new ImgurData(), headers);

        // Map is the interface
        Map<String, Object> uriVars = new HashMap<>();

        // we're putting the subredditName key into the map
        // because that's the name of the key in the URL template
        // below
        uriVars.put("subredditName", subreddit);
        uriVars.put("sort", sortType);
        uriVars.put("window", "day");
        uriVars.put("page", 1);

        // we issue our request to the Imgur API and parse the response into a `ImgurData`
        // object.
        HttpEntity<ImgurData> response = template.exchange("https://api.imgur.com/3/gallery/r/{subredditName}/{sort}/{window}/{page}", HttpMethod.GET, data, ImgurData.class, uriVars);

        return response.getBody();
    }
}
