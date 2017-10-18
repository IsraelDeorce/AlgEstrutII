package exerciciosComplexidade;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/*Lista de Exercícios:
Complexidade de Algoritmos
Algoritmos e Estruturas de Dados II - Prof. Marcelo Cohen
23 de agosto de 2017
 */

public class App {
	
	public static void main(String[] args) {
		
	}
	
	/**
	 *  Escreva um algoritmo para determinar a quantidade de pares de valores inteiros em um arquivo
		de entrada que são iguais. Se a sua primeira tentativa for quadrática, pense em usar
		alguma ordenação... Qual é a classe de complexidade desse tipo de solução?
	 */
	public static void leitura(){
		ArrayList<Integer> inteiros = new ArrayList<>();
		Path path = Paths.get("Files/numeros");
		try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))) {
			while (sc.hasNextLine()) {
				inteiros.add(sc.nextInt());
			}
		} catch (IOException e) {
			System.out.println("FALHOU");
			e.printStackTrace();
		} catch (Throwable e1) {
			System.out.println("A app apresentou o seguinte erro:");
			e1.printStackTrace();
		}	
		
	}
	
	public static ArrayList<Integer> quickSort(ArrayList<Integer> array, int inicio, int fim){		
		for(int i=0, j=0; i<1 && j>1; i++, j++){
			
		}
		return null;
	}

}
