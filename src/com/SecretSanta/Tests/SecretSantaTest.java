package com.SecretSanta.Tests;

import com.SecretSanta.Model.Participant;
import com.SecretSanta.Model.SecretSanta;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;


/**
 * Created by stevenliu on 2016-01-16.
 */
public class SecretSantaTest {

    @Test
    public void testAllParticipantAssigned() {
        SecretSanta ss = new SecretSanta();
        boolean tripped = false;
        try {
            ArrayList<Participant> secretList =  ss.organizeSecretSanta("/Users/stevenliu/Desktop/Kata Training/Java/SecretSanta/test.txt");
            for (Participant p : secretList) {
                System.out.println(p.getFirstName() + " -> " + p.getAssignedPerson().getFirstName() );
                if (p.getAssignedPerson() == null) {
                    tripped = true;
                    break;
                }
            }
            assertFalse(tripped);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}