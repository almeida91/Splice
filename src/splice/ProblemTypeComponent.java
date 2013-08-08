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

/**
 * Defines a component that requires to know the type of the optimization.
 *
 * @author igor
 */
public interface ProblemTypeComponent {
    /**
     * This method is usually used by the algorithm main class, as the components will
     * get its references by the main class.
     *
     * @param type a reference to the {@link ProblemType} defined by the algorithm.
     */
	public void setProblemType(ProblemType type);

    /**
     * When you have to set the type of the optimization use this method to get the
     * reference to a {@link ProblemType} and use the method {@link splice.ProblemType#setMaximization()}
     * or {@link splice.ProblemType#setMinimization()} to set the type.
     * As there is many objects that must keep the same reference to the object {@link #setProblemType(ProblemType)}
     * should only be used by the algorithm code.
     *
     * @return a reference to the shared {@link ProblemType} object.
     */
	public ProblemType getProblemType();
}
