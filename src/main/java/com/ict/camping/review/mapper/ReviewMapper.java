package com.ict.camping.review.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ict.camping.review.vo.ReviewVO;

@Mapper
public interface ReviewMapper {
    @Select("SELECT * FROM review WHERE contentId = #{contentId}")
    List<ReviewVO> getReviewList(String contentId);

    //ReviewVO getReviewById(String review_idx);

    //int getReviewUpdate(ReviewVO rvo);

    //int getReviewDelete(String review_idx);

    int getReviewWrite(ReviewVO rvo);
}
