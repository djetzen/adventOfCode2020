package de.itemis.advent.day4;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PassportReaderTest {

    @Test
    void separatorsFromFilesAreConsidered() throws IOException {
        PassportReader passportReader = new PassportReader();

        Set<String> passports = passportReader.readAllPassports("src/test/resources/day4/test_input.txt");

        assertThat(passports).hasSize(4);
    }

}