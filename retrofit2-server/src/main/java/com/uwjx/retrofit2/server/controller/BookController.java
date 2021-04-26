package com.uwjx.retrofit2.server.controller;

import com.uwjx.retrofit2.common.model.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @GetMapping(value = "books")
    public List<Book> listBook(){
        List<Book> books = new ArrayList<Book>();
        for (int i = 0; i < 5; i++) {
            Book book = new Book();
            book.setId(i);
            book.setName("书籍 : " + i);
            book.setAuthor("作者");
            books.add(book);
        }
        return books;
    }
}
