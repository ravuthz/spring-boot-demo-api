package com.springboot.demo.controllers;

import com.springboot.demo.dto.PostRequest;
import com.springboot.demo.dto.PostResponse;
import com.springboot.demo.models.PostModel;
import com.springboot.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 3:23 PM
 */

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostModel> getListOfPost() {
        return postService.listItem();
    }

    @GetMapping("/{id}")
    public PostResponse getSinglePost(@PathVariable String id) {
        PostModel postModel = postService.showItem(Long.valueOf(id));
        return new PostResponse(postModel.getCategory(), postModel.getTitle());
    }

    @PostMapping
    public PostModel createPost(@RequestBody PostRequest data) {
        return postService.saveItem(data, null);
    }

    @PutMapping("/{id}")
    public PostModel updatePost(@RequestBody PostRequest data, @PathVariable String id) {
        return postService.saveItem(data, Long.valueOf(id));
    }

    @DeleteMapping("/posts/{id}")
    public boolean deletePost(@PathVariable String id) {
        return postService.deleteItem(Long.valueOf(id));
    }

}
