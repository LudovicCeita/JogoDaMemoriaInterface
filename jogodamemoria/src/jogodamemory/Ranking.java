/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodamemory;

//import java.util.Collection;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Ludovic
 */
public class Ranking {

    private LinkedList<Jogador> listaJogadores = new LinkedList<>();

    public void addJogador(Jogador j) {
        listaJogadores.add(j);
    }

    public void mostrarJogadores() {
        int cont = 1;

        System.out.println("Ranking       Nome           Pontuacao");

        for (Jogador jogador : listaJogadores) {
            
            System.out.print(cont);
            System.out.print(jogador);
            cont++;
        }

        System.out.println("\n\n\n");
    }

    //ordenar uma linked List
    public void ordenarListaRanking() {
        Collections.sort(listaJogadores);

    }

}
