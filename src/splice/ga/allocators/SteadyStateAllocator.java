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
 * Allocates the new chromosome population using the steady state logic
 * @author igor
 *
 */
public class SteadyStateAllocator extends PopulationAllocator {
	public double rate;
	
	public SteadyStateAllocator(double rate) {
		this.rate = rate;
	}

	@Override
	public void allocate() {
		getPopulation().sort();
		sortNewPopulation();
		
		int n = (int)(getPopulation().getSize() * rate);
		
		for (int i = 0; i < n; i++) {
			getPopulation().getChromosomes().set(i, getNewPopulation().get((getNewPopulation().size() - 1) - i));
		}
	}
	
	@Override
	public boolean complete() {
		return false;
	}

	@Override
	public void initialize() {
		
	}
}
