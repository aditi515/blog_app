package com.gl.blogApp.Sevice;

import com.gl.blogApp.payload.PostDto;
import com.gl.blogApp.payload.PostResponse;


import java.util.List;

public interface  PostService {
    PostDto createPost(PostDto postDto);
//    PostResponse getAllPosts();
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePost(long id);

}
