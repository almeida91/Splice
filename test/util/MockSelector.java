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
import splice.ga.Selector;

/**
 * @author igor
 */
public class MockSelector extends Selector {
    boolean initialized = false;

    @Override
    public BasicChromosome getChromosome() {
        return new MockBasicChromosome(0.5);
    }

    @Override
    public void beforeGeneration() { }

    @Override
    public void initialize() {
        initialized = true;
    }

    public boolean isInitialized() {
        return initialized;
    }
}
