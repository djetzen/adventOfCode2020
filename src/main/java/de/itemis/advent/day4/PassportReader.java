package de.itemis.advent.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class PassportReader {

    public Set<String> readAllPassports(String filename) throws IOException {
        Set<String> readPassports = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (String s : Files.readAllLines(Paths.get(filename))) {
            if (s.isBlank()) {
                readPassports.add(builder.toString().trim());
                builder.delete(0, builder.length());
            }
            builder.append(s).append(" ");
        }
        readPassports.add(builder.toString().trim());
        
        return readPassports;
    }
}
