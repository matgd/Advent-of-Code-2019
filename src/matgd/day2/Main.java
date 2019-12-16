package matgd.day2;

import matgd.utils.InputReader;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public final static int ADDITION = 1;
    public final static int MULTIPLICATION = 2;
    public final static int PROGRAM_HALT = 99;
    public final static int DESIRED_MEMORY_VALUE = 19690720;

    private String filePath = "inputs" + File.separator + "day2.txt";
    private InputReader inputReader;

    public static void main(String[] args) throws IOException {
        Main app = new Main();
        List<String> cells = app.repairComputer(12, 2);
        System.out.println("=== PART ONE ===");
        System.out.println(cells.get(0));
        System.out.println("=== PART TWO ===");
        System.out.println(Arrays.toString(app.findCorrectMemoryValue()));
    }

    // PART ONE
    public List<String> repairComputer(int noun, int verb) throws IOException {
        inputReader = new InputReader(this.filePath);
        String inputLine = inputReader.getInputLines().get(0);
        List<String> inputCells = Arrays.asList(inputLine.split(","));
        boolean haltProgram = false;

        // PRECONDITIONS
        inputCells.set(1, String.valueOf(noun));
        inputCells.set(2, String.valueOf(verb));


        // MAIN LOOP
        for (int i = 0; i < inputCells.size() && !haltProgram; i += 4) {
            int operationMode = Integer.parseInt(inputCells.get(i));
            int firstInputIndex = Integer.parseInt(inputCells.get(i+1));
            int secondInputIndex = Integer.parseInt(inputCells.get(i+2));
            int outputIndex = Integer.parseInt(inputCells.get(i+3));

            int firstInput = Integer.parseInt(inputCells.get(firstInputIndex));
            int secondInput = Integer.parseInt(inputCells.get(secondInputIndex));

            switch (operationMode) {
                case ADDITION:
                    inputCells.set(outputIndex, String.valueOf(firstInput + secondInput));
                    break;
                case MULTIPLICATION:
                    inputCells.set(outputIndex, String.valueOf(firstInput * secondInput));
                    break;
                case PROGRAM_HALT:
                    haltProgram = true;
                    break;
                default:
                    System.out.println("INCORRECT OPERATION MODE: " + operationMode);
            }
        }

        return inputCells;
    }

    // PART TWO - DOESN'T WORK, FINDS [71, 15]
    public int[] findCorrectMemoryValue() throws IOException {
        int noun = -1;
        int verb = -1;
        boolean found = false;


        for (noun = 0; noun < 100 && !found; noun++) {
            for (verb = 0; verb < 100 && !found; verb++) {
                if (Integer.parseInt(this.repairComputer(noun, verb).get(0)) == DESIRED_MEMORY_VALUE)
                    found = true;
            }
        }

        return new int[]{noun, verb};
    }
}
