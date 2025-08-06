package com.himanshu.Firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);


    boolean createReview(Long companyId, Review review);

    Review getReview(Long companyId, Long reviewId);

    boolean updatereview(Long companyId, Long reviewId,Review review);

    boolean deleteReview(Long companyId, Long reviewId);

}
