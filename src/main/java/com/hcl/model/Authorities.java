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
    @Column(name = "user_id")
    Long id;
    String authority;

}
