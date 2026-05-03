package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/**
<<<<<<< HEAD
 * Outputs patient data to files stored in a base directory
 */

=======
 * A concrete implementation of {@link OutputStrategy} for outputting to a file.
 */
>>>>>>> cb2512faa08917af024944554d54a87530971215
public class FileOutputStrategy implements OutputStrategy {
    //changed BaseDirectory to baseDirectory to match camelCase
    private String baseDirectory;
    //changed file_map to fileMap so it can match camelCase
    //changed field fintal to be private
    private final ConcurrentHashMap<String, String> fileMap = new ConcurrentHashMap<>();

    /**
     * Creates an instance of FileOutputStrategy.
     * 
     * @param baseDirectory base directory for file outputs
     */
    public FileOutputStrategy(String baseDirectory) {
        //BaseDirectory -> baseDirectory so it wont case error due to misspell
        this.baseDirectory = baseDirectory;
    }
<<<<<<< HEAD
    /**
     * Writes patient data to a file based on label
     * @param patientId ID of patient
     * @param timestamp timestamp of the record
     * @param label labels data category used for file names
     * @param data actual data to be writen
=======

    /**
     * Outputs the given data to a file. Creates a separate file for every distinct {@code label} to
     * write the data to.
>>>>>>> cb2512faa08917af024944554d54a87530971215
     */
    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {  //BaseDirectory -> baseDirectory so it wont case error due to misspell
            Files.createDirectories(Paths.get(baseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
<<<<<<< HEAD
        } //FilePath was changed to filePath so it will match camelCase
        String filePath = fileMap.computeIfAbsent(label, k -> Paths.get(baseDirectory, label + ".txt").toString());

        // Write the data to the file
        try (PrintWriter out = new PrintWriter( //FilePath changed to filePath so it wont case error
                Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
=======
        }
        String filePath = fileMap.computeIfAbsent(label,
                k -> Paths.get(baseDirectory, label + ".txt").toString());

        // Write the data to the file
        try (PrintWriter out = new PrintWriter(Files.newBufferedWriter(Paths.get(filePath),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp,
                    label, data);
>>>>>>> cb2512faa08917af024944554d54a87530971215
        } catch (Exception e) {
            System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
        }
    }
}
