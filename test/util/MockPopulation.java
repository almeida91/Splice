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

import splice.ga.Population;

public class MockPopulation extends Population {
	double average;
    int size;
	
	public MockPopulation(double average, int size) {
		this.average = average;
        this.size = size;
		setSize(size);
	}
	
	public MockPopulation(double average) {
		this(average, 0);
	}

    @Override
    public double getFitnessAverage() {
        return average;
    }
	
	@Override
	public void initialize() {
		if (getFactory() == null)
			setFactory(new MockBasicChromosomeFactory(average));
		
		super.initialize();
	}

    @Override
    public int getSize() {
        return size;
    }
}
