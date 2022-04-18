package guru.springframework.sfgpetclinicv2.bootstrap;

import guru.springframework.sfgpetclinicv2.model.Owner;
import guru.springframework.sfgpetclinicv2.model.Pet;
import guru.springframework.sfgpetclinicv2.model.PetType;
import guru.springframework.sfgpetclinicv2.model.Vet;
import guru.springframework.sfgpetclinicv2.services.OwnerService;
import guru.springframework.sfgpetclinicv2.services.PetTypeService;
import guru.springframework.sfgpetclinicv2.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }
    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Watson");
        owner1.setAddress("123 Brickrel");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");
        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brickrel");
        owner2.setCity("Miami");
        owner2.setTelephone("123123123");
        Pet fionaCat = new Pet();
        fionaCat.setName("Just Cat");
        fionaCat.setOwner(owner2);
        fionaCat.setBirthDate(LocalDate.now());
        fionaCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionaCat);
        ownerService.save(owner2);
        System.out.println("Loading owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Mas");
        vet2.setLastName("Exa");

        vetService.save(vet2);

        System.out.println("Loading vets....");
    }
}
