package com.uwjx.retrofit2.client.service.impl;

import com.uwjx.retrofit2.client.net.BookApi;
import com.uwjx.retrofit2.client.service.BookService;
import com.uwjx.retrofit2.common.model.Book;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    public List<Book> listBooks() {
        List<Book> books = new ArrayList<Book>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .build();

        BookApi bookApi = retrofit.create(BookApi.class);
        try {
            ResponseBody responseBody = bookApi.books().execute().body();
            log.warn("{}" , responseBody.string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
