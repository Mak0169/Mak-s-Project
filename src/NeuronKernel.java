import components.sequence.Sequence;
import components.standard.Standard;

/**
 * Main interface for neuron.
 */
public interface NeuronKernel extends Standard<NeuronKernel> {

    /**
     * Returns the size of the neuron.
     *
     * @return number of weights
     */
    int size();

    /**
     * Returns the weight at i.
     *
     * @param i
     * @return weight at i.
     */
    double weight(int i);

    /**
     * Computes the weighted sum of inputs and weights.
     *
     * @param inputs
     * @param weights
     * @return teh weighted sum.
     */
    double computeWeightedSum(Sequence<Double> inputs);

    /**
     * Sets the weight at i.
     *
     * @param i
     * @param w
     */
    void setWeights(int i, double w);

    /**
     * Returns the bias.
     *
     * @return the bias.
     */
    double bias();

    /**
     * Sets the bias.
     *
     * @param b
     */
    void setBias(double b);

    @Override
    void clear();

    @Override
    NeuronKernel newInstance();

    @Override
    void transferFrom(NeuronKernel source);
}
