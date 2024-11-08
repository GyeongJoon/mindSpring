package com.mindSpring.domain.entity;

import com.mindSpring.domain.dto.MemberRequestDto;
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
    public void updateMemberInfo(MemberRequestDto memberRequestDto) {
        if (memberRequestDto.getName() != null) {
            this.name = memberRequestDto.getName();
        }
        if (memberRequestDto.getEmail() != null) {
            this.email = memberRequestDto.getEmail();
        }
        if (memberRequestDto.getPhone() != null) {
            this.phone = memberRequestDto.getPhone();
        }
        if (memberRequestDto.getGender() != null) {
            this.gender = memberRequestDto.getGender();
        }
        if (memberRequestDto.getAge() != 0) {
            this.age = memberRequestDto.getAge();
        }
    }
}
