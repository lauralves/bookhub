package com.br.bookhub.application.core.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "reader")
@ToString
@EqualsAndHashCode
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reader_sequence")
    @SequenceGenerator(name = "reader_sequence", sequenceName = "reader_sequence", allocationSize = 1)
    @Column(name = "sq_reader", nullable = false, updatable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "name")
    @NotNull
    private String name;

    @NotBlank
    @Column(name = "cpf")
    @NotNull
    private String cpf;

    @NotBlank
    @Column(name = "birth_date")
    @NotNull
    private LocalDate birthDate;

    @NotBlank
    @Column(name = "email")
    @NotNull
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;
}
