package hr.java.jule.test;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class MyFitnessFunction extends FitnessFunction {
	
	private String notes;
	
	public MyFitnessFunction(String stringNotes) {
		// TODO Auto-generated constructor stub
		this.notes=stringNotes;
	}
	
	private int countErrors(IChromosome a_subject) {
		int errors=0;
		for(int i=0;i<this.notes.length();i++) {
			if(!(Character.toString(notes.charAt(i)).equals(a_subject.getGene(i).getAllele()))) {
				errors++;
			}
		}
		return errors;
	}

	@Override
	protected double evaluate(IChromosome a_subject) {
		
		return 1.0/(countErrors(a_subject)+1);
	}

}
