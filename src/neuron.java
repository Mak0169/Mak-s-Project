import components.sequence.Sequence;

// Secondary interface that extends NeuronKernel.
public interface Neuron extends NeuronKernel {
    double forwardPass(Sequence<Double> inputs, Sequence<Double> weights,
            double bias);

    double train(Sequence<Double> inputs, Sequence<Double> weights, double bias,
            double target, double learningRate);
}
