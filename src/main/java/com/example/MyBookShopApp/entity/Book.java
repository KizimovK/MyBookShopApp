package com.example.MyBookShopApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "books")
public class Book {

    private Integer id;
    @ManyToOne()
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;
    private String title;
    @Column(name = "price_old")
    private Integer priceOld;
    private Integer price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author.getId() + '\'' +
                ", title='" + title + '\'' +
                ", priceOld=" + priceOld +
                ", price=" + price +
                '}';
    }

}
