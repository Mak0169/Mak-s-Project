/**
 * This is the link to where I got the formula for this project.
 * https://www.geeksforgeeks.org/artificial-intelligence/artificial-neural
 * -networks-and-its-applications/
 */

/*
 * This program will simulate a single neuron in an artificial neuralk network.
 */
public class main {
    public static void main(String[] args) {
        /**
         * Creating a neuron with 2 inputs. Also, creating a matrix for the
         * inputs and an array for the target outputs. Going to set the learning
         * rate to 0.1 based off the documentation from the links above. Doing
         * this to avoid errors but will tinker with it once I get things
         * working.
         */
        Neuron1 neuron = new Neuron1(2);
        neuron.setWeights(0, 0.0);
        neuron.setWeights(1, 0.0);
        neuron.setBias(0.0);

        double[][] X = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
        double[] y = { 0, 0, 0, 1 };

    }
}
