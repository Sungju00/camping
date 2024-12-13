package com.ict.camping.review.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.camping.review.mapper.ReviewMapper;
import com.ict.camping.review.vo.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewMapper reviewMapper;
    

    @Override
    public List<ReviewVO> getReviewList(String contentId) {
        return reviewMapper.getReviewList(contentId);
    }

    // @Override
    // public ReviewVO getReviewById(String review_idx) {
    //     return reviewMapper.getReviewById(review_idx);
    // }

    // @Override
    // public int getReviewUpdate(ReviewVO rvo) {
    //     return reviewMapper.getReviewUpdate(rvo);
    // }

    // @Override
    // public int getReviewDelete(String review_idx) {
    //     return reviewMapper.getReviewDelete(review_idx);
    // }
    @Override
    public int getReviewWrite(ReviewVO rvo) {
        return reviewMapper.getReviewWrite(rvo);
    }

}
