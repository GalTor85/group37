package com.model;

import java.util.List;

public class ListOfAuthor {
    private List<Author> list;

    public List<Author> getList() {
        return list;
    }

    public void setList(List<Author> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
