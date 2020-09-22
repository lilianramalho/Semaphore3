package controller;

import java.util.concurrent.Semaphore;

public class Formula extends Thread {
	private int idCarro;
	private int idEscuderia;
	private Semaphore semaforo1;
	private Semaphore semaforo2;
	private double[][] M = new double[14][3];

	public Formula(int idCarro, int idEscuderia, Semaphore semaforo1, Semaphore semaforo2) {
		this.idCarro = idCarro;
		this.idEscuderia = idEscuderia;
		this.semaforo1 = semaforo1;
		this.semaforo2 = semaforo2;
	}

	public void run() {
		saiBox();
		try {
			semaforo1.acquire();

				semaforo2.acquire();

			dandoVoltas();
		} catch (Exception e) {

		} finally {
			semaforo2.release();
			semaforo1.release();
			voltaBox();
		}

	}

	private void saiBox() {
		
		System.out.println("carro " + idCarro + " da escudaria " + idEscuderia + " esta pronto para sair do box ");

	}

	private void dandoVoltas() {
		int i = 0;
		long mentemp = 2001;
		long tempo = 0;
		System.out.println("carro " + idCarro + " da escudaria " + idEscuderia + " esta saindo para o treino");
		while (i < 3) {
			tempo = (long) ((Math.random() * 5001) + 5000);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (mentemp > tempo) {
				mentemp = tempo;
			}
			System.out.println(
					"carro " + idCarro + " da escudaria " + idEscuderia + " deu uma vonta de " + tempo + " minutos");
			i++;
		}

		for (int L = 0; L < 14; L++) {
			if (M[L][3] != 0) {
				M[L][1] = idCarro;
				M[L][2] = idEscuderia;
				M[L][3] = tempo;
			}
		}

	}

	private void voltaBox() {
		System.out.println("carro " + idCarro + " da escudaria " + idEscuderia + " esta voltando para o box");
		
	}
}
