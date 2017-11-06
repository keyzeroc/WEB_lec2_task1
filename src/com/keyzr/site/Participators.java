package com.keyzr.site;

import java.util.HashSet;
import java.util.Set;

public class Participators {

    private Set<Participator> participators = new HashSet<>();

    public void add(Participator participator){
        participators.add(participator);
    }

    public Set<Participator> getParticipators() {
        return participators;
    }

    @Override
    public String toString() {
        return "Participators{" +
                "participators=" + participators +
                '}';
    }
}
