package com.SecretSanta.Model;

import java.util.ArrayList;

/**
 * Created by stevenliu on 2016-01-14.
 */
public class Participant {

    private ArrayList<Participant> family;
    private String firstName;
    private boolean picked;
    private Participant assignedPerson;

    public Participant(String firstName) {
        this.family = new ArrayList<>();
        this.firstName = firstName;
        this.picked = false;
    }

    // set both as family of each other
    public void setAsFamily(Participant p2) {
        if (p2 != null) {
            this.addFamilyMember(p2);
            p2.addFamilyMember(this);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public boolean isPicked() {
        return this.picked;
    }

    public void setPicked(Boolean picked) { this.picked = picked; }

    public Participant getAssignedPerson() { return this.assignedPerson; }

    public void setAssignedPerson(Participant person) {
        if (!isFamilyMember(person)) {
            this.assignedPerson = person;
        }
    }

    public ArrayList<Participant> getFamilyMember() { return this.family; }

    public int getFamilyMemberCount() {
        return this.family.size();
    }

    public void addFamilyMember(Participant person) {
        if (person != null) {
            this.family.add(person);
        }
    }

    public boolean isFamilyMember(Participant person) {
        boolean isFamily = false;
        for (Participant p : this.family) {
            if (person.equals(p)) {
                isFamily = true;
            }
        }
        return isFamily;
    }

}
