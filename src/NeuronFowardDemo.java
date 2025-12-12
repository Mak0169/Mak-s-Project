import components.neuron.Neuron;
import components.neuron.Neuron1;
import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * A simple demo of computing the forward pass using neuron component.
 */
public final class NeuronFowardDemo {
    /**
     * Private constructor to prevent instantiation.
     */
    private NeuronFowardDemo() {
    }

    /**
     * Main method to demo the forward pass using neuron component.
     *
     * @param args
     */
    public static void main(String[] args) {
        Neuron n = new Neuron1(3);
        n.setWeights(0, 0.5);
        n.setWeights(1, -1.0);
        n.setWeights(2, 2.0);
        n.setBias(0.1);

        Sequence<Double> x = new Sequence1L<>();
        x.add(0, 1.0);
        x.add(1, 2.0);
        x.add(2, -1.0);

        double output = n.forwardPass(x);
        double expected = n.computeWeightedSum(x);

        System.out.printf("Forward Pass Output: %.4f%n", output);
        System.out.printf("Expected Weighted Sum: %.4f%n", expected);
    }
}
