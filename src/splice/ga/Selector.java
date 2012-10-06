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

import java.util.Random;

import splice.InitializeComponent;
import splice.ProblemType;
import splice.ProblemTypeComponent;
import splice.RandomComponent;

/**
 * Selects chromossome's candidates for crossover
 * 
 * @author igor
 * 
 */
public abstract class Selector extends PopulationManipulator implements RandomComponent, ProblemTypeComponent, InitializeComponent {
	private Random random;
	private ProblemType problemType;
	
	/**
	 * The selection logic
	 * @return a chromosome for crossover
	 */
	public abstract BasicChromosome getChromosome();
	public abstract void beforeGeneration();
	
	public Random getRandom() {
		return random;
	}
	
	public void setRandom(Random random) {
		this.random = random;
	}
	
	public ProblemType getProblemType() {
		return problemType;
	}
	
	public void setProblemType(ProblemType problemType) {
		this.problemType = problemType;
	}
}
