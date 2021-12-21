package com.tahaprojects.jsontesting2;

public class MyData {
    private int id;
    private String imgUrl;
    private String title;
    private String email;

    public MyData(int id, String imgUrl, String title, String email) {
        this.id = id;
        this.imgUrl ="https://static.vecteezy.com/system/resources/previews/000/549/264/original/vector-a-boy-scout-wearing-uniform.jpg";
        this.title = title;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
