package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.services.OwnerService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
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
        super.save(owner.getId(),owner);
        return owner;
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
        return null;
    }
}
