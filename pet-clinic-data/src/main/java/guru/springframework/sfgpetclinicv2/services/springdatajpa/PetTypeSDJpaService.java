package guru.springframework.sfgpetclinicv2.services.springdatajpa;

import guru.springframework.sfgpetclinicv2.model.PetType;
import guru.springframework.sfgpetclinicv2.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinicv2.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        this.petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return this.petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return this.petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        this.petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.petTypeRepository.deleteById(aLong);
    }
}
