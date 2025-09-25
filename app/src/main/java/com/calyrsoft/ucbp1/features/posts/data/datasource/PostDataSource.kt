package com.calyrsoft.ucbp1.features.posts.data.datasource

import com.calyrsoft.ucbp1.features.posts.data.api.PostService
import com.calyrsoft.ucbp1.features.posts.data.api.dto.PostDto

class PostDataSource(
    val postService: PostService
) {
    suspend fun getPosts(): Result<List<PostDto>> {
        return try {
            val response = postService.getPosts()
            return Result.success(response)
        } catch(e: Exception) {
            Result.failure(e)
        }
    }
    suspend fun getPostById(id: Int): Result<PostDto> {
        return try {
            val response = postService.getPostById(id)
            return Result.success(response)
        } catch(e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun createPost(post: PostDto): Result<PostDto> {
        return try {
            val response = postService.createPost(post)
            return Result.success(response)
        } catch(e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun deletePost(id: Int): Result<Unit> {
        return try {
            postService.deletePost(id)
            return Result.success(Unit)
        } catch(e: Exception) {
            Result.failure(e)
        }

    }
}