/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.crossovers;

import org.junit.Test;
import splice.ga.genes.ListGene;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 05/08/13
 * Time: 23:22
 */
public class OrderedCrossoverTest {
    @Test
    public void testDoCrossover() throws Exception {
        List<Integer> a, b;

        /*
         * Input sets:
         * A = 4 8 7 3 6 5 1 10 9 2
         * B = 3 1 4 2 7 9 10 8 6 5
         */
        a = new ArrayList<Integer>();
        b = new ArrayList<Integer>();

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

        ListGene<Integer> ga, gb;
        ga = new ListGene<Integer>(a);
        gb = new ListGene<Integer>(b);

        OrderedCrossover<Integer> c = new OrderedCrossover<Integer>(3, 6);

        /*
         * Output sets:
         * A = 4 8 6 2 7 9 1 10 5 3
         * B = 2 1 4 3 6 5 10 8 7 9
         */
        a = new ArrayList<Integer>();
        b = new ArrayList<Integer>();

        a.add(3);
        a.add(6);
        a.add(5);
        a.add(2);
        a.add(7);
        a.add(9);
        a.add(1);
        a.add(10);
        a.add(4);
        a.add(8);

        b.add(2);
        b.add(7);
        b.add(9);
        b.add(3);
        b.add(6);
        b.add(5);
        b.add(10);
        b.add(8);
        b.add(1);
        b.add(4);

        // for some reason the return order is inverted, but it doesn't affects the final result
        assertEquals(b, c.doCrossover(ga, gb).getValue());
        assertEquals(a, c.doCrossover(ga, gb).getValue());

        // we run twice as the crossover logic is called just once for a pair
        assertEquals(b, c.doCrossover(ga, gb).getValue());
        assertEquals(a, c.doCrossover(ga, gb).getValue());
    }
}
