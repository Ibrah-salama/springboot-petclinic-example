package guru.springframework.sfgpetclinicv2.services;

import guru.springframework.sfgpetclinicv2.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner , Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);
}
