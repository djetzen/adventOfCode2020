package de.itemis.advent.day2;

import de.itemis.advent.day2.model.Password;
import de.itemis.advent.day2.model.Range;
import lombok.Value;

@Value
public class PasswordChecker {
    String input;

    public boolean isPasswordValidForPartOne() {
        Password password = getPassword();
        var characterCount = password.getPassword().chars().filter(c -> c == password.getCharacter()).count();
        return characterCount >= password.getRange().getLower() && characterCount <= password.getRange().getUpper();
    }


    public boolean isPasswordValidForPartTwo() {
        Password password = getPassword();
        String passwordToBeChecked = getPassword().getPassword();
        var firstLocationHit = passwordToBeChecked.charAt(password.getRange().getLower() - 1) == password.getCharacter();
        var secondLocationHit = passwordToBeChecked.charAt(password.getRange().getUpper() - 1) == password.getCharacter();
        return firstLocationHit ^ secondLocationHit;
    }

    public Password getPassword() {
        var splittedString = input.split(" ");
        var rangeSplit = splittedString[0].split("-");
        var character = splittedString[1].replace(":", "");
        var passwordToParse = splittedString[2];
        var range = new Range(Integer.parseInt(rangeSplit[0]), Integer.parseInt(rangeSplit[1]));
        return new Password(range, character.charAt(0), passwordToParse);
    }
}
