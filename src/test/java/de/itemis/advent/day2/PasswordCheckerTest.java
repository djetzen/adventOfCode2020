package de.itemis.advent.day2;

import de.itemis.advent.day2.model.Password;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordCheckerTest {

    @Test
    void anInvalidPasswordForPartOneIsNotValid() {
        PasswordChecker checker = new PasswordChecker("1-3 b: cdefg");
        boolean isValid = checker.isPasswordValidForPartOne();

        assertFalse(isValid);
    }

    @Test
    void aValidPasswordForPartOneIsValid() {
        PasswordChecker checker = new PasswordChecker("1-3 a: abcde");
        boolean isValid = checker.isPasswordValidForPartOne();

        assertTrue(isValid);
    }

    @Test
    void getNumbersOfCharacterToAppearShouldBeParsed() {
        PasswordChecker checker = new PasswordChecker("1-3 a: abcde");
        Password password = checker.getPassword();

        assertThat(password.getRange().getLower()).isEqualTo(1);
        assertThat(password.getRange().getUpper()).isEqualTo(3);
    }

    @Test
    void getCharacterToAppearShouldBeParsed() {
        PasswordChecker checker = new PasswordChecker("1-3 b: cdefg");
        Password password = checker.getPassword();

        assertThat(password.getCharacter()).isEqualTo('b');
    }

    @Test
    void getPasswordToCheckIsParsed() {
        PasswordChecker checker = new PasswordChecker("1-3 a: abcde");
        Password password = checker.getPassword();

        assertThat(password.getPassword()).isEqualTo("abcde");
    }

    @Test
    void getSolutionForFirstPart() throws IOException {
        List<String> inputPasswords = Files.readAllLines(Paths.get("src/main/resources/day2/input_day_2.txt"));
        Integer correctPasswordCount = 0;

        for (String inputPassword : inputPasswords) {
            var checker = new PasswordChecker(inputPassword);
            if (checker.isPasswordValidForPartOne()) {
                correctPasswordCount++;
            }
        }
        assertThat(correctPasswordCount).isEqualTo(434);
    }

    @Test
    void anInvalidPasswordForPartTwoIsNotValid() {
        PasswordChecker checker = new PasswordChecker("2-9 c: ccccccccc");
        boolean isValid = checker.isPasswordValidForPartTwo();

        assertFalse(isValid);
    }

    @Test
    void aValidPasswordForPartTwoIsValid() {
        PasswordChecker checker = new PasswordChecker("1-3 a: abcde");
        boolean isValid = checker.isPasswordValidForPartTwo();

        assertTrue(isValid);
    }

    @Test
    void getSolutionForSecondPart() throws IOException {
        List<String> inputPasswords = Files.readAllLines(Paths.get("src/main/resources/day2/input_day_2.txt"));
        Integer correctPasswordCount = 0;

        for (String inputPassword : inputPasswords) {
            var checker = new PasswordChecker(inputPassword);
            if (checker.isPasswordValidForPartTwo()) {
                correctPasswordCount++;
            }
        }
        assertThat(correctPasswordCount).isEqualTo(509);
    }
}