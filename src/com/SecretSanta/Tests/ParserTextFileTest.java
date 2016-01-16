package com.SecretSanta.Tests;

import com.SecretSanta.Model.ParserTextFile;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by stevenliu on 2016-01-14.
 */
public class ParserTextFileTest {

    private ParserTextFile parser;

    @Before
    public void setUp() throws Exception {
        parser = new ParserTextFile();
    }

    @Test
    public void testOpenFile() {
        try {
            String[] data = parser.openFile("/Users/stevenliu/Desktop/Kata Training/Java/SecretSanta/test.txt");
            assertEquals("Joe", data[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = IOException.class)
    public void testOpenFileIOException() throws IOException {
            parser.openFile("/Users/stevenliu/Desktop/Kata Training/Java/SecretSanta/fakeTextFile.txt");
    }


}