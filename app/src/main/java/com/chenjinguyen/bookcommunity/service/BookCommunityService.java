package com.chenjinguyen.bookcommunity.service;

import com.chenjinguyen.bookcommunity.model.Response.AuthResponse;
import com.chenjinguyen.bookcommunity.model.Response.BookResponse;
import com.chenjinguyen.bookcommunity.model.Response.BooksResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BookCommunityService {
    @GET("book/")
    Call<BooksResponse> allBook();

    @GET("book/")
    Call<BookResponse> detailBook(@Query("id") int id);

    @POST("signin/")
    Call<AuthResponse> signin(@Query("username") String username, @Query("password") String password, @Query("remember") boolean remember);

    @POST("signup/")
    Call<AuthResponse> signup(@Query("username") String username, @Query("email") String email, @Query("password") String password, @Query("name") String name, @Query("birthday") String birthday, @Query("gender") String gender);

}