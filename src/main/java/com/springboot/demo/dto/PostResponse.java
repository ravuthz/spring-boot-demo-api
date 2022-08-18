package com.springboot.demo.dto;

import lombok.*;

/**
 * @author Vannaravuth YO
 * @since 18-Aug-22, 4:59 PM
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostResponse {
    private String category;
    private String title;
}
