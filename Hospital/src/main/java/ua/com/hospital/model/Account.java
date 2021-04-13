package ua.com.hospital.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Account {
    private Long id;
    private String login;
    private String password;
    private String email;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private boolean locked;
    private Role role;
    private Account updatedBy;
}
