package com.springboot.demo.services;

import com.springboot.demo.dto.PostRequest;
import com.springboot.demo.models.PostModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 4:35 PM
 */

@SpringBootTest
class PostServiceImplTest {

    @Autowired
    private PostService service;

    @Test
    void listItem() {
        List<PostModel> postList = service.listItem();
        assertNotNull(postList);
    }

    @Test
    void showItem() {
        assertThrows(EntityNotFoundException.class, () -> {
            PostModel postModel = service.showItem(400L);
        });
    }

    @Test
    void saveItem() {
        PostModel postModel = service.saveItem(new PostRequest("cate3", "create"), null);
        assertNotNull(postModel);
    }

    @Test
    void deleteItem() {
        boolean deleted = service.deleteItem(30L);
        assertTrue(deleted);
    }
}