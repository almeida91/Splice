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

import splice.RandomUtil;
import splice.ga.genes.ListGene;

public class RandomOrderedCrossover<T> extends OrderedCrossover<T> {
    public RandomOrderedCrossover() {
        super(0, 0);
    }

    @Override
    public ListGene<T> doCrossover(ListGene<T> a, ListGene<T> b) {
        setBegin(RandomUtil.getRandom().nextInt(a.getSize()));
        setEnd(getBegin() + RandomUtil.getRandom().nextInt(a.getSize() - getBegin()));

        return super.doCrossover(a, b);
    }
}
