package com.webpet_nhom20.backdend.dto.response.Pet;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.webpet_nhom20.backdend.dto.response.PetImage.PetImageResponse;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminPetResponse {
    private Integer id;
    private Integer userId;
    private String name;
    private String animal;
    private String breed;
    private Float age;
    private String ageGroup;
    private Float weight;
    private String gender;
    private String description;
    private String healthStatus;
    private String vaccinated;
    private String neutered;
    private String status;
    private String isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updatedDate;

    private List<PetImageResponse> images;
    private PetOwnerResponse owner;
}
