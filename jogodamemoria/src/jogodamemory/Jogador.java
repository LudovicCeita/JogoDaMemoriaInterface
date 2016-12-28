/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodamemory;

/**
 *
 * @author Notorius B.I.G
 */
public class Jogador implements Comparable<Jogador> {

    private String nome;
    private int pontuacao = 0;

    public Jogador() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getPontos() {
        //Converte um inteiro  em String 
        String pontos = Integer.toString(pontuacao);
        return pontos;

    }

    @Override
    public int compareTo(Jogador o) {
        return getPontos().compareTo(o.getPontos());
    }

    @Override
    public String toString() {
        return "\t " + getNome() + "\t\t" + getPontuacao() + "\n";
    }

}
