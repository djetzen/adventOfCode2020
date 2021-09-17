package de.itemis.advent.day4;

import de.itemis.advent.day4.model.Passport;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class PassportMapperTest {

    @Test
    void auchEinUngueltigerPassportWirdKonvertiert() {
        PassportMapper passportMapper = new PassportMapper();

        List<Passport> passports = passportMapper.convertToPassports(Set.of("iyr:2013"));

        assertThat(passports).hasSize(1);
    }

    @Test
    void einVollkonfigurierterPassportErstelltEinenGueltigenPassport() {
        String testString = "ecl:gry pid:860033327 eyr:2020 hcl:#ffffff byr:1937 iyr:2017 cid:147 hgt:183cm";
        Passport expectedPassport = new Passport("1937", "2017", "2020", "183cm", "#ffffff", "gry", "860033327", "147");
        PassportMapper passportMapper = new PassportMapper();

        List<Passport> passports = passportMapper.convertToPassports(Set.of(testString));

        Passport firstPassport = passports.get(0);
        assertThat(passports).hasSize(1);
        assertThat(expectedPassport).isEqualTo(firstPassport);
    }
}