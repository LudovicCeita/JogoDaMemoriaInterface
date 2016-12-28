/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodamemory;

import java.util.Scanner;

/**
 *
 * @author Notorius B.I.G
 */
public class Jogodamemory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Jogador jogador;
        Scanner input = new Scanner(System.in);
        int lin1, col1, lin2, col2, op, tamanho;
        boolean sair = true;
        String nome;
        Ranking rankingJogadores = new Ranking();
        ImprimiMenu imprime = new ImprimiMenu();

        while (sair) {
            imprime.Menu1();
            op = input.nextInt();

            switch (op) {
                case 1: {
                    
                    imprime.Menu2();
                    tamanho = input.nextInt();

                    Tabuleiro tabu = new Tabuleiro(tamanho);
                    tabu.gerarLista();
                    tabu.gerarPeca();
                    
                    //Cria um novo Jogador
                    jogador = new Jogador();
                   
                    System.out.println("Qual o nome do Jogador");
                    nome = input.next();
                    jogador.setNome(nome);
                    System.out.println("\n");
                    
                    tabu.setJogadorAtual(jogador);
                    tabu.getJogadorAtual().setPontuacao(0);//pontuacao = 0
                    
                    while (!tabu.jogoAcabou()) {

                        tabu.mostrarTabuleiro();
                        System.out.println("Digite a linha da posicao 1");
                        lin1 = input.nextInt();
                        System.out.println("Digite a coluna da posicao 1");
                        col1 = input.nextInt();
                        System.out.println("\n");
                        
                        tabu.viraPeca(lin1, col1);
                        tabu.mostrarTabuleiro();

                        do{
                        System.out.println("Digite a linha da posicao 2");
                        lin2 = input.nextInt();
                        System.out.println("Digite a coluna da posicao 2");
                        col2 = input.nextInt();
                        System.out.println("\n");  
                        }while(lin1 == lin2 && col1 == col2);

                        tabu.viraPeca(lin2, col2);
                        tabu.mostrarTabuleiro();

                        //retorna o Jogador Atual e altera sua pontuacao
                        tabu.getJogadorAtual().setPontuacao(tabu.getJogadorAtual().getPontuacao() + 1);

                        //compara as pocisoes que o usuario digitou 
                        if (!tabu.compara(lin1, col1, lin2, col2)) {

                            Thread.sleep(2000);
                            tabu.desviraPeca(lin1, col1);
                            tabu.desviraPeca(lin2, col2);

                        }
                        tabu.limparTela();

                    }
                    //Se Jogo terminou retorna true
                    //todas as pecas foram acertadas
                    if (tabu.jogoAcabou()) {
                        rankingJogadores.addJogador(jogador);
                        rankingJogadores.ordenarListaRanking();
                        rankingJogadores.mostrarJogadores();
                    }

                    break;
                }

                case 2: {
                    rankingJogadores.mostrarJogadores();
                    break;
                }
                case 3: {
                    sair = false;
                    break;
                }
            }
        }
    }

}
