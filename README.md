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

