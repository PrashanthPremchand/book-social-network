package com.prashanth.book.feedback;

import com.prashanth.book.book.Book;
import com.prashanth.book.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class FeedbackMapper {

    public Feedback toFeedback(FeedbackRequest request, User user, Book book) {

        return Feedback.builder()
                .note(request.note())
                .comment(request.comment())
                .book(book)
                .user(user)
                .build();

    }

    public FeedbackResponse toFeedbackResponse(Feedback feedback, Integer userId) {

        return FeedbackResponse.builder()
                .note(feedback.getNote())
                .comment(feedback.getComment())
                .ownFeedback(Objects.equals(feedback.getCreatedBy(), userId))
                .build();

    }
}
