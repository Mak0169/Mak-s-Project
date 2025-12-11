package components.neuron;

public class Neuron1Test extends NeuronTest {

    @Override
    protected final Neuron constructorTest(int n) {
        return new Neuron1(n);
    }

    @Override
    protected final Neuron constructorRef(int n) {
        return new Neuron1(n);
    }
}
