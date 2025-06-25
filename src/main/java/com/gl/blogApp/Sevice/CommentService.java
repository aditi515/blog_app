package com.gl.blogApp.Sevice;

import com.gl.blogApp.payload.CommentDto;

import java.util.List;

public interface CommentService {
//    create
    CommentDto createComment(long postId, CommentDto commentDto);
//    get
    List<CommentDto> getCommentsByPostId(long postId);
    CommentDto getCommentById(long postId, long commentId);
//    update
    CommentDto updateComment(long postId, long commentId, CommentDto commentRequest);
//    delete
    void deleteComment(long postId, long commentId);
}
