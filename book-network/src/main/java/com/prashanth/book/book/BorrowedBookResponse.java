package com.prashanth.book.book;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BorrowedBookResponse {
    Integer id;
    String title;
    String authorName;
    String isbn;
    double rate;
    boolean returned;
    boolean returnApproved;
}
