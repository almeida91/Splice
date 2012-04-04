/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.stopConditions;

import splice.ga.Population;
import splice.ga.StopCondition;

/**
 * Stops the execution when a number of generations is achieved
 * @author igor
 *
 */
public class Generations implements StopCondition {
	private int generations;

	public Generations(int generations) {
		this.generations = generations;
	}

	@Override
	public boolean stop(int generation) {
		return generation >= generations;
	}

	public int getGenerations() {
		return generations;
	}

	@Override
	public void setPopulation(Population population) { }

	@Override
	public Population getPopulation() {
		return null;
	}
}
