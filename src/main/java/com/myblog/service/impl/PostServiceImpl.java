package com.myblog.service.impl;

import com.myblog.entities.Post;
import com.myblog.payload.PostDto;
import com.myblog.repository.PostRepository;
import com.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    public PostServiceImpl(PostRepository postRepo){

        this.postRepo = postRepo;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        Post p = new Post();
        p.setTitle(postDto.getTitle());
        p.setDescription(postDto.getDescription());
        p.setContent(postDto.getContent());

        Post postEntity = postRepo.save(p);

        PostDto dto = new PostDto();

        dto.setId(postEntity.getId());
        dto.setTitle(postEntity.getTitle());
        dto.setDescription(postEntity.getDescription());
        dto.setContent(postEntity.getContent());

        return dto;
    }
}
