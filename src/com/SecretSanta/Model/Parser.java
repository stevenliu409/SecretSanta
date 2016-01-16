package com.SecretSanta.Model;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by stevenliu on 2016-01-14.
 */
public interface Parser {

    String[] openFile(String path) throws IOException;
}
