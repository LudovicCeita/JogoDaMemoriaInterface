/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regras;
//int pos = rand.nextInt(((posicionamento.size() - 1) > 0) ? posicionamento.size() - 1 : 1 );
//System.out.println(pos);

import java.awt.Color;
import java.awt.Event;
import static java.lang.Thread.sleep;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

/**
 *
 * @author ludovic gerenciamento dos botoes que ja foram selecionados ou nao
 *
 * 2
 */
public class ControleBotoesSelecionados {

    private String nmBotao;
    //obtem a referencia do botao e a partir disso vou 
    //saber se ta selecionado ou nao 
    private Map<JButton, EstadosDosBotoes> referenciaBotoes;

    public ControleBotoesSelecionados() {
        this.referenciaBotoes = new HashMap<>();
    }

    public void executarAcaoBotao(JButton botao, EstadosDosBotoes estado) {
        alteraSelecao(botao, estado);

        if (this.isTodasSelecionadas()) {

            alterarEstadosTodosBotoes(EstadosDosBotoes.PARE_ENCONTRADO);
        } else {

            alterarVisualizacaoBotao(botao);

        }

    }

    private void alterarEstadosTodosBotoes(EstadosDosBotoes estado) {

        for (JButton botao : this.referenciaBotoes.keySet()) {
            alteraSelecao(botao, estado);
            alterarVisualizacaoBotao(botao);
        }
    }

    public String getNmBotao() {
        return nmBotao;
    }

    public void setNmBotao(String nmBotao) {
        this.nmBotao = nmBotao;
    }

    public Map<JButton, EstadosDosBotoes> getReferenciaBotoes() {
        return referenciaBotoes;
    }

    public void setReferenciaBotoes(Map<JButton, EstadosDosBotoes> referenciaBotoes) {
        this.referenciaBotoes = referenciaBotoes;
    }

    public void addBotao(JButton botao) {
        this.referenciaBotoes.put(botao, EstadosDosBotoes.NORMAL);//n ta selecionado
    }

    // altera o valor referenciaBotao para true
    public void alteraSelecao(JButton botao, EstadosDosBotoes selecionado) {
        this.referenciaBotoes.put(botao, selecionado);

    }

    private void alterarVisualizacaoBotao(JButton botao) {

        EstadosDosBotoes selecionados = this.referenciaBotoes.get(botao);//pega o botao 

        switch (selecionados) {

            case NORMAL://Cinza , nao exibe texto
                botao.setBackground(null);
                botao.setText("jogo");
                botao.setEnabled(true);
                break;
            case SELECIONADO://Exibir Texto , mudar a cor 
                botao.setBackground(Color.green);
                botao.setText(this.nmBotao);
                botao.setEnabled(false);
                break;
            case PARE_ENCONTRADO://Muda cor , exibe o texto 
                botao.setBackground(Color.magenta);
                botao.setText(this.nmBotao);
                botao.setEnabled(false);
                break;

            default:
                botao.setBackground(null);
                botao.setText("jogo");
                break;

        }
    }

//zerar todas os botoes
    public void zerarSelecoes() {

        this.alterarEstadosTodosBotoes(EstadosDosBotoes.NORMAL);
//        for (EstadosDosBotoes b : this.referenciaBotoes.values()) {
//            b = EstadosDosBotoes.NORMAL;
//        }
    }

    public Boolean isTodasSelecionadas() {

        for (EstadosDosBotoes b : this.referenciaBotoes.values()) {
            // se alguns dele for false 
            if (b != EstadosDosBotoes.SELECIONADO) {
                //nao foram todos selecionados 
                return false;
            }
        }
        return true;
    }
}
