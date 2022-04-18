package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Specialty;
import guru.springframework.sfgpetclinicv2.model.Vet;
import guru.springframework.sfgpetclinicv2.services.SpecialtyService;
import guru.springframework.sfgpetclinicv2.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll(){
        return super.findAll();
    }
    @Override
    public Vet findById(Long id){
        return super.findById(id);
    }
    @Override
    public Vet save(Vet vet){
        if(vet.getSpecialties().size() >0){
            vet.getSpecialties().forEach(specialty -> {
                if(specialty.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
    }
    @Override
    public void delete(Vet vet){
        super.delete(vet);
    }
    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }
}
