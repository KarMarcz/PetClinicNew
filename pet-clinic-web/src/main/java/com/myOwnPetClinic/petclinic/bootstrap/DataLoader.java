package com.myOwnPetClinic.petclinic.bootstrap;

import com.myOwnPetClinic.petclinic.model.*;
import com.myOwnPetClinic.petclinic.services.OwnerService;
import com.myOwnPetClinic.petclinic.services.PetTypeService;
import com.myOwnPetClinic.petclinic.services.SpecialityService;
import com.myOwnPetClinic.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType saveCatPetType = petTypeService.save(cat);

        PetType hamster = new PetType();
        cat.setName("Hamster");
        PetType saveHamsterPetType = petTypeService.save(hamster);

        System.out.println("Loaded Pet Types.....");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        System.out.println("Loaded Specialities.....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Charles");
        owner1.setLastName("Nixon");
        owner1.setAddress("1 Forfal");
        owner1.setCity("NYC");
        owner1.setTelephone("489017452");

        Pet charlesPet = new Pet();
        charlesPet.setPetType(cat);
        charlesPet.setOwner(owner1);
        charlesPet.setBirthDate(LocalDate.now());
        charlesPet.setName("Remigiusz");
        owner1.getPets().add(charlesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ruby");
        owner2.setLastName("Nails");
        owner2.setAddress("1 New Drive");
        owner2.setCity("Boston");
        owner2.setTelephone("874359832753");

        Pet rubyPet = new Pet();
        charlesPet.setPetType(hamster);
        charlesPet.setOwner(owner2);
        charlesPet.setBirthDate(LocalDate.now());
        charlesPet.setName("dziejka");
        owner1.getPets().add(rubyPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Axel");
        vet1.setLastName("Rose");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Alicja");
        vet2.setLastName("Byłażona");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
