package org.shop.coursesservices.entities.enrollment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name="enrollment")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enrollment {

    @Id
    @GeneratedValue(generator="UUID")
    private UUID id;
}
