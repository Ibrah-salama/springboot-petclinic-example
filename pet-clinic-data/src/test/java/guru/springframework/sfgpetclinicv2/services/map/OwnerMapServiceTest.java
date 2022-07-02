package guru.springframework.sfgpetclinicv2.services.map;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerMapServiceTest {
    OwnerService ownerService;
    final Long ownerId = 1L;
    OwnerMapService ownerMapService;

    final String lastName = "Smith";
    @BeforeEach
    void setUp() {
        ownerService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        ownerService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerService.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerService.findById(ownerId);
        assertEquals(ownerId , owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).firstName("Ibrahim").lastName("Salama").build();
        Owner savedOwner = ownerService.save(owner2);
        assertEquals(id, savedOwner.getId());
    }
    @Test
    void saveNoId(){
        Owner owner3 = ownerService.save(Owner.builder().build());
        assertNotNull(owner3);
        assertNotNull(owner3.getId());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0,ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.delete(ownerService.findById(ownerId));
        assertEquals(0,ownerService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerService.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(lastName, smith.getLastName());
        assertEquals(ownerId, smith.getId());
    }

}