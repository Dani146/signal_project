package com.cardio_generator.outputs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Outputs patient data to files stored in a base directory
 */

public class FileOutputStrategy implements OutputStrategy {
    //changed BaseDirectory to baseDirectory to match camelCase
    private String baseDirectory;
    //changed file_map to fileMap so it can match camelCase
    //changed field fintal to be private
    private final ConcurrentHashMap<String, String> fileMap = new ConcurrentHashMap<>();

    public FileOutputStrategy(String baseDirectory) {
        //BaseDirectory -> baseDirectory so it wont case error due to misspell
        this.baseDirectory = baseDirectory;
    }
    /**
     * Writes patient data to a file based on label
     * @param patientId ID of patient
     * @param timestamp timestamp of the record
     * @param label labels data category used for file names
     * @param data actual data to be writen
     */
    @Override
    public void output(int patientId, long timestamp, String label, String data) {
        try {  //BaseDirectory -> baseDirectory so it wont case error due to misspell
            Files.createDirectories(Paths.get(baseDirectory));
        } catch (IOException e) {
            System.err.println("Error creating base directory: " + e.getMessage());
            return;
        } //FilePath was changed to filePath so it will match camelCase
        String filePath = fileMap.computeIfAbsent(label, k -> Paths.get(baseDirectory, label + ".txt").toString());

        // Write the data to the file
        try (PrintWriter out = new PrintWriter( //FilePath changed to filePath so it wont case error
                Files.newBufferedWriter(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.printf("Patient ID: %d, Timestamp: %d, Label: %s, Data: %s%n", patientId, timestamp, label, data);
        } catch (Exception e) {
            System.err.println("Error writing to file " + filePath + ": " + e.getMessage());
        }
    }
}
