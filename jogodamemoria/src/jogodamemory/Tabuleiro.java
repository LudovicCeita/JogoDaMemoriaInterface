/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodamemory;

import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ludovic
 */
public class Tabuleiro {

    private int tamanhoTabuleiro;

    private Peca[][] pecas;
    private Jogador jogadorAtual;
    private LinkedList<Peca> listaPeca = new LinkedList<>();

    public void gerarLista() {
//insere 2 peca ao mesmo tempo 
        for (int i = 0; i < (tamanhoTabuleiro * tamanhoTabuleiro) / 2; i++) {
            Peca peca = new Peca();
            peca.setValor(i + 1);
            listaPeca.add(peca);
            listaPeca.add(peca);
        }

    }

    //pra saber qual a dificuldade do jogo 
    public Tabuleiro(int op2) {

        //
        if (op2 == 1) {
            tamanhoTabuleiro = 2;
        }

        if (op2 == 2) {
            tamanhoTabuleiro = 6;
        }
        if (op2 == 3) {
            tamanhoTabuleiro = 8;
        }

        pecas = new Peca[tamanhoTabuleiro][tamanhoTabuleiro];
    }

    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(Jogador jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    //pegar os elementos da minha lista e adiciono na minha matriz peca
    public void gerarPeca() {

        int posArmazenada, tamanho;
        for (int lin = 0; lin < tamanhoTabuleiro; lin++) {
            for (int col = 0; col < tamanhoTabuleiro; col++) {
                Peca peca;
                Random numAleatorio = new Random();

                //pego o tamanho da minha listaPeca
                tamanho = listaPeca.size();
                //gerar um numeroAleatorio 0 ate o tamanho da lista
                posArmazenada = numAleatorio.nextInt(tamanho);
                //Agora q eu tenho a posicao 
                //salvo o elemento e remover
                peca = listaPeca.remove(posArmazenada);
                pecas[lin][col] = new Peca(peca.getValor());

            }
        }

    }

    public void mostrarTabuleiro() {

        System.out.println("nome: " + jogadorAtual.getNome());
        System.out.println("tentativas: " + jogadorAtual.getPontuacao());

        for (int lin = 0; lin < tamanhoTabuleiro; lin++) {
            for (int col = 0; col < tamanhoTabuleiro; col++) {
                //se a peca esta virada mosta o elemento
                if (pecas[lin][col].isVirado()) {
                    System.out.print(pecas[lin][col].getValor() + "   ");

                } else {
                    System.out.print(0 + "   ");
                }

            }
            System.out.println("");
        }
    }

    //Verifica se todas as pecas foram acertadas
    public boolean jogoAcabou() {

        for (int lin = 0; lin < tamanhoTabuleiro; lin++) {
            for (int col = 0; col < tamanhoTabuleiro; col++) {
                //verifica as pecas esta de cabeca pra baixo 
                if (!pecas[lin][col].isVirado()) {
                    return false;
                }

            }

        }
        return true;
    }

    public void viraPeca(int lin, int col) {

        pecas[lin][col].setVirado(true);

    }

    public void desviraPeca(int lin, int col) {

        pecas[lin][col].setVirado(false);

    }

    public boolean compara(int lin1, int col1, int lin2, int col2) {

        if (pecas[lin1][col1].getValor() == pecas[lin2][col2].getValor()) {
            return true;
        } else {
            return false;
        }

    }

    public void limparTela() {
        for (int i = 0; i < 60; i++) {
            System.out.println("");

        }
    }

}
