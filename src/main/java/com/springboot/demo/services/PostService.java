package com.springboot.demo.services;

import com.springboot.demo.dto.PostRequest;
import com.springboot.demo.models.PostModel;

import java.util.List;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 4:11 PM
 */

public interface PostService {
    List<PostModel> listItem();

    PostModel showItem(Long id);

    PostModel saveItem(PostRequest data, Long id);

    boolean deleteItem(Long id);
}
