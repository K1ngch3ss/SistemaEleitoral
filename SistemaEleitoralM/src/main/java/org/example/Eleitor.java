package org.example;
import java.util.Objects;

public class Eleitor {

    private String nome;
    private String titulo;

    public Eleitor(String nome,String titulo){
        this.nome = nome;
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object obg) {
        if (this == obg) return true;
        if (obg == null || getClass() != obg.getClass()) return false;
        Eleitor eleitor = (Eleitor) obg;
        return titulo.equals(eleitor.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

    @Override
    public String toString(){
        return "Eleitor de nome "+this.nome+", número de título "+this.titulo;
    }
}
