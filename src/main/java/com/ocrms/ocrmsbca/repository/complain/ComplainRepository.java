package com.ocrms.ocrmsbca.repository.complain;

import com.ocrms.ocrmsbca.entity.complain.Complain;
import com.ocrms.ocrmsbca.entity.user.User;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ComplainRepository extends JpaRepository<Complain,Long> {
    @Query("FROM Complain as c WHERE c.user.id=:userId")
    public Page<Complain> getComplainList(@Param("userId") Long userId, Pageable pageable);

    @Query( value = "select * from tbl_complain order by id",nativeQuery = true)
    public Page<Complain> getTotalComplain(Pageable pageable);

    @Modifying(flushAutomatically = true)
    @Query("update Complain set complainStatus=1 where id=:userId")
    public void updateComplainStatus(@Param("userId") Long userId);

   /* @Transactional
    @Modifying
    @Query("update Complain set complainStatus=1 where id=:compalinId")
    void setApproveStatus(@Param("complainId") Long complainId);*/


    @Query(value = "SELECT * FROM user_complain u WHERE u.register_id=?1 and u.complain_status=1",nativeQuery = true)
    List<Complain> getVerifiedStatus(Integer userId);

    @Query(value = "select count(uc.complain_status) from user_complain uc",nativeQuery = true)
    int getTotalComplain();

    @Query(value = "select count(uc.complain_status)from user_complain uc where uc.complain_status= 0",nativeQuery = true)
    String getPendingComplain();

    @Query(value = "select count(uc.complain_status)from user_complain uc where uc.complain_status=1",nativeQuery = true)
    String getApproveComplain();

    @Query(value = "select * from tbl_complain u  order by u.id",nativeQuery = true)
    List<Complain> getComplainDetails();

    @Query(value = "select tc.user from tbl_user tc where id=tc.id",nativeQuery = true)
    List<Complain>getUser(Integer userId);

}
