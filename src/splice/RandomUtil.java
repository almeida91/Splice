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

import java.util.Random;

/**
 * This is a factory that produces new {@link Random} every time it is required.
 * With this you can set the seed, sou it is possible to reproduce the exact same
 * results in a given execution.
 *
 * @author igor
 */
public class RandomUtil {
    private static Random iRandom = null;

    /**
     * Holds the single {@link Random} instance that will be used to generate new objects
     * in {@link #getRandom()} method.
     * If none has been set a random seed will be created.
     * Beware with this as the object won't be thread safe.
     *
     * @return a non-threadsafe {@link Random}.
     */
    public static Random getInternalRandom() {
        if (iRandom == null)
            iRandom = new Random();

        return iRandom;
    }

    /**
     * This method sets the internal variable that holds the original {@link Random} object.
     * When using this method it is recommended to set the seed, otherwise don't worry as
     * the factory will generate its own.
     *
     * @param internalRandom a {@link Random} instance.
     */
    public static void setInternalRandom(Random internalRandom) {
        iRandom = internalRandom;
    }

    /**
     * A new instance that will have a predefined seed.
     *
     * @return a {@link Random} instance
     */
    public synchronized static Random getRandom() {
        return new Random(getInternalRandom().nextLong());
    }
}
