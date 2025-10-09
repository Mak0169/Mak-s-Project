import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * This is the link to where I got the formula for this project.
 * https://www.geeksforgeeks.org/artificial-intelligence/artificial-neural
 * -networks-and-its-applications/
 */

public class main {
    public static void main(String[] args) {
        Sequence<Double> inputs = new Sequence1L<>();
        Sequence<Double> weights = new Sequence1L<>();

        final double n1 = 0.5;
        final double n2 = 0.3;
        final double n3 = 0.2;
        final double w1 = 0.4;
        final double w2 = 0.6;
        final double w3 = 0.2;

        inputs.add(inputs.length(), n1);
        inputs.add(inputs.length(), n2);
        inputs.add(inputs.length(), n3);

        weights.add(weights.length(), w1);
        weights.add(weights.length(), w2);
        weights.add(weights.length(), w3);

        double bias = 0.1;

        double z = computeWeightedSum(inputs, weights) + bias;
        double output = sigmoidFunction(z);

        System.out.println("Weighted sum: " + z);
        System.out.println("Output after sigmoid function: " + output);
    }

    private static double computeWeightedSum(Sequence<Double> inputs,
            Sequence<Double> weights) {
        double sum = 0.0;

        /*
         * This computes the summation of each input vector multiplied by its
         * corresponding weight vector.
         *
         * This is the link to where I got the formula for this function.
         * https://www.geeksforgeeks.org/machine-learning/backpropagation-in-
         * neural-network/
         */
        for (int i = 0; i < inputs.length(); i++) {
            sum += inputs.entry(i) * weights.entry(i);
        }
        return sum;
    }

    /*
     * This is a link going to where I got the function for this method.
     * https://www.geeksforgeeks.org/machine-learning/derivative-of-the-sigmoid-
     * function/
     */
    private static double sigmoidFunction(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }
}
