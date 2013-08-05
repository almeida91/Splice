/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package zeros;

import splice.ga.BasicChromosome;
import splice.ga.GeneticAlgorithm;
import splice.ga.allocators.ReplaceAllocator;
import splice.ga.selectors.TournamentSelector;

public class RunZeros {
    public static void main(String[] args) throws Exception {
        GeneticAlgorithm ga = new GeneticAlgorithm(
            new ZerosChromosomeFactory(10, 10),
            new ReplaceAllocator(),
            new TournamentSelector(3)
        );

        ga.execute();
    }
}
