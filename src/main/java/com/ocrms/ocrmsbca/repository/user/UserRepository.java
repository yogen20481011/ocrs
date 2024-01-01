package com.ocrms.ocrmsbca.repository.user;

import com.ocrms.ocrmsbca.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByEmail(String email);
    @Query(value = "select id from tbl_user",nativeQuery = true)
    public Long getId();
}
