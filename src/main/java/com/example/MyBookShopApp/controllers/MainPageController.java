package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }

    @GetMapping("/signin")
    public String signInPage() {
        return "signin";
    }

    @GetMapping("/cart")
    public String cartPage() {
        return "cart";
    }

    @GetMapping("/postponed")
    public String postponedPage(){
        return "postponed";
    }
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/faq")
    public String faqPage() {
        return "faq";
    }

    @GetMapping("/contacts")
    public String contactPage() {
        return "contacts";
    }

    @GetMapping("/documents")
    public String documentsPage() {
        return "documents/index";
    }
}
