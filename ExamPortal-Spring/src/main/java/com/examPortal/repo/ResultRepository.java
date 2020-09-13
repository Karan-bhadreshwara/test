package com.examPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.entity.Result;

public interface ResultRepository extends JpaRepository<Result, Integer> {

	List<Result> findAllByUserId(Integer userId);

}
