/* Quantum Qubit Measurement Simulation */
import java.util.Random;

public class QuantumQubitAnalyzer {

    // Stores the current polarization angle of the qubit
    private double currentAngle;

    // Constructor to initialize the qubit with a given polarization angle
    public QuantumQubitAnalyzer(double initialAngle) {
        this.currentAngle = initialAngle;
    }

    /**
     * Simulates the measurement of a photon's polarization.
     * The result is either "aligned" (true) or "anti-aligned" (false),
     * and the state collapses accordingly.
     *
     * @param measurementAngle The angle at which the measurement is performed.
     * @return true if the qubit is aligned (1), false if anti-aligned (0).
     */
    public boolean performMeasurement(double measurementAngle) {
        double delta = measurementAngle - currentAngle;
        double probabilityAligned = Math.pow(Math.cos(Math.toRadians(delta)), 2);

        // Generate a random outcome based on calculated probabilities
        if (Math.random() < probabilityAligned) {
            currentAngle = measurementAngle; // Collapse state to the measurement angle
            return true; // Measurement result: aligned (1)
        } else {
            currentAngle = measurementAngle + 90; // Collapse state to perpendicular angle
            return false; // Measurement result: anti-aligned (0)
        }
    }

    public static void main(String[] args) {
        /*
         * Only one experiment should be run at a time.
         * Uncomment Experiment A and comment out Experiment B to switch between them.
         */

        // Experiment A: Single photon measured multiple times

/*        QuantumQubitAnalyzer photon = new QuantumQubitAnalyzer(90);
        for (int i = 0; i < 5; i++) {
            System.out.println(photon.performMeasurement(45));
        }*/


        // Experiment B: Statistical analysis over multiple measurements
       int alignedCount = 0;
        int antiAlignedCount = 0;

        for (int i = 0; i < 1000; i++) {
            QuantumQubitAnalyzer photon = new QuantumQubitAnalyzer(45);
            if (photon.performMeasurement(90)) {
                alignedCount++;
            } else {
                antiAlignedCount++;
            }
        }

        // Compute statistical properties of the measurement results
        double meanValue = (1.0 * alignedCount) / (alignedCount + antiAlignedCount);
        double variance = ((1.0 - meanValue) * (1.0 - meanValue) * alignedCount
                + meanValue * meanValue * antiAlignedCount) / (alignedCount + antiAlignedCount);
        double standardDeviation = Math.sqrt(variance);

        // Print statistical results
        System.out.println("Mean Probability: " + meanValue);
        System.out.println("Standard Deviation: " + standardDeviation);
    }
}