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
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static final int VELICINA_POPULACIJE=25;
	
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
	
	public static String getNotes() {
		System.out.println("Upisi trazene note:");
		String note=scanner.nextLine();
		return note;
	}
	
	
	
	public static void main(String[] args) throws InvalidConfigurationException {
		String note=getNotes();
		
		Configuration algorithmSetup=algorithmSetup(note);
		Genotype population=Genotype.randomInitialGenotype(algorithmSetup);
		int brojac=0;
		while(population.getFittestChromosome().getFitnessValue()<1.0) {
			population.evolve();
			brojac++;
			if(brojac%50==0) {
				System.out.println(population.getFittestChromosome());
				System.out.println(population.getFittestChromosome().getFitnessValue());
			}
		}
		
		System.out.println(population.getFittestChromosome());
		System.out.println(brojac);
		
		
		
	}
}
