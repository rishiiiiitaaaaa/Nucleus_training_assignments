package com.example.hrPortal.repository;


import com.example.hrPortal.model.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HrRepository extends JpaRepository<Hr, Integer> {
    Optional<Hr> findByHrUsername(String hrUsername);
}