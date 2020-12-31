package com.hyuseinmustafa.sfgpetclinic.services;

import com.hyuseinmustafa.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
