package guru.springframework.sfgpetclinicv2.model;

import java.util.Set;

public class Owner extends Person{
    private Set<Pet> pet;

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }
}
