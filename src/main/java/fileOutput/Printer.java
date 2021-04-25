package fileOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Function;

public class Printer {

    public static void printToCsv(String filename, Function<Double, Double> function, double argMin, double argMax, double argStep) {
        try {
            Path resultFile = Paths.get(filename);
            if (Files.exists(resultFile))
                Files.delete(resultFile);
            Files.createFile(resultFile);
            for (double x = argMin; x <= argMax; x += argStep)
                Files.write(resultFile, String.format("%f;%f\n", x, function.apply(x)).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }
}
