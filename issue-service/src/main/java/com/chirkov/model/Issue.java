package com.chirkov.model;

import com.chirkov.utils.customAbstract.models.CustomEntityInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "issues")
public class Issue implements CustomEntityInterface<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Long userId;
    private Long bookId;

    public Issue(String title, String description, Long userId, Long bookId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.bookId = bookId;
    }
}
