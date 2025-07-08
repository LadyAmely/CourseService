package org.shop.coursesservices.entities.lesson;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name="lesson",
        indexes={
                @Index(name="idx_lesson", columnList = "id"),
                @Index(name="idx_title", columnList = "title")
        }
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name="title", nullable=false, length=100)
    private String title;

    @Column(name="description", nullable = false, length=256)
    private String desc;

    @CreationTimestamp
    @Column(name="created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
