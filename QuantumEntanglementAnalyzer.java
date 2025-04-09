import java.math.BigDecimal;
import java.math.RoundingMode;

public class QuantumEntanglementAnalyzer {

    // Rounds a given decimal number to two decimal places and returns it as a string.
    private String format(double value) {
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }

    // Computes the square of a given number.
    private double square(double val) {
        return val * val;
    }

    /* Amplitudes representing the quantum state of a two-qubit system.
    The quantum state |ψ⟩ is expressed as: |ψ⟩ = a|00⟩ + b|01⟩ + c|10⟩ + d|11⟩
    Each variable (a, b, c, d) is the probability amplitude for the corresponding basis state.
    The probability of measuring a particular state is the square of its amplitude's magnitude:
    a = sqrt(P(00)), b = sqrt(P(01)), c = sqrt(P(10)), d = sqrt(P(11))
    The total probability must be normalized: |a|² + |b|² + |c|² + |d|² = 1 */
    private double a, b, c, d;

    // Constructor to initialize the quantum state based on given amplitudes.
    public QuantumEntanglementAnalyzer(double v1, double v2, double v3, double v4) {
        a = v1; b = v2; c = v3; d = v4;
        double total = a * a + b * b + c * c + d * d;

        // Ensure that the probabilities sum up to 1 (with a small margin for rounding errors).
        if (Math.abs(total - 1) > 0.01)
            System.out.println("Error: Probabilities must sum to 1.");
    }

    // Initializes the initial state angles for the photons based on given values.
    private void initializeAngles(double theta1, double theta2) {
        double rad1 = Math.toRadians(theta1);
        double rad2 = Math.toRadians(theta2);
        a = Math.cos(rad1) * Math.cos(rad2);
        b = Math.cos(rad1) * Math.sin(rad2);
        c = Math.sin(rad1) * Math.cos(rad2);
        d = Math.sin(rad1) * Math.sin(rad2);
    }

    // Variables used to define measurement settings.
    private double m00, m01, m10, m11, angle1, angle2;

    // Sets the measurement angles and calculates corresponding matrix components.
    public void setAngles(double t1, double t2) {
        angle1 = t1;
        angle2 = t2;
        double r1 = Math.toRadians(t1);
        double r2 = Math.toRadians(t2);
        m00 = Math.cos(r1) * Math.cos(r2);
        m01 = Math.cos(r1) * Math.sin(r2);
        m10 = Math.sin(r1) * Math.cos(r2);
        m11 = Math.sin(r1) * Math.sin(r2);
    }

    // Prints the probabilities of different measurement outcomes.
    public void reportProbabilities() {
        double base1 = angle1;
        double base2 = angle2;

        // Compute probabilities for all four possible measurement results.
        double p11 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(90 + base1, base2);
        double p01 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(base1, base2 + 90);
        double p10 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(90 + base1, 90 + base2);
        double p00 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(base1, base2);

        // Display probabilities for each measurement outcome.
        System.out.println("P(00) = " + format(p00));
        System.out.println("P(01) = " + format(p01));
        System.out.println("P(10) = " + format(p10));
        System.out.println("P(11) = " + format(p11));

        double threshold = 0.00001;

        // Compute conditional probabilities if the denominator is large enough.
        if (p01 + p11 > threshold)
            System.out.println("P(1|1) = " + format(p11 / (p01 + p11)));
        if (p10 + p00 > threshold)
            System.out.println("P(1|0) = " + format(p10 / (p10 + p00)));
        if (p01 + p11 > threshold)
            System.out.println("P(0|1) = " + format(p01 / (p01 + p11)));
        if (p10 + p00 > threshold)
            System.out.println("P(0|0) = " + format(p00 / (p10 + p00)));
    }

    // Performs a random measurement and updates the quantum state accordingly.
    public void measure() {
        double base1 = angle1;
        double base2 = angle2;

        // Compute the four possible measurement outcomes.
        double p11 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(90 + base1, base2);
        double p01 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(base1, base2 + 90);
        double p10 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(90 + base1, 90 + base2);
        double p00 = square((a * m00) + (b * m01) + (c * m10) + (d * m11));
        setAngles(base1, base2);

        double rand = Math.random();

        // Randomly determine the measurement result and update photon state angles.
        if (rand < p00) {
            double newA1 = angle1 + 90;
            double newA2 = angle2 + 90;
            initializeAngles(newA1, newA2);
            System.out.println("Measurement result: 00, new angles: " + format(newA1) + ", " + format(newA2));
        } else if (rand < p00 + p01) {
            double newA1 = angle1 + 90;
            double newA2 = angle2;
            initializeAngles(newA1, newA2);
            System.out.println("Measurement result: 01, new angles: " + format(newA1) + ", " + format(newA2));
        } else if (rand < p00 + p01 + p10) {
            double newA1 = angle1;
            double newA2 = angle2 + 90;
            initializeAngles(newA1, newA2);
            System.out.println("Measurement result: 10, new angles: " + format(newA1) + ", " + format(newA2));
        } else {
            double newA1 = angle1;
            double newA2 = angle2;
            initializeAngles(newA1, newA2);
            System.out.println("Measurement result: 11, new angles: " + format(newA1) + ", " + format(newA2));
        }
    }

    public static void main(String[] args) {
        QuantumEntanglementAnalyzer simulation = new QuantumEntanglementAnalyzer(0.707, 0, 0, 0.707);

        // One measuring apparatus per photon, so two angles
        simulation.setAngles(90, 90);

        simulation.reportProbabilities();

        for (int i = 0; i < 100; i++) {
            QuantumEntanglementAnalyzer experiment = new QuantumEntanglementAnalyzer(0.707, 0, 0, 0.707);
            experiment.setAngles(90, 90);
            experiment.measure();
        }
    }
}
