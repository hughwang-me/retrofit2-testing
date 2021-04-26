package com.uwjx.retrofit2.client.test;

import com.uwjx.retrofit2.client.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class TestService {

    @Autowired
    BookService bookService;

    @PostConstruct
    public void books(){
        log.warn("程序启动");
        bookService.listBooks();
    }
}
