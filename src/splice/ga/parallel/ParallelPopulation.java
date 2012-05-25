/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS 
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 */
package splice.ga.parallel;

import splice.ga.Population;

public class ParallelPopulation extends Population {
	private int nThreads;

	public ParallelPopulation(int numberThreads) {
		nThreads = numberThreads;
	}

	@Override
	public void calculateFitnessSum() throws Exception {
		AtomicDouble sum = new AtomicDouble(0);
		int i, step, begin;
		step = getSize() / nThreads;
		Thread[] worker = new Thread[nThreads];
		
		for (i = 0, begin = 0; i < nThreads; i++, begin += step) {
			worker[i] = new CalculateFitnessWorker(this, begin, begin+step, sum);
			worker[i].start();
		}
		
		for (i = 0; i < nThreads; i++) {
			worker[i].join();
		}
		
		fitnessAverage = sum.getValue() / getSize();
	}
}
