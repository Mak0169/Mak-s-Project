import components.sequence.Sequence;

public abstract class NeuronSecondary implements Neuron {
    /**
     * This method will return a new Bias after updating the weights in-place.
     * https://www.geeksforgeeks.org/machine-learning/backpropagation-in-neural-network/
     * This link above is where I got the formulas for calculating the gradients
     * and solve for delta. How to calculate the error and derivative.
     *
     * @param inputs
     *            the input sequence
     * @param target
     *            the target value
     * @param learningRate
     *            the learning rate
     * @return the new bias
     * @updates weights
     */
    @Override
    public double train(Sequence<Double> inputs, double target,
            double learningRate) {
        double z = this.computeWeightedSum(inputs);
        double output = sigmoidFunction(z);
        final double num = 0.5;

        /*
         * This will compute the error, derivative, and delta for the
         * backpropagation
         */
        double err = output - target;
        double derivative = output * (1.0 - output);
        double delta = err * derivative;

        for (int i = 0; i < this.size(); i++) {
            double newWeight = this.weight(i);
            double gradient = delta * inputs.entry(i);
            this.setWeights(i, newWeight - learningRate * gradient);
        }
        this.setBias(this.bias() - learningRate * delta);
        return num * (output - target) * (output - target);
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
    protected static double sigmoidFunction(double x) {
        return 1.0 / (1.0 + Math.exp(-x));
    }

    @Override
    public double forwardPass(Sequence<Double> x) {
        return sigmoidFunction(this.computeWeightedSum(x));
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public NeuronKernel newInstance() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'newInstance'");
    }

    @Override
    public void transferFrom(NeuronKernel source) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }
}
