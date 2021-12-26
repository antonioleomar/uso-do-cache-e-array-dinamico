package exercicio1;

import java.util.Scanner;

public class Algoritmo3b {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int cont = 0;
		int maior = 0;
		int menor = 0;

		while (entrada.hasNextInt()) {
			int num1;
			int num2;
			while (true) {
				num1 = entrada.nextInt();
				if (num1 > 0 || num1 < 1000000) {
					break;
				}
			}

			while (true) {
				num2 = entrada.nextInt();
				if (num2 > 0 || num2 < 1000000) {
					break;
				}
			}

			if (num2 > num1) {
				maior = num2;
				menor = num1;
			} else {
				maior = num1;
				menor = num2;
			}

			cont++;

			long tamanhoCiclo = tamanhoCiclo(menor, maior);
			System.out.printf("%d %d %d\n", num1, num2, tamanhoCiclo);

		} // fim do while

		entrada.close();

	}// fim do main

	// Usando cache para melhorar o desempenho do algoritmo:
	// Cache será um vetor para armazenar valores conhecidos
	static long[] cache = new long[1000001];

	// Determinar o maior tamanho de ciclo
	public static long tamanhoCiclo(int menor, int maior) {

		long tamanhoCiclo = 1;
		long valor;

		for (int i = menor; i <= maior; i++) {
			if (cache[i] != 0) {
				valor = cache[i];
			} else {
				valor = contagem(i);
				cache[i] = tamanhoCiclo;
			}

			if (valor > tamanhoCiclo) {
				tamanhoCiclo = valor;
			}

		}
		return tamanhoCiclo;
	}// fim do método tamanhoCiclo

	public static long contagem(long numero) {

		long cont = 1;
		long valor = numero;
		while (valor != 1) {
			if (valor % 2 == 0) {
				valor = valor / 2;
				cont++;
			} else {
				valor = (valor * 3) + 1;
				cont++;
			}
		}
		return cont;
	}// fim do método contagem

	public static void imprimirMatriz(int[][] matriz, int[] vetor, int quantLinha) {

		for (int i = 0; i < quantLinha; i++) {
			System.out.printf("%d %d %d", matriz[i][0], matriz[i][1], vetor[i]);
			System.out.println();
		}
	}

}
