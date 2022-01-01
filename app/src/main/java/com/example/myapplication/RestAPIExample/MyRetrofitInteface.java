package com.example.myapplication.RestAPIExample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface MyRetrofitInteface {
    @GET("posts")
    Call<List<MyRestAPIModel>> getList();
    //@GET("posts/1/comments")
    //Call<List<MyCommentsModel>> getComments();
//    @GET("posts/{id}/comments")
//    Call<List<MyCommentsModel>> getComments(@Path("id") int id);

//    @GET("comments")
//    Call<List<MyCommentsModel>> getComments(@Query("postId")int id,
//                                            @Query("_sort") String s,
//                                            @Query("_order")String sort);

    @POST("post")
    Call<MyRestAPIModel> createPost(@Body MyRestAPIModel post);
}
