package com.ocrms.ocrmsbca.repository.role;

import com.ocrms.ocrmsbca.entity.role.Role;
import com.ocrms.ocrmsbca.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("select r from Role r where r.email=:email")
    public Role getRoleByRoleName(@Param("email") String email);


    public Role findUserByEmail(String email);
    @Query(value = "SELECT * FROM roles r WHERE r.id=?1 and r.role = 1", nativeQuery = true)
    List<User> userList(Integer userId);
}
