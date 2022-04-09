package guru.springframework.sfgpetclinicv2.services;

import guru.springframework.sfgpetclinicv2.model.Pet;

import java.util.Set;

public interface PetService {
    Pet fndById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
