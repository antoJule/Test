package hr.java.jule.test;

import java.util.Scanner;

import org.jfugue.player.Player;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.StringGene;

public class Main {
	
	public static final int VELICINA_POPULACIJE=500;
	
	public static Configuration algorithmSetup(String notes) throws InvalidConfigurationException {
		
		Configuration conf= new DefaultConfiguration();
		StringGene[] sampleGenes= new StringGene[notes.length()];
		for(int i=0;i<notes.length();i++) {
			sampleGenes[i]=new StringGene(conf, 1, 1,"CDEFGAH ");
		}
		
		Chromosome sampleChromosome= new Chromosome(conf, sampleGenes);
		conf.setSampleChromosome(sampleChromosome);
		conf.setPopulationSize(VELICINA_POPULACIJE);
		
		conf.setFitnessFunction(new MyFitnessFunction(notes));
		return conf;
	}
	

	public static void main(String[] args) throws InvalidConfigurationException {
		Scanner scanner = new Scanner(System.in);
		String note;
		
		System.out.println("Upisite note:");
		note=scanner.nextLine();
		
		Configuration algorithmSetup=algorithmSetup(note);
		Genotype population=Genotype.randomInitialGenotype(algorithmSetup);
		for(int i=0;i<10;i++) {
			System.out.println(population.getFittestChromosome());
			population.evolve();
		}
		
	}
}
