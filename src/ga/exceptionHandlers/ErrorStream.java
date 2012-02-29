package ga.exceptionHandlers;

import java.io.PrintStream;

import ga.ExceptionHandler;

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
