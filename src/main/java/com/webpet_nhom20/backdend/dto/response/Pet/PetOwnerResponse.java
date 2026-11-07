package com.webpet_nhom20.backdend.dto.response.Pet;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetOwnerResponse {
    private Integer id;
    private String fullName;
    private String email;
    private String phone;
}
