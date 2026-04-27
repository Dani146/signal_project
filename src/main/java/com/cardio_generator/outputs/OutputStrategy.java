package com.cardio_generator.outputs;

/**
 * Describes the interface for output strategies. For example, output could be printed to the
 * terminal, or it could be sent over network to a client.
 */
public interface OutputStrategy {
    /**
     * Outputs the given data to where the strategy implementation defines.
     * 
     * @param patientId id of the patient
     * @param timestamp the timestamp of this output (typically, the current time at the time of
     *        calling this method)
     * @param label label for the data (e.g., ECG, Cholesterol)
     * @param data the data described by the label
     */
    void output(int patientId, long timestamp, String label, String data);
}
