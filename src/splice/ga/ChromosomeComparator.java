/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga;

import java.util.Comparator;

public class ChromosomeComparator implements Comparator<BasicChromosome> {
	private double fitness;
	
	public ChromosomeComparator(double fitness) {
		this.fitness = fitness;
	}
	
	@Override
	public int compare(BasicChromosome o1, BasicChromosome o2) {
		return o1.compareTo(o2);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof BasicChromosome))
			return false;
		return ((BasicChromosome) obj).getFitness() == fitness;
	}
}
