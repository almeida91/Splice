/*
 * Copyright (C) 2012 Igor de Almeida
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
 * OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package splice.ga;

@SuppressWarnings("rawtypes")
public abstract class Chromosome<T extends Gene> extends BasicChromosome implements GeneContainer<T> {
	private T[] genes;
	private Crossover<T> crossover;
	private Mutator<T> mutator;
	
	public T get(int i) {
		return genes[i];
	}
	
	public void setCrossover(Crossover<T> crossover) {
		this.crossover = crossover;
	}
	
	public void setMutator(Mutator<T> mutator) {
		this.mutator = mutator;
	}

	public void setGenes(T[] genes) {
		this.genes = genes;
	}

    public T[] getGenes() {
        return genes;
    }

    @Override
	protected void mutate() {
        for (T gene : genes) {
            mutator.mutate(gene);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public BasicChromosome crossover(BasicChromosome chromosome) {
        Chromosome newChromosome = (Chromosome<T>)(this.clone());
        Chromosome other = (Chromosome)chromosome;
		
		newChromosome.genes = new Gene[genes.length];
		
		for (int i = 0; i < genes.length; i++) {
			newChromosome.genes[i] = this.crossover.doCrossover(this.genes[i], (T)(other.get(i)));
		}
		
		return newChromosome;
	}

	@Override
	public String toString() {
		String s = "[";
		for (Gene g : genes)
			s += g + ", ";
		s += "]";
		return s;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
        if (!(obj instanceof Chromosome))
            return false;

		Chromosome<T> o = (Chromosome<T>)obj;
		
		for (int i = 0; i < genes.length; i++) {
			if (!genes[i].equals(o.genes[i]))
				return false;
		}
		
		return true;
	}

    @Override
    public BasicChromosome clone() {
        Chromosome<T> c = (Chromosome<T>)(super.clone());
        c.setMutator(this.mutator);
        c.setCrossover(this.crossover);
        c.resetFitness();
        return c;
    }
}
