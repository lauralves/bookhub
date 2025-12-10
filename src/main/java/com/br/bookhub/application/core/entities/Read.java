package com.br.bookhub.application.core.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "read")
@ToString
@EqualsAndHashCode
public class Read {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "read_sequence")
    @SequenceGenerator(name = "read_sequence", sequenceName = "read_sequence", allocationSize = 1)
    @Column(name = "sq_read", nullable = false, updatable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @NotBlank
    @Column(name = "pages_read")
    private Integer pagesRead;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedBy
    private String updatedBy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sq_reader")
    private Reader reader;

    public void update(Read read) {
        this.startDate = read.getStartDate();
        this.endDate = read.getEndDate();
        this.updatedAt = read.getUpdatedAt();
        this.pagesRead = read.getPagesRead();
    }
}
