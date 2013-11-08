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

import splice.ga.GeneticAlgorithmStopCondition;

public class MinimumBestFitness extends GeneticAlgorithmStopCondition {
	private double minimum;

	public MinimumBestFitness(double minimum) {
		this.minimum = minimum;
	}
	
	@Override
	public boolean stop(int generation) {
		return getPopulation().getMaximum().getFitness() >= minimum;
	}

    @Override
    public boolean isCommonUsage() {
        return false;
    }
}
