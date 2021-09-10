package de.itemis.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day1Calculator {
    private Set<Integer> linesFromFileWithTwoDigitsSummingUpTo2020(String filename) throws IOException {
        Set<Integer> result = new HashSet<>();
        List<Integer> readNumbers = readNumbersFromFile(filename);
        for (int i : readNumbers) {
            for (int j : readNumbers) {
                if (areUniqueNumbers(i, j) && isSum2020(i, j)) {
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }

    private Set<Integer> linesFromFileWithThreeDigitsSummingUpTo2020(String filename) throws IOException {
        Set<Integer> result = new HashSet<>();
        List<Integer> readNumbers = readNumbersFromFile(filename);
        for (int i : readNumbers) {
            for (int j : readNumbers) {
                for (int k : readNumbers) {
                    if (areUniqueNumbers(i, j, k) && isSum2020(i, j, k)) {
                        result.add(i);
                        result.add(j);
                        result.add(k);
                    }

                }
            }
        }
        return result;
    }

    private boolean areUniqueNumbers(Integer... numbers) {
        return Arrays.stream(numbers).collect(Collectors.toSet()).size() == numbers.length;
    }

    private boolean isSum2020(Integer... numbers) {
        return Arrays.stream(numbers).mapToInt(Integer::intValue).sum() == 2020;
    }

    private List<Integer> readNumbersFromFile(String filename) throws IOException {
        return Files.readAllLines(Paths.get(filename)).stream().mapToInt(Integer::parseInt).boxed().toList();
    }

    public int calculateSolutionForPuzzleOne(String filename) throws IOException {
        return linesFromFileWithTwoDigitsSummingUpTo2020(filename).stream().reduce(1, (a, b) -> a * b);
    }

    public int calculateSolutionForPuzzleTwo(String filename) throws IOException {
        return linesFromFileWithThreeDigitsSummingUpTo2020(filename).stream().reduce(1, (a, b) -> a * b);
    }
}
