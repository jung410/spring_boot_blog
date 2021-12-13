package com.min0.blog.repository;

import com.min0.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// DAO
// 자동으로 bean등록
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
