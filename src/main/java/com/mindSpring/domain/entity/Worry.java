package com.mindSpring.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Worry extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @OneToOne(mappedBy = "worry")
    private AIAnswar aiAnswar;

    @OneToOne(mappedBy = "worry")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
