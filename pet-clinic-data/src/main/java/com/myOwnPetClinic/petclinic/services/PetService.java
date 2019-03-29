package com.myOwnPetClinic.petclinic.services;

import com.myOwnPetClinic.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long Id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
