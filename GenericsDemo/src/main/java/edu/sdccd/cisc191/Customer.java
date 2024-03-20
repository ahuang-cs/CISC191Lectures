package edu.sdccd.cisc191;

import java.util.HashSet;
import java.util.Set;

public class Customer extends User {
    private Set<Interests> interests = new HashSet<>();

    public Customer(long id, String name) {
        super(id, name);
    }

    public Customer() {
        super();
    }

    public void addInterest(Interests interest) throws Exception {
        if(!interests.add(interest)) throw new Exception("Failed to add " + interest);
    }

    public void removeInterest(Interests interest) throws Exception {
        if(!interests.remove(interest)) throw new Exception("Failed to remove " + interest);
    }

    public boolean hasInterest(Interests interest) {
        return interests.contains(interest);
    }

    public Set<Interests> getInterests() {
        return interests;
    }

    public void setInterests(Set<Interests> interests) {
        this.interests = interests;
    }
}
