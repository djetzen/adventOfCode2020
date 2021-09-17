package de.itemis.advent.day4.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PassportTest {
    Passport validPassport = new Passport("1937", "2017", "2020", "183cm", "#ffffff", "gry", "860033327", "147");

    @ParameterizedTest
    @MethodSource("birthYearCorrect")
    void birthYearIsCorrect(String birthYear, boolean result) {
        validPassport.setByr(birthYear);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> birthYearCorrect() {
        return Stream.of(
                Arguments.of("1919", false),
                Arguments.of("2003", false),
                Arguments.of("2002", true),
                Arguments.of("1920", true)
        );
    }

    @ParameterizedTest
    @MethodSource("pidCorrect")
    void pidIsCorrect(String pidCorrect, boolean result) {
        validPassport.setPid(pidCorrect);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> pidCorrect() {
        return Stream.of(
                Arguments.of("0", false),
                Arguments.of("000000000", true)
        );
    }

    @ParameterizedTest
    @MethodSource("iyrCorrect")
    void issuerYearIsValid(String issuerYear, boolean result) {
        validPassport.setIyr(issuerYear);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> iyrCorrect() {
        return Stream.of(
                Arguments.of("2009", false),
                Arguments.of("2021", false),
                Arguments.of("2010", true),
                Arguments.of("2020", true)
        );
    }

    @ParameterizedTest
    @MethodSource("eyrCorrect")
    void expiryYearIsValid(String expiryYear, boolean result) {
        validPassport.setEyr(expiryYear);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> eyrCorrect() {
        return Stream.of(
                Arguments.of("2019", false),
                Arguments.of("2031", false),
                Arguments.of("2020", true),
                Arguments.of("2030", true)
        );
    }

    @ParameterizedTest
    @MethodSource("eclCorrect")
    void eyeColorIsValid(String eclValue, boolean result) {
        validPassport.setEcl(eclValue);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> eclCorrect() {
        return Stream.of(
                Arguments.of("a", false),
                Arguments.of("amb", true),
                Arguments.of("blu", true),
                Arguments.of("brn", true),
                Arguments.of("gry", true),
                Arguments.of("grn", true),
                Arguments.of("hzl", true),
                Arguments.of("oth", true)
        );
    }

    @ParameterizedTest
    @MethodSource("hclCorrect")
    void hairColorIsValid(String hclValue, boolean result) {
        validPassport.setHcl(hclValue);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> hclCorrect() {
        return Stream.of(
                Arguments.of("#FFFFFFF", false),
                Arguments.of("#FFFFFF", true)
        );
    }

    @ParameterizedTest
    @MethodSource("hgtCorrect")
    void heightIsValid(String hgtValue, boolean result) {
        validPassport.setHgt(hgtValue);

        assertThat(validPassport.isExtendedValid()).isEqualTo(result);
    }

    private static Stream<Arguments> hgtCorrect() {
        return Stream.of(
                Arguments.of("149cm", false),
                Arguments.of("194cm", false),
                Arguments.of("150cm", true),
                Arguments.of("193cm", true),
                Arguments.of("58in", false),
                Arguments.of("77in", false),
                Arguments.of("59in", true),
                Arguments.of("76in", true)
        );
    }
}