package com.trallkong.csitsbackend.repository;

import com.trallkong.csitsbackend.entity.Gstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GstateRepository extends JpaRepository<Gstate, Long> {
}
