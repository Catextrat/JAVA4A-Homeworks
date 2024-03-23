package com.example.SpringHomework.repositories;

import com.example.SpringHomework.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category , Integer> {

}
