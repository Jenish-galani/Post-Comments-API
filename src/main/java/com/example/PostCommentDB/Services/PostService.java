package com.example.PostCommentDB.Services;

import com.example.PostCommentDB.Models.Post;
import com.example.PostCommentDB.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    public Post createPostWithComments(Post post) {
        post.getComments().forEach(comment -> comment.setPost(post));
        return postRepository.save(post); // Save Post and Comments (cascaded)
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

