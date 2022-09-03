package com.heyso.Palette.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class MemberTemp {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userGenKey;

    @Column(name = "USER_ID")
    String userId;

    @Column(name = "PASSWD")
    String password;

    @Column(name = "USER_NM")
    String userName;

    @Column(name = "USE_YN")
    boolean useYN;

    @Column(name = "CERT_YN")
    boolean CertificateYN;

    @Column(name = "CREATE_DT")
    Date createDate;

    @Column(name = "UPDATE_DT")
    Date updateDate;
}
