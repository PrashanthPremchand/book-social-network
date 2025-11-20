package com.prashanth.book.book;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    Integer id;
    String title;
    String authorName;
    String isbn;
    String synopsis;
    String owner;
    byte[] cover;
    double rate;
    boolean archived;
    boolean sharable;
}
