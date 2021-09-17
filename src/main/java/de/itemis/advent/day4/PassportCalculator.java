package de.itemis.advent.day4;

import de.itemis.advent.day4.model.Passport;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PassportCalculator {

    public int getNumberOfSimpleValidPassports(String filename) throws IOException {
        return getPassportsFromFile(filename).stream().filter(Passport::isSimpleValid).collect(Collectors.toSet()).size();
    }


    public int getNumberOfExtendedValidPassports(String filename) throws IOException {
        return getPassportsFromFile(filename).stream().filter(Passport::isExtendedValid).collect(Collectors.toSet()).size();
    }

    private List<Passport> getPassportsFromFile(String filename) throws IOException {
        Set<String> readLines = new PassportReader().readAllPassports(filename);
        return new PassportMapper().convertToPassports(readLines);
    }
}
