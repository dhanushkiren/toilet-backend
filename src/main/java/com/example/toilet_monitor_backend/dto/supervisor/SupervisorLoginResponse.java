// dto/supervisor/SupervisorLoginResponse.java
package com.example.toilet_monitor_backend.dto.supervisor;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupervisorLoginResponse {
    private Long id;
    private String username;
    private String fullName;
    private String phone;
    private String email;
    private String message;
}
