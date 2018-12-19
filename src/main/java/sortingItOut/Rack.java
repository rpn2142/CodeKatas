package sortingItOut;

import java.util.BitSet;
import java.util.List;
import java.util.stream.Collectors;

public class Rack {

    BitSet selectedBalls;

    public Rack() {
        selectedBalls = new BitSet(60);
    }

    public List<Integer> getSelectedBallsInSortedOrder() {
        return selectedBalls.stream()
                .boxed()
                .collect(Collectors.toList());
    }

    public void selectBall(int index) {
        selectedBalls.set(index);
    }
}
