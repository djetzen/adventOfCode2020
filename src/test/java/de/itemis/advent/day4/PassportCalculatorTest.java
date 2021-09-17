package de.itemis.advent.day4;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class PassportCalculatorTest {
    @Test
    void testInputGivesTwoValidPassports() throws IOException {
        PassportCalculator passportCalculator = new PassportCalculator();

        int numberOfValidPassports = passportCalculator.getNumberOfSimpleValidPassports("src/test/resources/day4/test_input.txt");

        assertThat(numberOfValidPassports).isEqualTo(2);
    }

    @Test
    void realInputForSimpleValidationGives200Passports() throws IOException {
        PassportCalculator passportCalculator = new PassportCalculator();

        int numberOfValidPassports = passportCalculator.getNumberOfSimpleValidPassports("src/main/resources/day4/input_day_4.txt");

        assertThat(numberOfValidPassports).isEqualTo(200);
    }

    @Test
    void realInputForExtendedValidationGives116Passports() throws IOException {
        PassportCalculator passportCalculator = new PassportCalculator();

        int numberOfValidPassports = passportCalculator.getNumberOfExtendedValidPassports("src/main/resources/day4/input_day_4.txt");

        assertThat(numberOfValidPassports).isEqualTo(116);
    }
}
