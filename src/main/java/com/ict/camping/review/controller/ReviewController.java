package com.ict.camping.review.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ict.camping.review.service.ReviewService;
import com.ict.camping.review.vo.ReviewVO;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = "http://localhost:3000")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/list")
    public List<ReviewVO> getReviewList(@PathVariable String contentId) {
        List<ReviewVO> reviewList = reviewService.getReviewList(contentId);
        return reviewList;
    }
    
    @PostMapping("/write")
    public ReviewVO getReviewWrite(
            @ModelAttribute("data") ReviewVO rvo
            ) {

        ReviewVO reviewVO = new ReviewVO();
        try {
            
            MultipartFile file = rvo.getFile();
            if (file.isEmpty()) {
                rvo.setFilename("");
            } else {
                UUID uuid = UUID.randomUUID();
                String f_name = uuid.toString() + "_" + file.getOriginalFilename();
                rvo.setFilename(f_name);

                // 프로젝트 내부의 resources/static/upload 경로
                String path = new File("src/main/resources/static/upload").getAbsolutePath();
                // 실직적인 파일업로드
                file.transferTo(new File(path, f_name));
            }

            // 게스트북 쓰기
            int result = reviewService.getReviewWrite(rvo);
            

        } catch (Exception e) {
            log.info("Exception : " + e);
        }
        return reviewVO;
    }
}
 