package de.itemis.advent;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class Day1CalculatorTest {

    @Test
    void ifTwoNumbersSumUpTo2020ItIsRecognized() {
        Day1Calculator day1Calculator = new Day1Calculator();
        boolean result  = day1Calculator.isSum2020(2019,1);

        assertTrue(result);

    }

    @Test
    void ifTwoNumbersDoNotSumUpTo2020ItIsNotRecognized() {
        Day1Calculator day1Calculator = new Day1Calculator();
        boolean result  = day1Calculator.isSum2020(1,1);

        assertFalse(result);
    }

    @Test
    void ifThereAreNoNumbersThatSumUpTo2020AnEmptyListIsReturned() throws IOException {
        String filename = "src/test/resources/day1/none_matching_numbers.txt";
        Day1Calculator day1Calculator = new Day1Calculator();

        Set<Integer> numbersWithSum2020 = day1Calculator.linesFromFileWithSum2020(filename);

        assertTrue(numbersWithSum2020.isEmpty());
    }

    @Test
    void ifThereAreNumbersThatSumUpTo2020BothValuesAreReturned() throws IOException {
        String filename = "src/test/resources/day1/matching_numbers.txt";
        Day1Calculator day1Calculator = new Day1Calculator();

        Set<Integer> numbersWithSum2020 = day1Calculator.linesFromFileWithSum2020(filename);

        assertThat(numbersWithSum2020).hasSize(2);
        assertThat(numbersWithSum2020).contains(2019);
        assertThat(numbersWithSum2020).contains(1);
    }

    @Test
    void calculateSolution() throws IOException {
        String filename = "src/main/resources/day1/input_day_1_1.txt";
        Day1Calculator day1Calculator = new Day1Calculator();

        int solution = day1Calculator.calculateSolution(filename);

        assertThat(solution).isEqualTo(605364);
    }
}
