package exercicio_03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)) {
			menu(scanner);
		}
	}
	
	// MENU INTERATIVO
	public static void menu(Scanner scanner) {
		Carro carro = new Carro();
		int opcao;
		
		do {
			espacamento();
			
			System.out.println("+============================+");
			System.out.println("|            MENU            |");
			System.out.println("+============================+");
			System.out.println("| [1] LIGAR CARRO            |");
			System.out.println("| [2] DESLIGAR CARRO         |");
			System.out.println("| [3] ACELERAR               |");
			System.out.println("| [4] DIMINUIR VELOCIDADE    |");
			System.out.println("| [5] VIRAR PARA ESQUERDA/   |");
			System.out.println("| DIREITA                    |");
			System.out.println("| [6] VERIFICAR VELOCIDADE   |");
			System.out.println("| [7] TROCAR MARCHA          |");
			System.out.println("| [0] SAIR                   |");
			System.out.println("+============================+");
			System.out.print(">>> ");
			
			opcao = Integer.parseInt(scanner.nextLine());
			opcoes(scanner, carro, opcao);
			scanner.nextLine();
			
		} while (opcao != 0);
	}
	
	// DIFINIR QUAIS MÉTODOS DA CLASSE CARRO QUE VAI SER EXECUTADO
	public static void opcoes(Scanner scanner, Carro carro, int opcao) {
		
		InfoCarro toInfoCarro = carro.toInfoCarro();
		
		switch(opcao) {
			// ENCERRANDO
			case 0 -> System.out.println("ENCERRANDO...");
			
			// LIGAR O CARRO
			case 1 -> { 
				if (toInfoCarro.ligado()) {
					System.out.println("CARRO JÁ ESTÁ LIGADO!");
				} else {
					carro.ligarDesligar(true);
					System.out.println("CARRO LIGADO!");
				}
			}
			
			
			// DESLIGAR O CARRO
			case 2 -> {
				if (toInfoCarro.ligado() && toInfoCarro.velocidade() == 0 && toInfoCarro.marcha() == 0) {
					carro.ligarDesligar(false);
					System.out.println("CARRO DESLIGADO!");
				} else if (toInfoCarro.ligado() == false) System.out.println("CARRO JÁ ESTÁ DESLIGADO!");
				else if (toInfoCarro.velocidade() != 0) System.out.println("PARE O CARRO ANTES DE DESLIGAR!");
				else if (toInfoCarro.marcha() != 0) System.out.println("COLOQUE O CARRO EM PONTO MORTO ANTES DE DESLIGAR!");
			}
			
			// ACELERAR
			case 3 -> {
				switch(carro.acelerar(toInfoCarro.marcha())) {
					case 0 -> System.out.println("CARRO DESLIGADO!");
					
					case 1 -> System.out.println("MARCHA EM PONTO MORTO!");
					
					case 2 -> System.out.println("ACELERANDO!");
					
					case 3 -> System.out.println("É PRECISO TROCAR DE MARCHA PARA CONTINUAR A ACELERAR!");
					
					case 4 -> System.out.println("LIMITE MÁXIMO DE VELOCIDADE ATINGIDO!");
					
					
				}
			}
			
			// DIMINUIR VELOCIDADE
			case 4 -> {
				switch(carro.desacelerar()) {
					case 0 -> System.out.println("CARRO DESLIGADO");
					case 1 -> System.out.println("DESACELEROU E TROCOU A MARCHA");
					case 2 -> System.out.println("DESACELEROU");
					case 3 -> System.out.println("CARRO PAROU!");
				}
			}
			
			// VIRAR PARA DIREITA/ESQUERDA
			case 5 -> {
				switch(carro.virarDireitaEsquerda()) {
					case 0 -> System.out.println("NÃO É POSSÍVEL VIRAR PORQUE O CARRO ESTÁ PARADO!");
					case 1 -> System.out.println("O CARRO VIROU PARA DIREITA/ESQUERDA COM SUCESSO!");
					case 2 -> System.out.println("O CARRO ESTÁ MUITO RÁPIDO PARA VIRAR, PODE ACONTECER UM ACIDENTE\nDESACELERE PRIMEIRO!");
				}
			}
			/* SITUAÇÕES
			* 0 -> NÃO PODE VIRAR PELO CARRO ESTAR PARADO
			* 1 -> VIROU PARA ESQUERDA/DIREITA
			* 2 -> MUITO RÁPIDO PARA VIRAR
			*/
			
			// VERIFICAR VELOCIDADE
			case 6 -> System.out.printf("SUA VELOCIDADE: %s km/h", toInfoCarro.velocidade());
			
			// TROCAR MARCHA
			case 7 -> {
				switch(carro.trocarMarcha(true)) {
				// 0 CARRO DESLIGADO
				// 1 NÃO ESTÁ VELOCIDADE CERTA PARA TROCAR
				// 2 TROCADA COM SUCESSO PARA AUMENTAR A VELOCIDADE
				// 3 TROCADA COM SUCESSO PARA DIMINUIR A VELOCIDADE
				// 4 PONTO MORTO
				// 5 MARCHA JÁ TROCADA
					case 0 -> System.out.println("CARRO DESLIGADO");
					case 1 -> System.out.println("VOCÊ AINDA NÃO ESTÁ NA VELOCIDADE IDEAL PARA TROCAR!");
					case 2 -> System.out.println("MARCHA TROCADA!");
					case 4 -> System.out.println("CARRO EM PONTO MORTO!");
					case 5 -> System.out.println("ACELERA MAIS PARA CONSEGUIR TROCAR A MARCHA!");
					
				}
			}
			
			
			// OPÇÃO DIFERENTE DE 0 ATÉ 7
			default -> System.out.println("[ERRO] OPÇÃO INVÁLIDA!");
		}
		
	}
	
	
	// COLOCAR ESPAÇOS COMO SE FOSSE VÁRIAS TELAS
	public static void espacamento() {
		for (int i = 0; i < 30; i++) {
			System.out.println("");
		}
	}
	

}
