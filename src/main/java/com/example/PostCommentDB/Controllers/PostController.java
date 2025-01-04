package com.example.PostCommentDB.Controllers;

import com.example.PostCommentDB.Models.Comment;
import com.example.PostCommentDB.Models.Post;
import com.example.PostCommentDB.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable Long id) {

        return postService.getPostById(id);
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPostWithComments(post);
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "Post deleted successfully";
    }

    @PutMapping("id/{postId}")
    public String updatePost(@RequestBody Post post) {
        postService.createPostWithComments(post);
        return "Post updated successfully";
    }
}

