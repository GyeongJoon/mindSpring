package com.mindSpring.domain.worry.entity;

import com.mindSpring.domain.aiAnswer.entity.AiAnswer;
import com.mindSpring.domain.entity.BaseEntity;
import com.mindSpring.domain.category.entity.Category;
import com.mindSpring.domain.member.entity.Member;
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
public class Worry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private String openAiAnswer;

    @OneToOne(mappedBy = "worry")
    private AiAnswer aiAnswer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
