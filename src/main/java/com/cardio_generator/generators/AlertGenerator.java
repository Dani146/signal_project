package com.cardio_generator.generators;
import java.util.Random;

import com.cardio_generator.outputs.OutputStrategy;

/**
 * generates the alert for each new patient, based on their ID
 * each alert can be trigerred randomly based on probabilistic model
 * and can be resolved with definied probability 
 */
public class AlertGenerator implements PatientDataGenerator {
    //changed field to be private 
    private static final Random randomGenerator = new Random();
    //changed AlertStates to alertStates to follow camelCase
    private boolean[] alertStates; // false = resolved, true = pressed
    
    /**
     * creates an instance of AlertGenerator
     * @param patientCount number of patients
     */
    public AlertGenerator(int patientCount) { 
        alertStates = new boolean[patientCount + 1]; //alertStates changed so there wont be error
    }
    /**
     * generate the alert for each patient
     * @param petientId ID of each patient
     * @param outputStrategy how data is printed
     */
    @Override
    public void generate(int patientId, OutputStrategy outputStrategy) {
        try {
            if (alertStates[patientId]) {//alertStates changed so there wont be error
                if (randomGenerator.nextDouble() < 0.9) { // 90% chance to resolve
                    alertStates[patientId] = false;//alertStates changed so there wont be error
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "resolved");
                }
            } else {
                //lamdbda changed to be lowercamelCase
                double lamdbda  = 0.1; // Average rate (alerts per period), adjust based on desired frequency
                double p = -Math.expm1(-lamdbda ); // Probability of at least one alert in the period
                boolean alertTriggered = randomGenerator.nextDouble() < p;

                if (alertTriggered) {
                    alertStates[patientId] = true;//alertStates changed so there wont be error
                    // Output the alert
                    outputStrategy.output(patientId, System.currentTimeMillis(), "Alert", "triggered");
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while generating alert data for patient " + patientId);
            e.printStackTrace();
        }
    }
}
