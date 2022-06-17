package guru.springframework.sfgpetclinicv2.services.springdatajpa;

import guru.springframework.sfgpetclinicv2.model.Specialty;
import guru.springframework.sfgpetclinicv2.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinicv2.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJpaService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        this.specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return this.specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return this.specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        this.specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.specialtyRepository.deleteById(aLong);
    }
}
