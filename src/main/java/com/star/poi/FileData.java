package com.star.poi;

// import com.deepoove.poi.config.Name;

public class FileData {

    private String title;
    private String dh;
    // @Name("var")
    private DetailData detailData;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public DetailData getDetailData() {
        return detailData;
    }

    public void setDetailData(DetailData detailData) {
        this.detailData = detailData;
    }
}
