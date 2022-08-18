package com.springboot.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 3:33 PM
 */

@Setter
@Getter
@Entity
@NoArgsConstructor
@ToString
@Table(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String category;
    private String title;

    public PostModel(String category, String title) {
        this.category = category;
        this.title = title;
    }

}
