package com.spm.sejarahtingkatanempat;

public class student {

    private String name, id, password, image, address;


    public student()
    {

    }

    public student (String name, String id, String password, String image, String address) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.image = image;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId (String id) {
        this.id= id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}








