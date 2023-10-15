package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class AuthorService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setName(rs.getString("name"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public Author getAuthorById(int authorId) {
       return jdbcTemplate.queryForObject(
               "SELECT id, name FROM authors WHERE id = ?",
                (rs, rowNum) -> {
                   Author author = new Author();
                   author.setId(rs.getInt("id"));
                   author.setName(rs.getString("name"));
                   return  author;
                },authorId);
    }

    public Map<Character, List<Author>> getMapLetterAuthorsList(){
        Map<Character, List<Author>> mapLetterAuthorsList = new TreeMap<>();
        List<Author> authorsList = getAuthorsData();
        for (Author author : authorsList){
            char letter = author.getName().charAt(0);
            if (!mapLetterAuthorsList.containsKey(letter)){
                mapLetterAuthorsList.put(letter,new ArrayList<>());
            }
            mapLetterAuthorsList.get(letter).add(author);
        }
        return new TreeMap<>(mapLetterAuthorsList);
    }
}