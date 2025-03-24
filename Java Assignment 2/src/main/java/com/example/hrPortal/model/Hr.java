package com.example.hrPortal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hr")
public class Hr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hr_id")
    private Integer hrId;

    @Column(name = "hr_username", nullable = false, unique = true)
    private String hrUsername;

    @Column(name = "hr_password", nullable = false)
    private String hrPassword;

    // Constructors
    public Hr() {}

    public Hr(String hrUsername, String hrPassword) {
        this.hrUsername = hrUsername;
        this.hrPassword = hrPassword;
    }

    // Getters and Setters
    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getHrUsername() {
        return hrUsername;
    }

    public void setHrUsername(String hrUsername) {
        this.hrUsername = hrUsername;
    }

    public String getHrPassword() {
        return hrPassword;
    }

    public void setHrPassword(String hrPassword) {
        this.hrPassword = hrPassword;
    }
}