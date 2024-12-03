package com.mindSpring.domain.openAi.entity;

import com.mindSpring.domain.worry.entity.Worry;
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
public class OpenAi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aiAnswer;

    @OneToOne
    @JoinColumn(name = "worry_id")
    private Worry worry;
}
