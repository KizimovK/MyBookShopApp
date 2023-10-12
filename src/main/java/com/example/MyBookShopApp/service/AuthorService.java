package com.example.MyBookShopApp.service;

import com.example.MyBookShopApp.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
}