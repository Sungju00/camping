package com.ict.camping.review.service;

import java.util.List;

import com.ict.camping.review.vo.ReviewVO;

public interface ReviewService {
    List<ReviewVO> getReviewList(String contentId);

    //ReviewVO getReviewById(String review_idx);

    //int getReviewUpdate(ReviewVO rvo);

   // int getReviewDelete(String review_idx);

    int getReviewWrite(ReviewVO rvo);
}
