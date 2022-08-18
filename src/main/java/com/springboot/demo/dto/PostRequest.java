package com.springboot.demo.dto;

import lombok.*;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 4:20 PM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private String category;
    private String title;
}
