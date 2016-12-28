/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodamemoriainterface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ludovic
 */
public class JogoDaMemoriaInterface {

    
    public static void main(String[] args) {
        
        String Num = JOptionPane.showInputDialog("Entre com A dificuladade");
         //converte String em valores int  
        int numero = Integer.parseInt(Num);
        
        TelaPrincipal tela = new TelaPrincipal();
        tela.criaJogo(numero);
        
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setBounds(250, 250, 500, 500);
        tela.setVisible(true);

    }

}
