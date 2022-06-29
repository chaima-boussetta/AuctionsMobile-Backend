package com.example.demo.Repository;

import com.example.demo.Model.FileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDbRepository extends JpaRepository<FileDb, String>{

    Optional<FileDb> findById(String id);
}
