package com.datang.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nba_role")
public class NBARole implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "authority")
    private String authority;

    public NBARole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "NBARole{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                '}';
    }
}
