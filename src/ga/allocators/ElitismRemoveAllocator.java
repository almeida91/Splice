/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.allocators;

/**
 * The same logic of the elitism but removing the old ones that don't have the minimum fitness
 * @author igor
 *
 */
public class ElitismRemoveAllocator extends ElitismAllocator {
	private double mFitness;
	
	public ElitismRemoveAllocator(double rate, double minimumFitness) {
		super(rate);
		mFitness = minimumFitness;
	}

	@Override
	public void allocate() {
		getPopulation().sort();
		int n = (int) (getPopulation().getSize() * getRate());
		for (int i = 1; i < n; i++) {
			getNewPopulation().add(getPopulation().get(getPopulation().getSize() - i));
		}
		for (int i = 0, j = 0; i < getNewPopulation().size() & j < n; i++) {
			if (getNewPopulation().get(i).getFitness() < mFitness) {
				getNewPopulation().remove(i);
				j++;
			}
		}
		setPopulation(getNewPopulation());
	}

}
