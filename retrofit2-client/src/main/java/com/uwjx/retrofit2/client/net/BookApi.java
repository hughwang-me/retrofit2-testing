package com.uwjx.retrofit2.client.net;

import com.uwjx.retrofit2.common.model.Book;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface BookApi {

    @GET(value = "book/books")
    Call<List<Book>> books();
}
