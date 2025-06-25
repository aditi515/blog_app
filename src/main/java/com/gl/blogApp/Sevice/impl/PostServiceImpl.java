package com.gl.blogApp.Sevice.impl;

import com.gl.blogApp.Sevice.PostService;
import com.gl.blogApp.entity.Post;
import com.gl.blogApp.exception.ResourceNotFoundException;
import com.gl.blogApp.payload.PostDto;
import com.gl.blogApp.payload.PostResponse;
import com.gl.blogApp.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private ModelMapper mapper;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public PostDto createPost(PostDto postDto) {

//        convert dto to entity
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);

//        convert entity to dto
        PostDto postResponse = mapToDto(newPost);
        return postResponse;
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        //create pageable instance
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Post> posts = postRepository.findAll(pageable);

        //get content for page object
        List<Post> plistOfPosts = posts.getContent();
        List<PostDto> content = plistOfPosts.stream().map(this::mapToDto).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());

        return postResponse;

//old code
//        List<Post> posts = postRepository.findAll();
//        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));

        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePost(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("post", "id", id));
        postRepository.delete(post);

    }

    //    convert dto to entity
    private Post mapToEntity(PostDto postDto) {
        Post post = mapper.map(postDto,Post.class);
//        post.setId(postDto.getId());
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setContent(postDto.getContent());
        return post;
    }

    //convert entity to dto
    private PostDto mapToDto(Post post) {
        PostDto postDto = mapper.map(post,PostDto.class);

//        postDto.setId(post.getId());
//        postDto.setTitle(post.getTitle());
//        postDto.setDescription(post.getDescription());
//        postDto.setContent(post.getContent());

        // Map only comment body strings
//        if (post.getComments() != null) {
//            List<String> commentBodies = post.getComments()
//                    .stream()
//                    .map(comment -> comment.getBody()) // only body
//                    .collect(Collectors.toList());
//
//            postDto.setComments(commentBodies);
//        }
            return postDto;
        }
    }
