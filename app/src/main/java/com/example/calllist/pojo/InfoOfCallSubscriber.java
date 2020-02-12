package com.example.calllist.pojo;

import java.util.Objects;

public class InfoOfCallSubscriber {
    private String name;
    private String creationDate;

    public InfoOfCallSubscriber(String name, String creationDate) {
        this.name = name;
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoOfCallSubscriber that = (InfoOfCallSubscriber) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, creationDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
