package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Vet;
import guru.springframework.sfgpetclinicv2.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
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
        super.save(vet.getId(),vet);
        return vet;
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
