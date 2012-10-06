/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga.exceptionHandlers;

import java.io.PrintStream;

import splice.ExceptionHandler;

/**
 * 
 * @author igor
 *
 */
public class ErrorStream implements ExceptionHandler {
	private PrintStream stream;
	
	public ErrorStream(PrintStream stream) {
		this.stream = stream;
	}
	
	public ErrorStream() {
		this(System.err);
	}

	@Override
	public void handle(Exception ex) {
		stream.println("Some errors have ocurred that prevented the execution");
		ex.printStackTrace(stream);
	}

}
