package com.myOwnPetClinic.petclinic.services.map;

import com.myOwnPetClinic.petclinic.model.Pet;
import com.myOwnPetClinic.petclinic.services.CrudService;
import com.myOwnPetClinic.petclinic.services.PetService;

import java.util.Set;


public class PetServiceMap extends AbstractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet.getId(), pet);
    }
}
