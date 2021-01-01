package com.hyuseinmustafa.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person{
    private Set<Speciality> spetialities = new HashSet<>();

    public Set<Speciality> getSpetialities() {
        return spetialities;
    }

    public void setSpetialities(Set<Speciality> spetialities) {
        this.spetialities = spetialities;
    }
}
