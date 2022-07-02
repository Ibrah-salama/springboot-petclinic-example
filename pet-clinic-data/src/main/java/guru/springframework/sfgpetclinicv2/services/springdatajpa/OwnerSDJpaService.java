package guru.springframework.sfgpetclinicv2.services.springdatajpa;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.repositories.OwnerRepository;
import guru.springframework.sfgpetclinicv2.repositories.PetRepository;
import guru.springframework.sfgpetclinicv2.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinicv2.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.ownerRepository.findByLastName(lastName);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike(lastName);
    }
    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
         this.ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
//        Optional<Owner> ownerOptional = this.ownerRepository.findById(aLong);
        return this.ownerRepository.findById(aLong).orElse(null);
//        if(ownerOptional.isPresent()){
//            return ownerOptional.get();
//        }else {
//            return null;
//        }
    }

    @Override
    public Owner save(Owner object) {
        return this.ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        this.ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.ownerRepository.deleteById(aLong);
    }
}
