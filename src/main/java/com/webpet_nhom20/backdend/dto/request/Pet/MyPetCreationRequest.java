package com.webpet_nhom20.backdend.dto.request.Pet;

import com.webpet_nhom20.backdend.dto.request.PetImage.PetImageCreationDto;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyPetCreationRequest {

    @NotBlank(message = "Tên thú cưng không được để trống")
    @Size(max = 100, message = "Tên thú cưng tối đa 100 ký tự")
    private String name;

    @NotBlank(message = "Loại thú cưng không được để trống")
    @Size(max = 100, message = "Loại thú cưng tối đa 100 ký tự")
    private String animal; // Dog, Cat

    @Size(max = 100, message = "Giống loài tối đa 100 ký tự")
    private String breed;

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 0, message = "Tuổi phải >= 0")
    @Max(value = 50, message = "Tuổi không hợp lệ")
    private Float age;

    @Size(max = 100, message = "Nhóm tuổi tối đa 100 ký tự")
    private String ageGroup;

    @Min(value = 0, message = "Cân nặng phải lớn hơn hoặc bằng 0")
    private Float weight;

    @Size(max = 100, message = "Giới tính tối đa 100 ký tự")
    private String gender;

    private String description;

    @Size(max = 100, message = "Trạng thái sức khỏe tối đa 100 ký tự")
    private String healthStatus;

    private String vaccinated;

    private String neutered;

    private String status;

    private List<PetImageCreationDto> images;

    // Ignored in business logic to prevent BOLA/IDOR; user_id is extracted from JWT
    private Integer userId;
}
