package splice.ga.parallel;

import splice.ExceptionHandler;

class AppendDataWorker extends Thread {
	private ExceptionHandler handler;
	private int generation;
	private AsyncDataManipulator dataManipulator;
	
	public AppendDataWorker(int generation, ExceptionHandler handler, AsyncDataManipulator dataManipulator) {
		this.handler = handler;
		this.generation = generation;
		this.dataManipulator = dataManipulator;
	}
	
	@Override
	public void run() {
		try {
			dataManipulator.write(generation);
		}
		catch (Exception e) {
			handler.handle(e);
		}
	}
}
