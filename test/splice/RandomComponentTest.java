/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice;

import static org.junit.Assert.assertNotNull;

import java.util.Random;

/**
 * @author igor
 */
public class RandomComponentTest {
    RandomComponent randomComponent;

    public RandomComponentTest(RandomComponent randomComponent) {
        this.randomComponent = randomComponent;
    }

    public void testSetRandom() {
        randomComponent.setRandom(new Random());
        assertNotNull(randomComponent.getRandom());
    }

    public static void doTest(RandomComponent randomComponent) {
        (new RandomComponentTest(randomComponent)).testSetRandom();
    }
}
