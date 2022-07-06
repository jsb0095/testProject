package com.example.test_ex;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "member_test_table")
public class MemberEntity {
    @Id
    @Column(name = "member_id")
    private Long member_id;
    @Column(name = "member_email",unique = true,length = 30)
    private String member_email;
    @Column(name = "member_password", length = 50,nullable = false)
    private String member_password;
    @Column(name = "member_name",length = 20)
    private String member_name;
    @OneToMany(mappedBy = "memberEntity",cascade = CascadeType.REMOVE,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntityList =new ArrayList<>();
}
