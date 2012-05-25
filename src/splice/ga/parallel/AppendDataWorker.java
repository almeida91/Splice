package splice.ga.parallel;

import splice.ga.ExceptionHandler;

class AppendDataWorker extends Thread {
	public ExceptionHandler handler;
	public int generation;
	public AsyncDataManipulator dataManipulator;
	
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
