package hr.java.jule.test;

import java.util.Scanner;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.StringGene;

public class Main {
	
	public static final int VELICINA_POPULACIJE=500;
	
	public static void algorithmSetup(int brojZnakova) throws InvalidConfigurationException {
		
		Configuration conf= new DefaultConfiguration();
		StringGene[] sampleGenes= new StringGene[brojZnakova];
		for(int i=0;i<brojZnakova;i++) {
			sampleGenes[i]=new StringGene(conf, 1, 1);
		}
		
		Chromosome sampleChromosome= new Chromosome(conf, sampleGenes);
		conf.setSampleChromosome(sampleChromosome);
		conf.setPopulationSize(VELICINA_POPULACIJE);
		
		conf.setFitnessFunction(new MyFitnessFunction());
	}
	

	public static void main(String[] args) throws InvalidConfigurationException {
		
		Scanner scanner = new Scanner(System.in);
		String note;
		
		System.out.println("Upisite note:");
		note=scanner.nextLine();
		
		algorithmSetup(note.length());
		
	}
}
