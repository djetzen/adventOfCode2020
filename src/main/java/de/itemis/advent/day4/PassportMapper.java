package de.itemis.advent.day4;

import de.itemis.advent.day4.model.Passport;

import java.util.*;

public class PassportMapper {

    public List<Passport> convertToPassports(Set<String> passportLines) {
        var convertedPassports = new ArrayList<Passport>();

        for (String line : passportLines) {
            Map<String, String> map = new HashMap<>();
            for (String singleValue : line.split(" ")) {
                var splittedValues = singleValue.split(":");
                map.put(splittedValues[0], splittedValues[1]);
            }
            convertedPassports.add(new Passport(map.get("byr"), map.get("iyr"), map.get("eyr"), map.get("hgt"), map.get("hcl"), map.get("ecl"), map.get("pid"), map.get("cid")));
        }
        return convertedPassports;
    }
}
