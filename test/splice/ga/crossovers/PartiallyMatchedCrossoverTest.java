package splice.ga.crossovers;

import org.junit.Test;
import splice.ga.genes.ListGene;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 27/09/13
 * Time: 12:15
 * To change this template use File | Settings | File Templates.
 */
public class PartiallyMatchedCrossoverTest {
    @Test
    public void testDoCrossover() throws Exception {
        List<Integer> a, b;

        a = new ArrayList<>();
        b = new ArrayList<>();

        a.add(4);
        a.add(8);
        a.add(7);
        a.add(3);
        a.add(6);
        a.add(5);
        a.add(1);
        a.add(10);
        a.add(9);
        a.add(2);

        b.add(3);
        b.add(1);
        b.add(4);
        b.add(2);
        b.add(7);
        b.add(9);
        b.add(10);
        b.add(8);
        b.add(6);
        b.add(5);

        ListGene<Integer> aa, bb;
        aa = new ListGene<Integer>(a);
        bb = new ListGene<Integer>(b);
        PartiallyMatchedCrossover<Integer> cross = new PartiallyMatchedCrossover<>(3, 6);

        /*
         * [4, 8, 6, 2, 7, 9, 1, 10, 5, 3]
         * [2, 1, 4, 3, 6, 5, 10, 8, 7, 9]
         */

        a = new ArrayList<>();
        b = new ArrayList<>();

        a.add(4);
        a.add(8);
        a.add(6);
        a.add(2);
        a.add(7);
        a.add(9);
        a.add(1);
        a.add(10);
        a.add(5);
        a.add(3);

        b.add(2);
        b.add(1);
        b.add(4);
        b.add(3);
        b.add(6);
        b.add(5);
        b.add(10);
        b.add(8);
        b.add(7);
        b.add(9);

        assertEquals(a, cross.doCrossover(aa, bb).getValue());
        assertEquals(b, cross.doCrossover(bb, aa).getValue());
    }
}
