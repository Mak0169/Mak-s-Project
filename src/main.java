import components.sequence.Sequence;
import components.sequence.Sequence1L;

public class main {
    public static void main(String[] args) {
        Sequence<Double> inputs = new Sequence1L<>();
        Sequence<Double> weights = new Sequence1L<>();

        final double n1 = 0.5;
        final double n2 = 0.3;
        final double n3 = 0.2;
        final double w1 = 0.4;
        final double w2 = 0.6;
        final double w3 = 0.2;

        inputs.add(inputs.length(), n1);
        inputs.add(inputs.length(), n2);
        inputs.add(inputs.length(), n3);

        weights.add(weights.length(), w1);
        weights.add(weights.length(), w2);
        weights.add(weights.length(), w3);
    }
}
