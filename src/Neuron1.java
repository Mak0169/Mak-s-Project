import components.sequence.Sequence;
import components.sequence.Sequence1L;

public final class Neuron1 implements Neuron {

    /**
     * This will be for the weights.
     */
    private final Sequence<Double> w = new Sequence1L<>();

    /**
     * This will be for the bias.
     */
    private double b = 0.0;

    public Neuron1(int i) {
        //TODO Auto-generated constructor stub
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
    @Override
    public double computeWeightedSum(Sequence<Double> x) {
        double z = this.b;

        /*
         * This computes the summation of each input vector multiplied by its
         * corresponding weight vector.
         *
         * This is the link to where I got the formula for this function.
         * https://www.geeksforgeeks.org/machine-learning/backpropagation-in-
         * neural-network/
         */
        for (int i = 0; i < this.w.length(); i++) {
            z += this.w.entry(i) * x.entry(i);
        }
        return z;
    }

    @Override
    public double forwardPass(Sequence<Double> x) {

        return sigmoidFunction(this.computeWeightedSum(x));
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
    @Override
    public double train(Sequence<Double> inputs, Sequence<Double> weights,
            double bias, double target, double learningRate) {
        double z = this.computeWeightedSum(inputs);
        double output = sigmoidFunction(z);

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

    // These are the kernel methods that need to be implemented.
    @Override
    public int size() {
        return this.w.length();
    }

    @Override
    public double weight(int i) {
        return this.w.entry(i);
    }

    @Override
    public void setWeights(int i, double w) {
        this.w.replaceEntry(i, w);
    }

    @Override
    public double bias() {
        return this.b;
    }

    @Override
    public void setBias(double b) {
        this.b = b;
    }
}
