package components.neuron;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.sequence.Sequence;
import components.sequence.Sequence1L;

/**
 * Abstract test class for Neuron.
 */
public abstract class NeuronTest {

    /**
     * Constructs and returns a Neuron of the given size.
     *
     * @param n
     * @return Neuron of size n
     */
    protected abstract Neuron constructorTest(int n);

    /**
     * Constructs and returns a reference Neuron of the given size.
     *
     * @param n
     * @return reference Neuron of size n
     */
    protected abstract Neuron constructorRef(int n);

    /**
     * Constructs and returns a sequence of the given values.
     *
     * @param values
     * @return Sequence of given values
     */
    protected Sequence<Double> seq(Double[] values) {
        Sequence<Double> s = new Sequence1L<Double>();
        for (double v : values) {
            s.add(s.length(), v);
        }
        return s;
    }

    /**
     * Test constructor and size method.
     */
    @Test
    public void testConstructorSize() {
        final int size = 3;
        Neuron n = this.constructorTest(size);
        assertEquals(size, n.size());
    }

    /**
     * Test constructor and size method with zero size.
     */
    @Test
    public void testConstructorSizeZero() {
        final int size = 0;
        Neuron n = this.constructorTest(size);
        assertEquals(size, n.size());
    }

    /**
     * Test setWeights and weight methods.
     */
    @Test
    public void testSetGetWeight() {
        final double val = 0.5;
        final double val2 = -1.5;
        Neuron n = this.constructorTest(2);
        n.setWeights(0, val);
        n.setWeights(1, val2);

        assertEquals(val, n.weight(0), 0.0);
        assertEquals(val2, n.weight(1), 0.0);
    }

    /**
     * Test computeWeightedSum method.
     */
    @Test
    public void testWeightedSumCorrect() {
        final double val = 0.5;
        final double val2 = 1.0;
        final double val3 = 0.2;
        final double val4 = 3.0;
        final double val5 = 4.2;
        Neuron n = this.constructorTest(2);
        n.setWeights(0, val);
        n.setWeights(1, val2);
        n.setBias(val3);
        Sequence<Double> x = this.seq(new Double[] { 2.0, val4 });
        assertEquals(val5, n.computeWeightedSum(x), 0.0);
    }

    /**
     * Test forwardPass method.
     */
    @Test
    public void testSigmoidMatchesRef() {
        final double val = 0.5;
        final double val2 = 1.0;
        final double val3 = 0.2;
        final double val4 = 3.0;
        Neuron n = this.constructorTest(2);
        Neuron ref = this.constructorRef(2);
        n.setWeights(0, val);
        n.setWeights(1, val2);
        n.setBias(val3);
        ref.setWeights(0, val);
        ref.setWeights(1, val2);
        ref.setBias(val3);
        Sequence<Double> x = this.seq(new Double[] { 2.0, val4 });
        assertEquals(ref.forwardPass(x), n.forwardPass(x), 0.0);
    }

    /**
     * Test setBias and bias methods.
     */
    @Test
    public void testSetAndGetBias() {
        final double val = 0.5;
        Neuron n = this.constructorTest(2);
        n.setBias(val);
        assertEquals(val, n.bias(), 0.0);
    }

    /**
     * Test forwardPass method against reference.
     */
    @Test
    public void testForwardPassMatchesRef() {
        final double val = 0.5;
        final double val2 = 1.0;
        final double val3 = 0.2;
        final double val4 = 3.0;
        Neuron n = this.constructorTest(2);
        Neuron ref = this.constructorRef(2);
        n.setWeights(0, val);
        n.setWeights(1, val2);
        n.setBias(val3);
        ref.setWeights(0, val);
        ref.setWeights(1, val2);
        ref.setBias(val3);
        Sequence<Double> x = this.seq(new Double[] { 2.0, val4 });
        assertEquals(ref.forwardPass(x), n.forwardPass(x), 0.0);
    }

    /**
     * Test forwardPass method against reference with zero input.
     */
    @Test
    public void testForwardPassMatchesRefZero() {
        final double val = 0.5;
        final double val2 = 1.0;
        final double val3 = 0.2;
        final double val4 = 3.0;
        Neuron n = this.constructorTest(2);
        Neuron ref = this.constructorRef(2);
        n.setWeights(0, val);
        n.setWeights(1, val2);
        n.setBias(val3);
        ref.setWeights(0, val);
        ref.setWeights(1, val2);
        ref.setBias(val3);
        Sequence<Double> x = this.seq(new Double[] { 0.0, 0.0 });
        assertEquals(ref.forwardPass(x), n.forwardPass(x), 0.0);
    }
}
