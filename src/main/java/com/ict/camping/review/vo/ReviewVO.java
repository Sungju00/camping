package com.ict.camping.review.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewVO {
    private String contentId, rating, created_at;
    private String user_idx, title ,content, filename;
    private MultipartFile file;
}
