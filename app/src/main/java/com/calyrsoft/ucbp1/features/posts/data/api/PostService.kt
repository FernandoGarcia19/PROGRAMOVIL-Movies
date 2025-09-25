package com.calyrsoft.ucbp1.features.posts.data.api

import com.calyrsoft.ucbp1.features.posts.data.api.dto.PostDto
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface PostService {
    @GET("/posts")
    fun getPosts(): List<PostDto>

    @GET("/posts/{id}")
    fun getPostById(@Path("id") id: Int): PostDto

    @POST("/posts")
    fun createPost(post: PostDto): PostDto

    @DELETE("/posts/{id}")
    fun deletePost(@Path("id") id: Int)



}