package com.SecretSanta.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by stevenliu on 2016-01-09.
 */
public class SecretSanta {

    private ArrayList<Participant> secretSantaParticipants;
    private ParserTextFile parser;
    private Random rng;

    public SecretSanta() {
        secretSantaParticipants = new ArrayList<>();
        parser = new ParserTextFile();
        rng = new Random();
    }

    public ArrayList<Participant> organizeSecretSanta(String path) throws IOException {
        String[] secretSantaList = parser.openFile(path);

        createSecretSantaParticipants(secretSantaList);

        for (Participant p : secretSantaParticipants) {
            while(p.getAssignedPerson() == null) {
                Participant randP = getRandomParticipant();
                if (!p.isFamilyMember(randP) && !isMe(p, randP) && !randP.isPicked()) { // BUG looped when family is forced to choose family member
                    p.setAssignedPerson(randP);
                    randP.setPicked(true);
                }
            }
        }

        return secretSantaParticipants;
    }

    private void createSecretSantaParticipants(String[] list) {
        for(String str : list) {
            if (containsFamilyMember(str)) {
                createFamily(str);
            } else {
                secretSantaParticipants.add(new Participant(str));
            }
        }
    }

    private void createFamily(String str) {
        String[] splitNames = str.split(" ");
        ArrayList<Participant> templist = new ArrayList<>();
        for (String s : splitNames) {
            Participant p = new Participant(s);
            templist.add(p);
        }

        for (Participant person : templist) {
            for(Participant p2 : templist) {
                if (!isMe(person, p2)) {
                    person.addFamilyMember(p2);
                }
            }
        }

        for (Participant part : templist) {
            secretSantaParticipants.add(part);
        }
    }

    private boolean isMe(Participant p1, Participant p2) { return p1.equals(p2); }

    private boolean containsFamilyMember(String str) {
        return str.contains(" ");
    }

    private Participant getRandomParticipant() {
        return secretSantaParticipants.get(rng.nextInt(secretSantaParticipants.size()));
    }
}
