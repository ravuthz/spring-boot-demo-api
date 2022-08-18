package com.springboot.demo.repostories;

import com.springboot.demo.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 3:39 PM
 */

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
    //
}
