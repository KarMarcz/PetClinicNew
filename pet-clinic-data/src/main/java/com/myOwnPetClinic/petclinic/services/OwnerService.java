package com.myOwnPetClinic.petclinic.services;

import com.myOwnPetClinic.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
