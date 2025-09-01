package com.himanshu.Firstjobapp.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> GetAllReviews(@PathVariable Long companyId){
        List<Review> reviews= reviewService.getAllReviews(companyId);
        if(reviews!=null){
            return  new ResponseEntity<>(reviews , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/reviews")
    public ResponseEntity<String>CreateReview(@PathVariable Long companyId,@RequestBody Review review){
        boolean isReviewSaved=  reviewService.createReview(companyId,review);
        if(isReviewSaved) {
            return new ResponseEntity<>("Review added Successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Review not addes", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review>getReviewById(@PathVariable Long companyId,@PathVariable
    Long reviewId){
        Review review=  reviewService.getReview(companyId,reviewId);
        return new ResponseEntity<>(review,HttpStatus.OK);
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String>UpdateReview(@PathVariable Long companyId,@PathVariable Long reviewId,@RequestBody Review review){
        boolean reviewupdate=  reviewService.updatereview(companyId,reviewId,review);
        if(reviewupdate) {
            return new ResponseEntity<>("update Revirew successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Review not update", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String>DeleteReview(@PathVariable Long companyId,@PathVariable Long reviewId){
        boolean deleteReview=reviewService.deleteReview(companyId,reviewId);
        if(deleteReview) {
            return new ResponseEntity<>("Delete the Review successfully", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Not delete Review", HttpStatus.NOT_FOUND);
        }
    }

}
