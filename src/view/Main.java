package view;

import java.util.concurrent.Semaphore;

import controller.Formula;

public class Main {

	public static void main(String[] args) {
		int permissoes = 5;
		int soum=1;
		int idEscuderia=0;
		Semaphore semaforo1 = new Semaphore(permissoes);
		Semaphore semaforo2 = new Semaphore(soum);
		for (int idCarro = 0; idCarro < 14; idCarro++) {
			if (idCarro%2==0) {
				idEscuderia++;
			}
			Thread tF1 = new Formula(idCarro,idEscuderia,semaforo1,semaforo2);
			tF1.start();
		}

	}

}
