import java.util.Arrays;
import java.util.Random;

public class Interval {
	public class Job {
		Integer jobStart;
		Integer jobEnd;
	}
	
	public void findJobPeakInterval(Job[] jobs) {
		//Criando duas listas auxiliares(0(n)) pra fim e inicio
		int[] start = new int[jobs.length];
		int[] end = new int[jobs.length];
		for (int i = 0; i< jobs.length; i++) {
			start[i] = jobs[i].jobStart;
			end[i] = jobs[i].jobEnd;
		}
		//Ordena ambos os arrays de inicio e final com mergesort (O(n*log(n)))
		Arrays.sort(start);
		Arrays.sort(end);
		
	    int activeJobs = 1; 		// activeJobs é o numero de jobs na maquina em determinado momento
	    int maxJobs = 1; 			// maxJobs é o maior numero de jobs pelo qual se passou
	    int startTime = start[0];	// startTime é o momento onde se atingiu esse pico
	    int endTime = start[0];		// endTime é o momento onde se atingiu esse pico
	    
	    boolean peaked = true;
	    // Todos os eventos estão ordenados. Itera por eles e registra pico (O(n))
	    int i = 1, j = 0, n = start.length;
	    while (i < n && j < n) {
	        // Se o proximo evento for entrada
	        if (start[i] < end[j]) { // Empate computa saida primeiro. Intervalo aberto na saida. [i,j)
	            activeJobs++;
	            if (activeJobs > maxJobs) {
	                maxJobs = activeJobs;
	                startTime = start[i];
	                peaked = true;
	            }
	            i++;
	        }
	        else { // Se o proximo evento for saida
	            activeJobs--;
	            if (peaked) {
	            	endTime = end[j];
	            	peaked = false;
	            }
	            j++;
	        }
	    }
		System.out.println("Numero maximo de Jobs: " + maxJobs);
		System.out.println("Inicio em: " + startTime);
		System.out.println("Final em: " + endTime);
	}
	
	public static void main(String[] args) {
		
		Interval calc = new Interval();
		
		//criando lista de processos
		Job[] jobs = new Job[10];
		Random rand = new Random(1);
		for(int i=0; i < 10; i++) {
			int inicio = Math.abs(rand.nextInt()) % 50 + 1;
			int fim = Math.abs(rand.nextInt()) % 50 + 1 + inicio;
			Job job = calc.new Job();
			job.jobStart = inicio;
			job.jobEnd = fim;
			jobs[i] = job;
		}
		
		// realiza o calculo do melhor intervalo
		calc.findJobPeakInterval(jobs);
	}
	
}
