package components.neuron;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Neuron implementation using OSU's components.
 *
 * @Convention <pre>
 * w != null and w.length() > 0
 * </pre>
 * @correspondence <pre>
 * size() = w.length() and for all i starting fromt 0 to size()
 *                 weight(i) = w.entry(i) and bias() = b
 * </pre>
 */
public final class Neuron1 extends NeuronSecondary {

    /**
     * This will be for the weights.
     */
    private final Sequence<Double> w;

    /**
     * This will be for the bias.
     */
    private double b;

    /**
     * Constructor for Neuron1.
     *
     * @param n
     *            the number of weights
     * @ensures this.size() = n and for all i starting from 0 to n,
     *          this.weight(i) = 0.0 and this.bias() = 0.0
     */
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
        this.rangeCheck(i);
        return this.w.entry(i);
    }

    @Override
    public void setWeights(int i, double w) {
        this.rangeCheck(i);
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
     * @param x
     *            the input sequence
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

    /**
     * This checks the index of the weight to make sure it is in range.
     *
     * @param i
     *            the index to check
     * @throws IndexOutOfBoundsException
     *             when i is less than 0 or greater than w.length() - 1
     */
    private void rangeCheck(double i) {
        if (i < 0 || i > this.w.length()) {
            throw new IndexOutOfBoundsException("The value: " + i
                    + " is outside between [0, " + (this.w.length() - 1) + "]");
        }
    }

}
