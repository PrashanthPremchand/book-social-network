package com.prashanth.book.common;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PageResponse<T> {
    List<T> content;
    int number;
    int size;
    long totalElement;
    int totalPages;
    boolean first;
    boolean last;
}
