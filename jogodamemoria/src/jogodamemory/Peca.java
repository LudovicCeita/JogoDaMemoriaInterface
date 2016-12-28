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
public class Peca {
    
    private int valor ;
    private boolean virado = false;

    public Peca() {
        
    }

    public Peca(int valor) {
        this.valor = valor;
    }
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isVirado() {
        return virado;
    }

    public void setVirado(boolean virado) {
        this.virado = virado;
    }
    
    
    
}
