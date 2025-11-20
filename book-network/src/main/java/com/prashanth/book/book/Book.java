package com.prashanth.book.book;

import com.prashanth.book.common.BaseEntity;
import com.prashanth.book.feedback.Feedback;
import com.prashanth.book.history.BookTransactionHistory;
import com.prashanth.book.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends BaseEntity {

    String title;
    String authorName;
    String isbn;
    String synopsis;
    String bookCover;
    boolean archived;
    boolean shareable;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    User owner;
    @OneToMany(mappedBy = "book")
    List<Feedback> feedbacks;
    @OneToMany(mappedBy = "book")
    List<BookTransactionHistory> histories;

    @Transient
    public double getRate() {

        if(feedbacks == null || feedbacks.isEmpty()) {
            return 0.0;
        }
        var rate = this.feedbacks.stream()
                .mapToDouble(Feedback::getNote)
                .average()
                .orElse(0.0);
        double roundedRate = Math.round(rate * 10.0) / 10.0;
        return roundedRate;

    }

}
