package com.example.demo.repository;

import com.example.demo.model.todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataInt extends JpaRepository<todo,Long> {
}
