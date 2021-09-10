package de.itemis.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day1Calculator {
    public boolean isSum2020(int firstNumber, int secondNumber) {
        return (firstNumber+secondNumber) == 2020;
    }

    public Set<Integer> linesFromFileWithSum2020(String filename) throws IOException {
        Set<Integer> result = new HashSet<>();
        List<Integer> readNumbers = Files.readAllLines(Paths.get(filename)).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        for(int i: readNumbers) {
            for(int j: readNumbers) {
                if(i!=j && isSum2020(i,j)) {
                    result.add(i);
                    result.add(j);
                }
            }
        }
        return result;
    }

    public int calculateSolution(String filename) throws IOException {
        return linesFromFileWithSum2020(filename).stream().reduce(1, (a,b) -> a*b);
    }
}
