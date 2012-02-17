/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package ga.parallel;

import ga.Population;

public class CalculateFitnessWorker extends Thread {
	private AtomicDouble sum;
	private Population population;
	private int begin, end;
	
	public CalculateFitnessWorker(Population population, int begin, int end, AtomicDouble sum) {
		this.population = population;
		this.begin = begin;
		this.end = end;
		this.sum = sum;
	}
	
	@Override
	public void run() {
		for (int i = begin; i < end; i++) {
			sum.add(population.get(i).calculateFitness());
		}
	}
	
	public double getSum() {
		return sum.getValue();
	}
}
