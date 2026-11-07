package com.webpet_nhom20.backdend.service;

import com.webpet_nhom20.backdend.dto.request.Pet.FullPetCreationRequest;
import com.webpet_nhom20.backdend.dto.request.Pet.MyPetCreationRequest;
import com.webpet_nhom20.backdend.dto.request.Pet.MyPetUpdateRequest;
import com.webpet_nhom20.backdend.dto.request.Pet.PetCreationRequest;
import com.webpet_nhom20.backdend.dto.request.Pet.PetUpdateRequest;
import com.webpet_nhom20.backdend.dto.response.Pet.AdminPetResponse;
import com.webpet_nhom20.backdend.dto.response.Pet.FullPetCreateResponse;
import com.webpet_nhom20.backdend.dto.response.Pet.PetResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PetService {
    PetResponse createPet(PetCreationRequest request);
    FullPetCreateResponse createFullPet(FullPetCreationRequest request);
    Page<PetResponse> getAllPets(String isDeleted, String animal, Float minWeight, Float maxWeight, String ageGroup,String breed ,String name, Pageable pageable, String status);
    List<String> getAnimalForCustomer();
    List<String> getAnimalForAdmin();
    void deletePet(int petId);
    PetResponse getPetById(int petId);
    PetResponse updatePet(int petId, PetUpdateRequest request);
    void restorePet(int petId);
    List<String> getBreed();

    // My Pets API
    PetResponse createMyPet(MyPetCreationRequest request, String token);
    Page<PetResponse> getMyPets(String token, String name, String animal, Pageable pageable);
    PetResponse getMyPetById(int petId, String token);
    PetResponse updateMyPet(int petId, MyPetUpdateRequest request, String token);
    void deleteMyPet(int petId, String token);

    // Admin Pet Management API
    Page<AdminPetResponse> getAllPetsForAdmin(String animal, String name, String ownerQuery, String status, String isDeleted, Pageable pageable);
    AdminPetResponse getPetByIdForAdmin(int petId);
}
