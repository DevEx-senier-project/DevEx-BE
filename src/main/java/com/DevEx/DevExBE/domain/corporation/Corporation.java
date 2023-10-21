package com.DevEx.DevExBE.domain.corporation;

import com.DevEx.DevExBE.domain.handcarry.Handcarry;
import com.DevEx.DevExBE.domain.users.Users;
import com.DevEx.DevExBE.global.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Corporation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "corp_name")
    private String corpName;

    @Column(name = "tell")
    private String tell;

    @Column(name = "email")
    private String email;

    @JsonManagedReference
    @OneToMany
    private List<Handcarry> handcarryList = new ArrayList<>();

    @JsonManagedReference
    @OneToMany
    private List<Users> userList = new ArrayList<>();

}
