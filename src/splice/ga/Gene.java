/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga;

import splice.InitializeComponent;

/**
 * Base class for a single chromosome information
 * @author igor
 *
 * @param <T> the type of information value
 */
public abstract class Gene<T> implements InitializeComponent, Cloneable {
	private T value;

	public void initialize() { }
	
	public Gene(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
        if (!(obj instanceof Gene))
            return false;
		Gene<T> o = (Gene<T>)obj;
		return value.equals(o.value);
	}

    @Override
    public String toString() {
        return value.toString();
    }

    public Gene<T> clone() {
        try {
            return (Gene<T>) (super.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
