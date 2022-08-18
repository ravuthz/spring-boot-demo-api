package com.springboot.demo;

import com.springboot.demo.models.PostModel;
import com.springboot.demo.repostories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application started");
//		testDummyData();
    }

    public void testDummyData() {
        postRepository.deleteAll();

        PostModel post1 = new PostModel("cate1", "post 1");
        PostModel post2 = new PostModel("cate1", "post 2");
        PostModel post3 = new PostModel("cate1", "post 3");
        PostModel post4 = new PostModel("cate1", "post 4");

        List<PostModel> posts = Arrays.asList(post1, post2, post3, post4);
        postRepository.saveAll(posts);

        System.out.println("Created posts " + posts.size());

        post2.setCategory("cate2");
        postRepository.save(post2);

        postRepository.delete(post4);

        System.out.println(posts);
    }
}
