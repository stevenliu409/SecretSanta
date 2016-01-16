package com.SecretSanta.Tests;

import com.SecretSanta.Model.Participant;
import org.junit.Before;
import org.junit.Test;


import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by stevenliu on 2016-01-14.
 */
public class ParticipantTest {

    private Participant p1;
    private Participant p2;


    @Before
    public void setUp() {
        p1 = new Participant("Steven");
        p2 = new Participant("Michael");
    }

    @Test
    public void testCreateParticipant() {
        assertEquals("Steven", p1.getFirstName());
        assertFalse(p1.isPicked());
    }

    @Test
    public void testSetPicked() {
        p1.setPicked(true);
        assertTrue(p1.isPicked());
    }

    @Test
    public void testAddNullFamilyMember() {
        p2 = null;
        p1.addFamilyMember(p2);
        assertEquals(0, p1.getFamilyMemberCount());
    }

    @Test
    public void testAddOneFamilyMember() {
        p1.addFamilyMember(p2);
        assertEquals("Michael", p1.getFamilyMember().get(0).getFirstName());
    }


    @Test
    public void testAddFamilyBothWays() {
        p1.setAsFamily(p2);
        assertEquals("Michael", p1.getFamilyMember().get(0).getFirstName());
        assertEquals("Steven", p2.getFamilyMember().get(0).getFirstName());
    }

    @Test
    public void testSetAssignedPerson() {
        p1.setAssignedPerson(p2);
        assertEquals(p2, p1.getAssignedPerson());
    }

    @Test
    public void testSetFamilyMemberAsAssignedPerson() {
        p1.setAsFamily(p2);
        p1.setAssignedPerson(p2);
        assertTrue(p1.getAssignedPerson() == null);

    }

}