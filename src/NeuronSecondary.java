import components.sequence.Sequence;

public abstract class NeuronSecondary implements Neuron {
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
    public void transferFrom(NeuronKernel arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }

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
    public double train(Sequence<Double> inputs, double target,
            double learningRate) {
        double z = this.computeWeightedSum(inputs);
        double output = this.sigmoidFunction(z);
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

    protected abstract double sigmoidFunction(double z);
}
