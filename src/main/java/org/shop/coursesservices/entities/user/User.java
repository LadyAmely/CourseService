package org.shop.coursesservices.entities.user;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name="user",
        indexes = {
                @Index(name="idx_username", columnList = "username"),
                @Index(name="idx_email", columnList = "email")
        }
)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @JdbcTypeCode(SqlTypes.UUID)
    @EqualsAndHashCode.Include
    private UUID id;

    @NotBlank
    @Size(max=50)
    @Column(name="username", nullable=false, unique=true, length=50)
    private String username;

    @NotBlank
    @Email
    @Size(max=100)
    @Column(name="email", nullable=false, unique=true, length=100)
    private String email;

    @NotBlank
    @Pattern(regexp="\\d{10}")
    @Column(name="phone", nullable=false, unique=true, length=10)
    private String phone;

    @Size(max=45)
    @Column(name="last_login_ip", length=45)
    private String lastLoginIp;

    @Column(name="last_login_at")
    private LocalDateTime lastLoginAt;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRole role;

    @CreationTimestamp
    @Column(name="created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

}
