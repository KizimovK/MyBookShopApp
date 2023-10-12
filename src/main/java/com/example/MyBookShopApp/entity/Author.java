package com.example.MyBookShopApp.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "authors")
public class Author {

    private Integer id;
    private String name;

    @OneToMany(mappedBy = "author")
    private List<Book> bookList = new ArrayList<>();

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + name + '\'' +
                '}';
    }
}
