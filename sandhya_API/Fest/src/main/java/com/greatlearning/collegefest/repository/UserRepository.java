package com.greatlearning.collegefest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.greatlearning.collegefest.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select u from User u where u.username=?1")
	public User getUserByUsername(String username);

}
