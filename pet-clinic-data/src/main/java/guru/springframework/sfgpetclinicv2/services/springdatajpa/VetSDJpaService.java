package guru.springframework.sfgpetclinicv2.services.springdatajpa;

import guru.springframework.sfgpetclinicv2.model.Vet;
import guru.springframework.sfgpetclinicv2.repositories.VetRepository;
import guru.springframework.sfgpetclinicv2.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private final VetRepository vetRepository;

    public VetSDJpaService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return this.vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return this.vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        this.vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.vetRepository.deleteById(aLong);
    }
}
