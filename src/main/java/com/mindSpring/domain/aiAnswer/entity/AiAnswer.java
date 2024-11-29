package com.mindSpring.domain.aiAnswer.entity;

import com.mindSpring.domain.worry.entity.Worry;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AiAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000)
    private String response;

    @OneToOne
    @JoinColumn(name = "worry_id")
    private Worry worry;

    public AiAnswer(Worry worry, String response) {
        this.worry = worry;
        this.response = response;
    }
}