/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.allocators;

import splice.ga.PopulationAllocator;

/**
 * Allocates the new set base on the elistism concept
 * @author igor
 *
 */
public class ElitismAllocator extends PopulationAllocator {
	private double rate;
	
	/**
	 * 
	 * @param rate the percentage of the old population to be kept
	 */
	public ElitismAllocator(double rate) {
		super();
		this.rate = rate;
	}

	@Override
	public void allocate() {
		getPopulation().sort();
		int n = (int)(getPopulation().getSize() * rate);
		getNewPopulation().addAll(getPopulation().getChromosomes().subList(getPopulation().getSize() - n, getPopulation().getSize()));
		setPopulation(getNewPopulation());
	}

	public double getRate() {
		return rate;
	}


}
