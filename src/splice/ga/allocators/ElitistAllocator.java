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
 * Allocates the new set base on the elitist concept
 * @author igor
 *
 */
public class ElitistAllocator extends PopulationAllocator {
	private double rate;
	private int n;
	
	/**
	 * 
	 * @param rate the percentage of the old population to be kept
	 */
	public ElitistAllocator(double rate) {
		this.rate = rate;
	}

	@Override
	public void allocate() {
		getPopulation().sort();
		
		if (getProblemType().isMaximization()) {
			for (int i = 1; i <= n; i++) {
				append(getPopulation().get(getPopulation().getSize() - i));
			}
		}
		else {
			for (int i = 0; i < n; i++) {
				append(getPopulation().get(i)); 
			}
		}
		
		setPopulation(getNewPopulation());
	}

	public double getRate() {
		return rate;
	}
	
	@Override
	public boolean complete() {
		return bufferSize() >= getPopulation().getSize() - n;
	}
	
	@Override
	public void initialize() {
		n = (int)(getPopulation().getSize() * rate);
	}
}
