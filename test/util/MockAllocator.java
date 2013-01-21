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

import splice.ga.PopulationAllocator;

/**
 * As the other classes in this package it is just a mock-up so an abstract class may be tested
 * @author igor
 *
 */
public class MockAllocator extends PopulationAllocator {
    boolean initialized = false;

	@Override
	public void initialize() { }

	@Override
	public void allocate() { }

	@Override
	public boolean complete() {
		return false;
	}

    public boolean isInitialized() {
        return initialized;
    }
}
