package matgd.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    private String filePath;

    public InputReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getInputLines() throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            lines = reader.lines().collect(Collectors.toList());
        }

        return lines;
    }
}
