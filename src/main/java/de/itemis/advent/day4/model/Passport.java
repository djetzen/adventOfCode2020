package de.itemis.advent.day4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Passport {
    String byr;
    String iyr;
    String eyr;
    String hgt;
    String hcl;
    String ecl;
    String pid;
    String cid;

    public boolean isExtendedValid() {
        return allElementsAreSet() && passesHaveValidEntries();
    }

    public boolean isSimpleValid() {
        return allElementsAreSet();
    }

    private boolean allElementsAreSet() {
        return byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null;
    }

    private boolean passesHaveValidEntries() {
        return validateByr() && validateIyr() && validateEyr() && validateHgt() && validateHcl() && validateEcl() && validatePid();
    }

    private boolean validatePid() {
        return this.pid.length() == 9;
    }

    private boolean validateEcl() {
        var validColors = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
        return validColors.contains(this.ecl);
    }

    private boolean validateHcl() {
        return this.hcl.matches("[#][0-9a-fA-F]{6}");
    }

    private boolean validateHgt() {
        if (this.hgt.endsWith("cm")) {
            var cmSize = Integer.parseInt(this.hgt.split("cm")[0]);
            return cmSize >= 150 && cmSize <= 193;

        } else if (this.hgt.endsWith("in")) {

            var inSize = Integer.parseInt(this.hgt.split("in")[0]);
            return inSize >= 59 && inSize <= 76;
        } else {
            return false;
        }
    }

    private boolean validateEyr() {
        var e = Integer.parseInt(this.eyr);
        return e >= 2020 && e <= 2030;
    }

    private boolean validateIyr() {
        var i = Integer.parseInt(this.iyr);
        return i >= 2010 && i <= 2020;
    }

    private boolean validateByr() {
        var b = Integer.parseInt(this.byr);
        return b >= 1920 && b <= 2002;
    }
}
