package com.chenjinguyen.bookcommunity.service;

import com.chenjinguyen.bookcommunity.model.Response.AuthResponse;
import com.chenjinguyen.bookcommunity.model.Response.BookResponse;
import com.chenjinguyen.bookcommunity.model.Response.BooksResponse;
import com.chenjinguyen.bookcommunity.model.Response.EpisodeReponse;
import com.chenjinguyen.bookcommunity.model.Response.EpisodesReponse;
import com.chenjinguyen.bookcommunity.model.Response.PointResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BookCommunityService {
    @GET("book/")
    Call<BooksResponse> allBook();

    @GET("book/")
    Call<BookResponse> detailBook(@Query("id") int id);

    @POST("signin/")
    @FormUrlEncoded
    Call<AuthResponse> signin(@Field("username") String username, @Field("password") String password, @Field("remember") boolean remember);

    @POST("signup/")
    @FormUrlEncoded
    Call<AuthResponse> signup(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("name") String name, @Field("birthday") String birthday, @Field("gender") String gender);

    @GET("me/")
    Call<AuthResponse> me(@Header("Authorization") String bearer);

    @GET("me/book/")
    Call<BooksResponse> meBook(@Header("Authorization") String bearer);

    @GET("me/point")
    Call<PointResponse> mePoint(@Header("Authorization") String bearer);

    @POST("me/point/create")
    @FormUrlEncoded
    Call<PointResponse> mePointCreate(@Header("Authorization") String bearer, @Field("idepisode") int idepisode, @Field("charge") boolean charge, @Field("point") int point);

    @GET("book/search")
    Call<BooksResponse> searchBook(@Query("title")String keyword);

    @GET("book/{book}/episode")
    Call<EpisodesReponse> getEpisodeOfBook(@Path("book") int id);

    @GET("episode/{episode}")
    Call<EpisodeReponse> getEpisode(@Path("episode") int id);

    @GET("book/category/{category}")
    Call<BooksResponse> getBookCategory(@Path("category") String category);

    @POST("me/update/name")
    @FormUrlEncoded
    Call<AuthResponse> upDateName(@Header("Authorization") String bearer, @Field("name") String name);

}