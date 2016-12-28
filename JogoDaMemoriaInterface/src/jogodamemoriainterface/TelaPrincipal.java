/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodamemoriainterface;

import Regras.ControleBotoesSelecionados;
import Regras.EstadosDosBotoes;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;

/**
 *
 * @author Ludovic
 */
public class TelaPrincipal extends JFrame {

    private static final int QTD_JOGADAS = 2;
    private int jogadas = 0;

    private JPanel painel;

   private List<ControleBotoesSelecionados> listaControle;//new LinkedList<>();

    private List<ControleBotoesSelecionados> listaSelecionados;
    private ActionListener acaoBotao;

    public TelaPrincipal() {
        super("Jogo da Memoria");

        listaControle = new ArrayList<>();
        listaSelecionados = new ArrayList<>();

        //evento dos botoes 
        acaoBotao = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton botao = (JButton) e.getSource();
                for (ControleBotoesSelecionados cont : listaControle) {

                    if (cont.getReferenciaBotoes().get(botao) != null) {
                        jogadas++;
                        cont.executarAcaoBotao((JButton) e.getSource(), EstadosDosBotoes.SELECIONADO);
                        //Controle de inclusao
                        if (!listaSelecionados.contains(cont)) {
                            listaSelecionados.add(cont);
                        }

                        System.out.println(listaSelecionados.size());

                        //
                        if (jogadas == QTD_JOGADAS) {
                            //acabaram as jogadas
                            if (listaSelecionados.size() > 1) {
                                //so solecionou os botoes corretos
                                //Deixar os botoes com estado inicial
                                for (ControleBotoesSelecionados cbs : listaSelecionados) {
                                    cbs.zerarSelecoes();
                                }

                            }
                            jogadas = 0;
                            listaSelecionados.clear();
                        }
                        break;
                    }
                }
            }
        };

        painel = new JPanel();
        this.add(painel);//add na tela 
        painel.setLayout(null);


    }

   public void criaJogo(int qtdPares) {

        ControleBotoesSelecionados controle = null;
        List<Rectangle> posicionamento = new ArrayList<>();

        int posX = 10;//
        int posY = 10;//

        Random rand = new Random();
        int j = 0;
        int i = 0;

        for (i = 0; (i < qtdPares * 2); i++) {
            //Randomizar o posicionamento do botoes
            Rectangle rec = new Rectangle(posX, posY, 75, 75);
            posicionamento.add(rec);
            if (i % 5 == 0 && i > 0) {
                posY += 80;
                posX = 10;

            } else {
                posX += 80;
            }
        }

        for (i = 0; (i < qtdPares * 2); i++) {
            //todas vez que for par
            if (i % 2 == 0) {
                //Quantidade de controladores
                j++;
                controle = new ControleBotoesSelecionados();
                controle.setNmBotao("B " + j);
                this.listaControle.add(controle);
            }
            JButton botao = new JButton("Jogo");
            //coloca botoes na tela 
            this.painel.add(botao);
            botao.addActionListener(this.acaoBotao);//add funcao dele 
            //adicionar posicao 

            int pos = rand.nextInt(((posicionamento.size() - 1) > 0) ? posicionamento.size() - 1 : 1);
            System.out.println(pos);
            botao.setBounds(posicionamento.get(pos));
            posicionamento.remove(pos);

            controle.addBotao(botao);

        }

    }

}
