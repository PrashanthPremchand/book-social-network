package com.prashanth.book.feedback;

import com.prashanth.book.book.Book;
import com.prashanth.book.common.BaseEntity;
import com.prashanth.book.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Feedback extends BaseEntity {

    @NotNull
    @Min(1)
    @Max(5)
    @Column(nullable = false)
    Double note;

    @Column(length = 1000)
    String comment;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    Book book;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;
}

