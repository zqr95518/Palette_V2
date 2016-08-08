package com.hhigh.palette_v2.domain;

/**
 * Created by 乔然 on 2016/8/8.
 */
public class Palette {
    String id;
    String name;
    String color;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
