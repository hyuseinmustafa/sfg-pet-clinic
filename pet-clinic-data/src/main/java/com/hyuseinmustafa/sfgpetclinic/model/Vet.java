package com.hyuseinmustafa.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person{
    private Set<Spetiality> spetialities;

    public Set<Spetiality> getSpetialities() {
        return spetialities;
    }

    public void setSpetialities(Set<Spetiality> spetialities) {
        this.spetialities = spetialities;
    }
}
