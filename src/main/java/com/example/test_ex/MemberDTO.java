package com.example.test_ex;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDTO {
    private Long member_id;
    private String member_email;
    private String member_password;
    private String member_name;
}
