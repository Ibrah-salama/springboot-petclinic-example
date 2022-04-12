package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Pet;
import guru.springframework.sfgpetclinicv2.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {
    @Override
    public Set<Pet> findAll(){
        return super.findAll();
    }
    @Override
    public Pet findById(Long id){
        return super.findById(id);
    }
    @Override
    public Pet save(Pet pet){
        super.save(pet.getId(),pet);
        return pet;
    }
    @Override
    public void delete(Pet pet){
        super.delete(pet);
    }
    @Override
    public void deleteById(Long id){
        super.deleteById(id);
    }
}
