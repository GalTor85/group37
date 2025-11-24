package com.model;

import java.util.List;

public class Author {
    private String lastName;
    private String firstName;
    private List<Titles> titlesList;

    public List<Titles> getTitlesList() {
        return titlesList;
    }

    public void setTitlesList(List<Titles> titlesList) {
        this.titlesList = titlesList;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Name:"+lastName+" "+firstName+"\nTitles:"+this.titlesList.toString();
    }
}
