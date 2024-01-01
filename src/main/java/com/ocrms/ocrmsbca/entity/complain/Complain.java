package com.ocrms.ocrmsbca.entity.complain;

import com.ocrms.ocrmsbca.Enum.EComplainStatus;
import com.ocrms.ocrmsbca.Enum.ECrimeType;
import com.ocrms.ocrmsbca.entity.user.User;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="tbl_complain")
public class Complain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "crime_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private ECrimeType crime;

    @Column(name="crime_date" ,nullable = false)
    private Date crimeDate;

    @Column(name="complain_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date complainDate;

    @Column(name = "complain_status",nullable = false)
    private EComplainStatus complainStatus;

    @Column(name="description",nullable = false)
    private String description;

   /* @Column(name="crime_sample")
    private String photo;*/

    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "Fk_user_complaint"))
    private User user;

}
