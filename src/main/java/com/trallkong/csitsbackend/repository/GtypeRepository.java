package com.trallkong.csitsbackend.repository;

import com.trallkong.csitsbackend.entity.Gtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GtypeRepository extends JpaRepository<Gtype, Short> {
    Gtype findByTypeName(String typeName);
}
