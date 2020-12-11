package m9_uf2act1_maria;

import java.util.*;
import java.util.concurrent.*;

public class M9_UF2act1_maria {
	static class Suma implements Callable<Integer> {
		private int operador1;
		private int operador2;
		
		public Suma(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
			}
			
		@Override
		public Integer call() throws Exception {
			return operador1 + operador2;
			}
		}

	public static void main(String[] args) throws
		InterruptedException, ExecutionException {
			ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(25);
			List<Suma> llistaTasques= new ArrayList<Suma>();
			for (int i = 0; i < 5; i++) {
				Suma calcula = new Suma((int)(Math.random()+5), (int)(Math.random()+5));
				llistaTasques.add(calcula);
				}
			List <Future<Integer>> llistaResultats;
			llistaResultats = executor.invokeAll(llistaTasques);
			
			executor.shutdown();
			
			for (int i = 0; i < llistaResultats.size(); i++) {
				Future<Integer> resultat = llistaResultats.get(i);
				try {
					System.out.println("Resultat tasca "+i+ " és:" +
					resultat.get());
				}
				catch (InterruptedException | ExecutionException e)
					{
					}
				}
		}
	}
