# 🚗 Simulador de Funções de um Carro — Java

Projeto desenvolvido em **Java** com foco em **Programação Orientada a Objetos (POO)**.

O sistema simula o funcionamento de um carro, permitindo controlar suas principais ações através de um menu interativo no console.

---

## 📚 Conceitos aplicados

* Encapsulamento
* Abstração
* Records (Java)
* Estruturas condicionais
* Switch expressions
* Organização em classes

---

## ⚙️ Funcionalidades

O sistema permite:

* ✅ Ligar o carro
* ✅ Desligar o carro
* ✅ Acelerar
* ✅ Diminuir velocidade
* ✅ Virar para esquerda/direita
* ✅ Verificar velocidade atual
* ✅ Trocar marchas

---

## 🚦 Regras do sistema

* O carro inicia desligado, em ponto morto e velocidade **0 km/h**
* Não é possível executar ações com o carro desligado
* Velocidade máxima: **120 km/h**
* Velocidade mínima: **0 km/h**
* O carro possui **6 marchas**
* Não é permitido pular marchas
* Cada marcha possui limite de velocidade específico:

| Marcha     | Velocidade     |
| ---------- | -------------- |
| 0 (Neutro) | Não acelera    |
| 1ª         | 0 – 20 km/h    |
| 2ª         | 21 – 40 km/h   |
| 3ª         | 41 – 60 km/h   |
| 4ª         | 61 – 80 km/h   |
| 5ª         | 81 – 100 km/h  |
| 6ª         | 101 – 120 km/h |

* O carro só pode desligar se estiver:

  * Em ponto morto
  * Velocidade igual a 0 km/h

* O carro só pode virar:

  * Velocidade mínima: **1 km/h**
  * Velocidade máxima: **40 km/h**

---

Praticar conceitos fundamentais de **Programação Orientada a Objetos**, lógica de programação e organização de código em Java.

