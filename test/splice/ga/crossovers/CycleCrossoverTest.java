package splice.ga.crossovers;

import org.junit.Test;
import splice.ga.genes.ListGene;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CycleCrossoverTest {
    @Test
    public void testDoCrossover() throws Exception {
        List<Integer> a, b;

        a = new ArrayList<>();
        b = new ArrayList<>();

        a.add(8);
        a.add(4);
        a.add(7);
        a.add(3);
        a.add(6);
        a.add(2);
        a.add(5);
        a.add(1);
        a.add(9);
        a.add(0);

        b.add(0);
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(6);
        b.add(7);
        b.add(8);
        b.add(9);

        ListGene<Integer> aa, bb;
        aa = new ListGene<>(a);
        bb = new ListGene<>(b);
        CycleCrossover<Integer> cross = new CycleCrossover<>(2);

        a = new ArrayList<>();
        b = new ArrayList<>();

        /*
         * [8, 1, 2, 3, 4, 5, 6, 7, 9, 0]
         * [0, 4, 7, 3, 6, 2, 5, 1, 8, 9]
         */

        a.add(8);
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(9);
        a.add(0);

        b.add(0);
        b.add(4);
        b.add(7);
        b.add(3);
        b.add(6);
        b.add(2);
        b.add(5);
        b.add(1);
        b.add(8);
        b.add(9);

        assertEquals(a, cross.doCrossover(aa, bb).getValue());
        assertEquals(b, cross.doCrossover(bb, aa).getValue());

        assertEquals(a, cross.doCrossover(aa, bb).getValue());
        assertEquals(b, cross.doCrossover(bb, aa).getValue());
    }
}
