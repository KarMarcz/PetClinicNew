package com.myOwnPetClinic.petclinic.bootstrap;

import com.myOwnPetClinic.petclinic.model.Owner;
import com.myOwnPetClinic.petclinic.model.Vet;
import com.myOwnPetClinic.petclinic.services.OwnerService;
import com.myOwnPetClinic.petclinic.services.VetService;
import com.myOwnPetClinic.petclinic.services.map.OwnerServiceMap;
import com.myOwnPetClinic.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Charles");
        owner1.setLastName("Nixon");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Ruby");
        owner2.setLastName("Nails");

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Axel");
        vet1.setLastName("Rose");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Alicja");
        vet2.setLastName("Byłażona");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}