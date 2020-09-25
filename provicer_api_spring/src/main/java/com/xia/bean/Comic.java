package com.xia.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comic implements Serializable {
    private Integer id;
    private String comicName;
    private String comicMusic;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date comicTime;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComicName() {
        return comicName;
    }

    public void setComicName(String comicName) {
        this.comicName = comicName;
    }

    public String getComicMusic() {
        return comicMusic;
    }

    public void setComicMusic(String comicMusic) {
        this.comicMusic = comicMusic;
    }

    public Date getComicTime() {
        return comicTime;
    }

    public void setComicTime(Date comicTime) {
        this.comicTime = comicTime;
    }
}
