/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.genes;

import java.util.List;

import splice.ga.Gene;

/**
 * 
 * @author igor
 *
 * @param <T>
 */
public class ListGene<T> extends Gene<List<T>> {
	public ListGene(List<T> value) {
		super(value);
	}
	
	public T get(int i) {
		return getValue().get(i);
	}
	
	public void set(int i, T value) {
		getValue().set(i, value);
	}
	
	public int getSize() {
		return getValue().size();
	}

    @Override
    public String toString() {
        return getValue().toString();
    }
}
