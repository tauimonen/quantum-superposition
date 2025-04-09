# Quantum Measurement Simulation

This project provides a simulation framework for analyzing quantum measurements using two main classes:

1. **QuantumEntanglementAnalyzer**: Simulates the behavior of entangled photon pairs, including state initialization, measurement probabilities, and state collapse upon observation.
2. **QuantumQubitAnalyzer**: Models the measurement of a single quantum qubit's polarization state and its probabilistic collapse based on quantum mechanics principles.

## Features
- **Quantum State Representation**: Uses amplitudes to define quantum states.
- **Measurement Simulation**: Implements quantum measurements and collapses states accordingly.
- **Probability Computation**: Calculates the probabilities of different measurement outcomes.
- **Statistical Analysis**: Collects and analyzes results over multiple measurements.

## Class Overview

### QuantumEntanglementAnalyzer

#### Methods:
- `setAngles(double theta1, double theta2)`: Sets measurement angles for both photons.
- `reportProbabilities()`: Computes and prints probabilities of different outcomes.
- `measure()`: Simulates a random measurement and updates the state.

#### Example Usage:
```java
QuantumEntanglementAnalyzer simulation = new QuantumEntanglementAnalyzer(0.707, 0, 0, 0.707);
simulation.setAngles(90, 90);
simulation.reportProbabilities();
```

### QuantumQubitAnalyzer

A photon's polarization is probabilistic when it is measured relative to a specific polarization basis that does not fully align with its original polarization state.

Explanation

### 1. Original Polarization State
If a photon is initially polarized in a horizontal (|H⟨) or vertical (|V⟨) state, and it is measured in the same polarization basis (horizontal or vertical), the result is deterministic—the photon retains its original polarization.

### 2. Measurement at an Angle
If the photon's initial polarization is at some angle θ relative to the measurement basis, the measurement outcome becomes probabilistic. For example, if a photon is polarized at an angle θ and is measured in the horizontal (|H⟨) and vertical (|V⟨) basis, the probability of detecting it in the |H⟨ state is cos²(θ), and the probability of detecting it in the |V⟨ state is sin²(θ).

### 3. Quantum Explanation
This probabilistic behavior arises from the principles of quantum mechanics. When a photon's polarization is at an arbitrary angle and is measured in a basis that does not match its original state, the measurement collapses the state into one of the basis states with probabilities determined by Born's rule and the inner product between the state vectors.

## Conclusion
A photon's polarization is probabilistic when the measurement basis differs from its original polarization state. The outcome probabilities follow cos²(θ) and sin²(θ), where θ is the angle between the original state and the measurement basis.

#### Methods:
- `performMeasurement(double measurementAngle)`: Simulates a qubit polarization measurement and updates the state.

#### Example Usage:
```java
QuantumQubitAnalyzer qubit = new QuantumQubitAnalyzer(90);
boolean result = qubit.performMeasurement(45);
System.out.println("Measurement result: " + result);
```

## Running the Simulation
To execute the program, compile the Java files and run the `main` methods in each class.
```sh
javac QuantumEntanglementAnalyzer.java QuantumQubitAnalyzer.java
java QuantumEntanglementAnalyzer
java QuantumQubitAnalyzer
```

## Applications
This simulation can be used for:
- **Educational purposes**: Understanding quantum mechanics and measurement principles.
- **Research support**: Analyzing entangled photon interactions.
- **Algorithm testing**: Validating quantum computing algorithms before implementing them on quantum hardware.

## License
This project is provided under the MIT License. Feel free to modify and distribute it as needed.

