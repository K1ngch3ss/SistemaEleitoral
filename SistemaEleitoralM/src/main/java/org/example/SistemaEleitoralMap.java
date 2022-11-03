package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaEleitoralMap {

    private List<Voto> votos;
    private Map<String,Candidato> candidatos;
    private Map<String,Eleitor> eleitores;

    public SistemaEleitoralMap(){
        this.votos = new ArrayList<>();
        this.candidatos = new HashMap<>();
        this.eleitores = new HashMap<>();
    }
    public void votar(String numTitulo, int numVotato) throws EleitorInexistenteException{
        if(eleitores.containsKey(numTitulo))
            votos.add(new Voto(numVotato));
        else{
            throw new EleitorInexistenteException("Eleitor não existe");
        }
    }
    public Candidato obterDadosDoCandidato(String nome) throws CanditadoInexistenteException{
        if(candidatos.containsKey(nome)){
            return candidatos.get(nome);
        }else {
            throw new CanditadoInexistenteException("Candidato não cadastrado");
        }
    }
    public int contarVotosParaCandidato(int numero){
        int cont = 0;
        for(Voto v:this.votos){
            if(v.getNumeroVotado() ==  numero){
                cont +=1;
            }
        }
        return cont;
    }
    public boolean cadastraCandidato(String nome,int numero,Partido partido){
        if(candidatos.containsKey(nome)){
            return false;
        }
        candidatos.put(nome,new Candidato(nome,numero,partido));
        return true;
    }
    public boolean cadastraEleitor(String nome,String titulo){
        if(eleitores.containsKey(titulo)){
            return  false;
        }
        eleitores.put(titulo,new Eleitor(nome,titulo));
        return true;
    }

}
