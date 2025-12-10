package components.neuron;

import components.sequence.Sequence;

/**
 * Secondary interface.
 */
public interface Neuron extends NeuronKernel {

        /**
         * Performs a forward pass.
         *
         * @param inputs
         *                the input sequence
         * @return the result after sigmoid function.
         */
        double forwardPass(Sequence<Double> inputs);

        /**
         * Trains the neuron with given inputs, weights, bias, targetm and
         * leanring rate.
         *
         * @param inputs
         * @param target
         * @param learningRate
         * @return the new bias.
         * @updates weights
         */
        double train(Sequence<Double> inputs, double target,
                        double learningRate);
}
