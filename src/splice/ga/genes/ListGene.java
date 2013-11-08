/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.genes;

import java.util.*;

import splice.RandomUtil;
import splice.ga.Gene;

/**
 * 
 * @author igor
 *
 * @param <T>
 */
public class ListGene<T> extends Gene<List<T>> {
    private Set<T> set;
    private int itemsFromSet;
    private boolean unique = true;

	public ListGene(List<T> value) {
		super(value);
	}

    public ListGene(Set<T> set, int itemsFromSet) {
        super(null);
        this.set = set;
        this.itemsFromSet = itemsFromSet;
    }

    public ListGene(Set<T> set) {
        this(set, set.size());
    }

    public T get(int i) {
		return getValue().get(i);
	}
	
	public void set(int i, T value) {
		getValue().set(i, value);
	}
	
	public int getSize() {
		return getValue().size();
	}

    public boolean hasSet() {
        return set != null;
    }

    @Override
    public String toString() {
        return getValue().toString();
    }

    @Override
    public void initialize() {
        if (hasSet()) {
            List<T> listFromSet = new ArrayList<>(set.size());
            listFromSet.addAll(set);

            if (unique) {
                assert itemsFromSet <= set.size();

                Collections.shuffle(listFromSet, RandomUtil.getRandom());
                setValue(listFromSet);

                if (itemsFromSet < set.size()) {
                    for (int i = 0; i < set.size() - itemsFromSet; i++) {
                        getValue().remove(i);
                    }
                }
            }
            else {
                Random random = RandomUtil.getRandom();

                for (int i = 0; i < itemsFromSet; i++) {

                }
            }
        }
    }
}
