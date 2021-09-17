package de.itemis.advent.day1;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


class Day1CalculatorTest {

    @Test
    void calculateSolutionForPartOne() throws IOException {
        String filename = "src/main/resources/day1/input_day_1.txt";
        Day1Calculator day1Calculator = new Day1Calculator();

        int solution = day1Calculator.calculateSolutionForPuzzleOne(filename);

        assertThat(solution).isEqualTo(605364);
    }

    @Test
    void calculateSolutionForPartTwo() throws IOException {
        String filename = "src/main/resources/day1/input_day_1.txt";
        Day1Calculator day1Calculator = new Day1Calculator();

        int solution = day1Calculator.calculateSolutionForPuzzleTwo(filename);

        assertThat(solution).isEqualTo(128397680);
    }
}
