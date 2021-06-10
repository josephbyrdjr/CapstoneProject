package com.hcl.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@Table(name="authorities")
@NoArgsConstructor
public class Authorities {
    @Id
    String username;
    String authority;

    public Authorities(String username) {
        this.username = username;
        this.authority = "ROLE_USER";
    }
}
