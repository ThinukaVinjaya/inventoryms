package com.thinuka.inventoryms.security.models;

import com.thinuka.inventoryms.models.User;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Bean;

@Entity
@Data
public class UserPrivilegeAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "userid", insertable = false, updatable = false)
    private User user;
    private Long userid;

    @ManyToOne
    @JoinColumn(name = "privilegeid", insertable = false, updatable = false)
    private Privilege privilege;
    private Long privilegeid;



    public UserPrivilegeAssignment(Long userid, Long privilegeid) {
        this.userid = userid;
        this.privilegeid = privilegeid;
    }
}
