package splice.ga.parallel;

import splice.ga.DataManipulator;

public abstract class AsyncDataManipulator extends DataManipulator {
	synchronized void write(int g) throws Exception {
		engineAppendData(g);
	}
	
	public void appendData(int generation) {
		Thread worker = new AppendDataWorker(generation, getHandler(), this);
		worker.start();
	}
}
