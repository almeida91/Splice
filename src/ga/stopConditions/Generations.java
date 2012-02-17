/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.stopConditions;

import ga.GenerationData;
import ga.StopCondition;

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
	public boolean stop(GenerationData data) {
		return data.getGeneration() >= generations;
	}

	public int getGenerations() {
		return generations;
	}
}
