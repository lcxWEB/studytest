package com.star.lambda;

import java.util.List;

/**
 * Created by lichunxia on 2020-03-16 14:38
 */
public class Topic {

    private String id;

    private List<String> names;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
