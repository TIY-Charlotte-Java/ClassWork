package com.example.springresttemplate.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


// OUTER CLASS
public class ImgurData {
    // the names of these fields
    // MUST MATCH the field names in the JSON.
    private boolean success;
    private int status;

    @JsonProperty("data")
    private List<ImgurImage> images;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ImgurImage> getImages() {
        return images;
    }

    public void setImages(List<ImgurImage> data) {
        this.images = data;
    }

    // INNER CLASS
    // we include the "static" keyword here for technical reasons
    // involving json serializing and deserializing.
    public static class ImgurImage {
        private String title;
        private String link;
        private Long datetime;
        private int width;
        private int height;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Long getDatetime() {
            return datetime;
        }

        public void setDatetime(Long datetime) {
            this.datetime = datetime;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
