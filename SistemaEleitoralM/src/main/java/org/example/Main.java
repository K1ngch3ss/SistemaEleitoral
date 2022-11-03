package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        SistemaEleitoralMap sistema = new SistemaEleitoralMap();
        JOptionPane.showMessageDialog(null,"Urna Eletrônica");
        boolean loop = true;
        while(loop){
            String opcao = JOptionPane.showInputDialog("Digite uma opção:\n1.cadastrar eleitor" +
                    "\n2.cadastrar candidato\n3.votar\n4.contar Votos pelo número votado\n5.sair");
            switch (opcao) {
                case "1":
                    String nome = JOptionPane.showInputDialog("Digite seu nome:");
                    String tituloEleitor = JOptionPane.showInputDialog("Digite seu título de eleitor:");
                    if (sistema.cadastraEleitor(nome, tituloEleitor)) {
                        JOptionPane.showMessageDialog(null, "Eleitor cadastrado com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
                    }
                    continue;
                case "2":
                    String nomeCandidato = JOptionPane.showInputDialog("Digite seu nome:");
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número:"));
                    String escolher = JOptionPane.showInputDialog("Qual é o Partido que você pertence\n1.PARTIDO1\n2.PARTIDO2\n3.PARTIDO3");
                    Partido partido = null;
                    if(escolher == "1"){
                        partido = Partido.PARTIDO1;
                    } else if (escolher == "2") {
                        partido = Partido.PARTIDO2;
                    } else if (escolher == "3") {
                        partido = Partido.PARTIDO3;
                    }
                    if(sistema.cadastraCandidato(nomeCandidato,numero,partido)){
                        JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar");
                    }
                    continue;
                case "3":
                    String numeroTitulo = JOptionPane.showInputDialog("Digite seu número de título");
                    int numeroVotado = Integer.parseInt(JOptionPane.showInputDialog("Digite o número:"));
                    try{
                        sistema.votar(numeroTitulo,numeroVotado);
                        JOptionPane.showMessageDialog(null,"Voto Computado");
                    }catch (EleitorInexistenteException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                    }
                    continue;
                case "4":
                    int numeroPesquisar = Integer.parseInt(JOptionPane.showInputDialog("Digite o número:"));
                    JOptionPane.showMessageDialog(null,"A quantidade de votos nesse candidato é "+sistema.contarVotosParaCandidato(numeroPesquisar)+" votos.");
                    continue;
                case "5":
                    loop = false;
            }
        }
    }
}
