package com.prashanth.book.role;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prashanth.book.user.User;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue
    Integer id;
    @Column(unique = true)
    String name;
    @CreatedDate
    @Column(nullable = false, updatable = false)
    LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    LocalDateTime lastModifiedDate;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    List<User> users;

}
