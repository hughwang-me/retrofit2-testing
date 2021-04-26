package com.uwjx.retrofit2.client.net;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface BookApi {

    @GET(value = "book/books")
    Call<ResponseBody> books();
}
