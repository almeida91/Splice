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

import splice.ga.Crossover;
import splice.ga.genes.ListGene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ordered Crossover (OX) differing from PMX it considers the order of the values and not directly point-to-point.
 * It makes a two-point crossover, so we have three segments.
 * The middle segment comes from the second gene while the outer pair comes from the first.
 */
public class OrderedCrossover<T> implements Crossover<ListGene<T>> {
    private int begin;
    private int end;
    private List<T> buff = null;
    private List<T> buff2;

    /**
     * This constructor requires you to give the middle segment dimensions.
     * If you want to use a random use the random derivative.
     *
     * @param begin where the middle segment begins
     * @param end segment's final position
     *
     * @see RandomOrderedCrossover
     */
    public OrderedCrossover(int begin, int end) {
        assert begin < end;

        this.begin = begin;
        this.end = end;
    }

    protected int getBegin() {
        return begin;
    }

    protected int getEnd() {
        return end;
    }

    protected void setBegin(int begin) {
        this.begin = begin;
    }

    protected void setEnd(int end) {
        this.end = end;
    }

    @Override
    public ListGene<T> doCrossover(ListGene<T> a, ListGene<T> b) {
        ListGene<T> c = (ListGene<T>) a.clone();

        if (buff != null) {
            c.setValue(buff);
            buff = null;
        }
        else {
            buff2 = new ArrayList<T>();
            buff = new ArrayList<T>();

            buff2.addAll(a.getValue().subList(getBegin(), getEnd()));
            buff.addAll(b.getValue().subList(getBegin(), getEnd()));

            int i = getEnd();
            do {
                if (!buff2.contains(b.getValue().get(i)))
                    buff2.add(b.getValue().get(i));

                if (!buff.contains(a.getValue().get(i)))
                    buff.add(a.getValue().get(i));

                i = (i + 1) % a.getValue().size();
            }  while (i != getEnd());

            Collections.rotate(buff2, getBegin());
            Collections.rotate(buff, getBegin());

            c.setValue(buff2);
        }

        return c;
    }
}
