package com.prashanth.book.feedback;

import com.prashanth.book.book.Book;
import com.prashanth.book.book.BookRepository;
import com.prashanth.book.exception.OperationNotPermittedException;
import com.prashanth.book.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.Authentication;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackServiceTest {

    @InjectMocks
    private FeedbackService feedbackService;
    @Mock
    private FeedbackRepository feedbackRepository;
    @Mock
    private BookRepository bookRepository;
    @Mock
    private FeedbackMapper feedbackMapper;
    @Mock
    private Authentication authentication;

    private Book testBook;
    private User testUser;

    @BeforeEach
    void setUp() {

        MockitoAnnotations.openMocks(this);

        testUser = User.builder()
                .id(1)
                .build();

        testBook = Book.builder()
                .id(10)
                .shareable(true)
                .archived(false)
                .owner(User.builder()
                        .id(2)
                        .build())
                .build();

    }

    @Test
    void saveFeedbackSuccess() {

        FeedbackRequest request = new FeedbackRequest(4.5, "Great book", 10);
        Feedback feedback = Feedback.builder()
                .id(100)
                .build();

        Mockito.when(authentication.getPrincipal()).thenReturn(testUser);
        Mockito.when(bookRepository.findById(10)).thenReturn(Optional.of(testBook));
        Mockito.when(feedbackMapper.toFeedback(request)).thenReturn(feedback);
        Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);

        Integer result = feedbackService.saveFeedback(request, authentication);

        Assertions.assertNotNull(result);
        Mockito.verify(feedbackRepository, Mockito.times(1)).save(feedback);

    }

    @Test
    void saveFeedback_ownerCannotGiveFeedback() {

        testBook.setOwner(testUser);
        FeedbackRequest request = new FeedbackRequest(4.0, "Nice book!", 10);

        Mockito.when(authentication.getPrincipal()).thenReturn(testUser);
        Mockito.when(bookRepository.findById(10)).thenReturn(java.util.Optional.of(testBook));

        Assertions.assertThrows(OperationNotPermittedException.class, () ->
                feedbackService.saveFeedback(request, authentication));

    }

    @Test
    void saveFeedback_cannotFeedbackArchivedBook() {

        testBook.setArchived(true);
        FeedbackRequest request = new FeedbackRequest(3.0, "Archived book", 10);

        Mockito.when(authentication.getPrincipal()).thenReturn(testUser);
        Mockito.when(bookRepository.findById(10)).thenReturn(java.util.Optional.of(testBook));

        assertThrows(OperationNotPermittedException.class, () ->
                feedbackService.saveFeedback(request, authentication));

    }

}