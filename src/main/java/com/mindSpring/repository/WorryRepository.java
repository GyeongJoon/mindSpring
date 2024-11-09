package com.mindSpring.repository;

import com.mindSpring.domain.entity.Worry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorryRepository extends JpaRepository<Worry, Long> {
}
