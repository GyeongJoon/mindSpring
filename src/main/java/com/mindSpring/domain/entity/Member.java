package com.mindSpring.domain.entity;

import com.mindSpring.domain.dto.SignupRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Worry> worries = new ArrayList<>();

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    // update 메서드
    public void updateMemberInfo(SignupRequestDto signupRequestDto) {
        if (signupRequestDto.getName() != null) {
            this.name = signupRequestDto.getName();
        }
        if (signupRequestDto.getEmail() != null) {
            this.email = signupRequestDto.getEmail();
        }
        if (signupRequestDto.getPhone() != null) {
            this.phone = signupRequestDto.getPhone();
        }
        if (signupRequestDto.getGender() != null) {
            this.gender = signupRequestDto.getGender();
        }
        if (signupRequestDto.getAge() != 0) {
            this.age = signupRequestDto.getAge();
        }
    }
}
