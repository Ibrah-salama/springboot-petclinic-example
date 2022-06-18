package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.model.Pet;
import guru.springframework.sfgpetclinicv2.services.OwnerService;
import guru.springframework.sfgpetclinicv2.services.PetService;
import guru.springframework.sfgpetclinicv2.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {
    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll(){
        return super.findAll();
    }
    @Override
    public Owner findById(Long id){
        return super.findById(id);
    }
    @Override
    public Owner save(Owner owner){
        if(owner != null){
            if(owner.getPets() != null){
                owner.getPets().forEach(pet->{
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("Pet Type is required!");
                    }
                    if(pet.getId()==null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
           return super.save(owner);
        }else {
            return null;
        }
    }
    @Override
    public void delete(Owner owner){
        super.delete(owner);
    }
    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
