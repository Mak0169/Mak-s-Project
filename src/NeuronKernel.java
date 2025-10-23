import components.sequence.Sequence;

public interface NeuronKernel {
    int size();

    double weight(int i);

    double computeWeightedSum(Sequence<Double> inputs,
            Sequence<Double> weights);

    void setWeights(int i, double w);

    double bias();

    void setBias(double b);
}
