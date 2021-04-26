package com.uwjx.retrofit2.client.service.impl;

import com.uwjx.retrofit2.client.net.BookApi;
import com.uwjx.retrofit2.client.service.BookService;
import com.uwjx.retrofit2.common.model.Book;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

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
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        BookApi bookApi = retrofit.create(BookApi.class);
        try {
            Call<List<Book>> call = bookApi.books();
            List<Book> bookList = call.execute().body();
            for (Book book : bookList) {
                log.warn("{}" , book.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return books;
    }
}
