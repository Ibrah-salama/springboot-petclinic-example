package guru.springframework.sfgpetclinicv2.services.springdatajpa;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.repositories.OwnerRepository;
import guru.springframework.sfgpetclinicv2.repositories.PetRepository;
import guru.springframework.sfgpetclinicv2.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    final String LAST_NAME = "Smith";

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).firstName("Johnny").lastName("Depp").build();
    }

    @Test
    void findByLastName() {
        Owner returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        Owner smith = ownerSDJpaService.findByLastName(LAST_NAME);
        assertEquals( LAST_NAME,smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).firstName("Ibrahim").lastName("Salama").build());
        ownerSet.add(Owner.builder().id(2L).firstName("Hossam").lastName("Radwan").build());
        ownerSet.add(Owner.builder().id(3L).firstName("Christin").lastName("George").build());
        ownerSet.add(Owner.builder().id(4L).firstName("Omar").lastName("Abdullah").build());
        ownerSet.add(Owner.builder().id(5L).firstName("Aya").lastName("Hassan").build());
        ownerSet.add(Owner.builder().id(6L).firstName("Mohamed").lastName("Bassiouni").build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(6,owners.size());
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner owner = ownerSDJpaService.findById(1L);
        assertNotNull(owner);
        assertEquals(1L, owner.getId());
    }
    @Test
    void findByIdNotFound(){
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner owner = ownerSDJpaService.findById(1L);
        assertNull(owner);
    }
    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner savedOwner = ownerSDJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(returnedOwner);
        //default is 1 times
        verify(ownerRepository, times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }
}