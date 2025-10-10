import components.sequence.Sequence;
import components.sequence.Sequence1L;

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
        double output = forwardPass(inputs, weights, bias);

        System.out.println("Weighted sum: " + z);
        System.out.println("Output after sigmoid function: " + output);
    }

    /**
     * This method computes the weighted sum of the inputs and weights.
     *
     * @param inputs
     *            the input sequence
     * @param weights
     *            the weight sequence
     * @return the weighted sum
     */
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

    private static double forwardPass(Sequence<Double> inputs,
            Sequence<Double> weights, double bias) {
        double z = computeWeightedSum(inputs, weights) + bias;
        return sigmoidFunction(z);
    }

    /**
     * This is a link going to where I got the function for this method.
     * https://www.geeksforgeeks.org/machine-learning/derivative-of-the-sigmoid-
     * function/
     *
     * @param x
     *            the input value
     * @return the output value between 0 and 1
     */
    private static double sigmoidFunction(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    /**
     * This method will return a new Bias after updating the weights in-place.
     * https://www.geeksforgeeks.org/machine-learning/backpropagation-in-neural-network/
     * This link above is where I got the formulas for calculating the gradients
     * and solve for delta. How to calculate the error and derivative.
     *
     * @param inputs
     *            the input sequence
     * @param weights
     *            the weight sequence
     * @param bias
     *            the bias
     * @param target
     *            the target value
     * @param learningRate
     *            the learning rate
     * @return the new bias
     * @updates weights
     */
    private static double train(Sequence<Double> inputs,
            Sequence<Double> weights, double bias, double target,
            double learningRate) {
        double output = forwardPass(inputs, weights, bias);

        /*
         * This will compute the error, derivative, and delta for the
         * backpropagation
         */
        double err = output - target;
        double derivative = output * (1 - output);
        double delta = err * derivative;

        for (int i = 0; i < weights.length(); i++) {
            double newWeight = weights.entry(i);
            double gradient = delta * inputs.entry(i);
            weights.replaceEntry(i, newWeight - learningRate * gradient);
        }
        double newBias = bias - learningRate * delta;
        return newBias;
    }
}
