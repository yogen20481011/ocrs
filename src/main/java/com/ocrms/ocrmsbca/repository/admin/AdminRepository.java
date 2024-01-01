package com.ocrms.ocrmsbca.repository.admin;

import com.ocrms.ocrmsbca.entity.admin.Admin;
import com.ocrms.ocrmsbca.entity.complain.Complain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
    public Admin findAdminRegisterByEmail(String email);

    @Query(value = "select tu.name,tu.contact,tc.crime_date,tc.complain_date,tc.address,tc.crime_type,tc.description,tc.complain_status from tbl_complain tc inner join  tbl_user tu  on tc.user_id = tu.id",nativeQuery = true)
    List<Object> getComplain();

}
