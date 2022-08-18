package com.springboot.demo.services;

import com.springboot.demo.dto.PostRequest;
import com.springboot.demo.models.PostModel;
import com.springboot.demo.repostories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 4:14 PM
 */

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    @Autowired
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PostModel> listItem() {
        return repository.findAll();
    }

    @Override
    public PostModel showItem(Long id) {
        Optional<PostModel> post = repository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        throw new EntityNotFoundException("No post id " + id);
    }

    @Override
    public PostModel saveItem(PostRequest data, Long id) {
        PostModel post;
        if (id != null) {
            post = showItem(id);
            post.setCategory(data.getCategory());
            post.setTitle(data.getTitle());
        } else {
            post = new PostModel(data.getCategory(), data.getTitle());
        }
        repository.save(post);
        return post;
    }

    @Override
    public boolean deleteItem(Long id) {
        PostModel post = showItem(id);
        repository.delete(post);
        return true;
    }
}
