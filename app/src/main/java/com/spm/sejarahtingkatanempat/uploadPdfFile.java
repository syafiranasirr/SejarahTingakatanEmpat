package com.spm.sejarahtingkatanempat;

public class uploadPdfFile {
    public String name;
    public String url;

    public uploadPdfFile() {
    }

    public uploadPdfFile(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() { return url; }

    public void setUrl(String url) {
        this.url = url;
    }
}


