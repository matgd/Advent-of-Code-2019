package matgd.day1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final int DIVIDER_VALUE = 3;
    public static final int SUBTRACT_VALUE = 2;

    public static void main(String[] args) {

        String filePath = "inputs" + File.separator + "day1.txt";

        List<String> inputLines = getInputLines(filePath);
        System.out.println("=== PART ONE ===");
        System.out.println(getStartFuelMass(inputLines));
        System.out.println("=== PART TWO ===");
        System.out.println(getTotalFuelMass(inputLines));
    }

    public static List<String> getInputLines(String filePath) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        return lines;
    }

    // PART ONE
    public static int getStartFuelMass(List<String> inputLines) {
        int fuelRequirements = 0;

        for (String line : inputLines) {
            fuelRequirements += Integer.parseInt(line) / DIVIDER_VALUE - SUBTRACT_VALUE;
        }

        return fuelRequirements;
    }

    // PART TWO
    public static int getTotalFuelMass(List<String> inputLines) {
        int fuelRequirements = 0;

        for (String line : inputLines) {
            int mass = Integer.parseInt(line);
            while ((mass /= DIVIDER_VALUE) > SUBTRACT_VALUE) {
                mass -= SUBTRACT_VALUE;
                fuelRequirements += mass;
            }
        }

        return  fuelRequirements;
    }
}
