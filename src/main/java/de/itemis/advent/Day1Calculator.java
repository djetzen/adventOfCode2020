package de.itemis.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day1Calculator {
    private boolean isSum2020(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).sum() == 2020;
    }

    private Set<Integer> linesFromFileWithTwoDigitsSummingUpTo2020(String filename) throws IOException {
        Set<Integer> result = new HashSet<>();
        List<Integer> readNumbers = readNumbersFromFile(filename);
        for (int i : readNumbers) {
            for (int j : readNumbers) {
                if (i != j && isSum2020(List.of(i, j))) {
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
                    if (i != j && j != k && i != k && isSum2020(List.of(i, j, k))) {
                        result.add(i);
                        result.add(j);
                        result.add(k);
                    }

                }
            }
        }
        return result;
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
