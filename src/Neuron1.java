import components.sequence.Sequence;
import components.sequence.Sequence1L;

public final class Neuron1 extends NeuronSecondary {

    /**
     * This will be for the weights.
     */
    private final Sequence<Double> w;

    /**
     * This will be for the bias.
     */
    private double b;

    public Neuron1(int n) {
        this.w = new Sequence1L<Double>();
        for (int i = 0; i < n; i++) {
            this.w.add(this.w.length(), 0.0);
        }
        this.b = 0.0;
    }

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
