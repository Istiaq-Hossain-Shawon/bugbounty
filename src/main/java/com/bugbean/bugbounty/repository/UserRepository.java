package com.bugbean.bugbounty.repository;

import com.bugbean.bugbounty.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    List<User> findAllByActiveIsTrue();

    @Query(value = "select *" +
            " from tbl_user u" +
            " where u.username like %:keyword% ", nativeQuery = true)
    List<User> getUsersByQueryString(@Param("keyword") String query);

}