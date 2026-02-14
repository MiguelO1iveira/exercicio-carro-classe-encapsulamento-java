package exercicio_03;

public class Carro {
	// CONSTANTES
	
	
	// ATRIBUTOS
	private boolean ligado;
	private byte marcha;
	private int velocidade;
	
	
	
	// MÉTODOS
	public void ligarDesligar(boolean chave) {
		this.ligado = chave;
	}
	
	// ACELERAR
	public byte acelerar(byte marcha) {
		byte situacao = 0; // CARRO DESLIGADO
		
		if (this.ligado) {
		
			if (this.marcha != 0) {
				
				switch(this.velocidade) {
					case 20, 40, 60, 80, 100 -> situacao = 3; // PRECISA TROCAR MARCHA
					case 120 -> situacao = 4; // VELOCIDADE MÁXIMA
					default -> {
						situacao = 2; // ACELEROU
						this.velocidade += 1;
					}
				}
			} else situacao = 1;
			
		}
		
		return situacao;
	} // ============
	
	// DIMINUINDO VELOCIDADE
	public byte desacelerar() {
		byte situacao = 0; // CARRO DESLIGADO
		
		if (this.ligado && this.velocidade > 0) {
			
			
			switch(this.velocidade) {
				case 0 -> {
					situacao = 3; // CARRO PARADO
				}
				case 20, 40, 60, 80, 100 -> {
					this.trocarMarcha(false);
					this.velocidade -= 1;
					if (this.velocidade == 0) this.marcha = 0;
					situacao = 1; // DESACELEROU E TROCOU A MARCHA
				}
			
				default -> {
					this.velocidade -= 1;
					situacao = 2; // DESACELEROU
				}
			}
	
		}		
		return situacao;
	}
	
	// TROCAR MARCHA
	public byte trocarMarcha(boolean trocar) {
		// SE TROCAR == TRUE, ELE VAI AUMENTAR A MARCHA, SENÃO VAI DIMINUIR
		// 0 CARRO DESLIGADO
		// 1 NÃO ESTÁ VELOCIDADE CERTA PARA TROCAR
		// 2 TROCADA COM SUCESSO PARA AUMENTAR A VELOCIDADE
		// 3 TROCADA COM SUCESSO PARA DIMINUIR A VELOCIDADE
		// 4 PONTO MORTO
		// 5 MARCHA JÁ TROCADA
		
		byte situacao = 0; // CARRO DESLIGADO
		
		if (this.ligado) {
			situacao = 4; // PONTO MORTO
			
			if (trocar && this.marcha < 6) {
				situacao = 2; // TROCADA COM SUCESSO PARA AUMENTAR A VELOCIDADE
				
				
				
				switch(this.velocidade) {
				
				
				
				
					case 0 -> {
						if (this.marcha != 1) {
							this.marcha = 1;
							this.velocidade += 1;
						} else situacao = 5; // MARCHA JÁ TROCADA
					}
					case 20 -> {
						if (this.marcha != 2) {
							this.marcha = 2;
							this.velocidade += 1;
						} else situacao = 5;
					}
					case 40 -> {
						if (this.marcha != 3) {
							this.marcha = 3;
							this.velocidade += 1;
						} else situacao = 5;
					}
					case 60 -> {
						if (this.marcha != 4) {
							this.marcha = 4;
							this.velocidade += 1;
						} else situacao = 5;
					}
					case 80 -> {
						if (this.marcha != 5) {
							this.marcha = 5;
							this.velocidade += 1;
						} else situacao = 5;
					}
					case 100 -> {
						if (this.marcha != 6) {
							this.marcha = 6;
							this.velocidade += 1;
						} else situacao = 5;
					}
					
					default -> situacao = 1; // NÃO ESTÁ VELOCIDADE CERTA PARA TROCAR
				}
				
			} else if (this.marcha > 0) {
				situacao = 3;
				this.marcha -= 1;
			}

		}
		return situacao;
	}
	
	public byte virarDireitaEsquerda() {
		/* SITUAÇÕES
		* 0 -> NÃO PODE VIRAR PELO CARRO ESTAR PARADO
		* 1 -> VIROU PARA ESQUERDA/DIREITA
		* 2 -> MUITO RÁPIDO PARA VIRAR
		*/
		byte situacao = 0; // NÃO PODE VIRAR PELO CARRO ESTAR PARADO
		
		if (this.ligado) {

			if (this.velocidade == 0) situacao = 0;
			else if (this.velocidade <= 40) situacao = 1; // VIROU PARA ESQUERDA/DIREITA
			else situacao = 2; // MUITO RÁPIDO PARA VIRAR
		}
		
		
		
		return situacao;
	}
	
	
	
	// CRIANDO O RECORD PARA RETORNAR OS DADOS
	public InfoCarro toInfoCarro() {
		return new InfoCarro(this.ligado, this.marcha, this.velocidade);
	}
}


