/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package util;

import splice.ga.BasicChromosome;

/**
 * Simple chromosome used to run the tests
 * @author igor almeida
 *
 */
public class MockBasicChromosome extends BasicChromosome {
	double value;
    boolean mutated;
	
	public MockBasicChromosome(double value) {
		this.value = value;
	}
	
	@Override
	protected double fitness() {
		return value;
	}

	@Override
	protected void mutate() {
        mutated = true;
	}

	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
		return null;
	}

    public boolean isMutated() {
        return mutated;
    }
}
