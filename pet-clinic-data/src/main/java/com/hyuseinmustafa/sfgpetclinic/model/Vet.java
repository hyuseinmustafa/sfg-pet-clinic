package com.hyuseinmustafa.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Speciality> spetialities = new HashSet<>();

    public Set<Speciality> getSpetialities() {
        return spetialities;
    }

    public void setSpetialities(Set<Speciality> spetialities) {
        this.spetialities = spetialities;
    }
}
