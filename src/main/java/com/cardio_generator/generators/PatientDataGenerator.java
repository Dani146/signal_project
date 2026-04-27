package com.cardio_generator.generators;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * Describes the interface for patient data simulators.
 */
public interface PatientDataGenerator {
    /**
     * Generates patient data for a particular patient (based on {@code patientId}) and outputs it
     * to the given {@code outputStrategy}.
     * 
     * @param patientId id of the patient for whom to generate the data
     * @param outputStrategy output strategy to use for output
     */
    void generate(int patientId, OutputStrategy outputStrategy);
}
