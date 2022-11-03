import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaEleitoralMapTest {
    SistemaEleitoralMap sistema = new SistemaEleitoralMap();
    @Test
    public void votarEContaVotosParaCandidatoTest(){
        sistema.cadastraCandidato("lula",13,Partido.PARTIDO1);
        sistema.cadastraEleitor("joão","1411");
        sistema.votar("1411",13);
        assertTrue(sistema.contarVotosParaCandidato(13) == 1,"inválido");
    }
    @Test
    public void obterDadosDoCandidatoTest(){
        sistema.cadastraCandidato("lula",13,Partido.PARTIDO1);
        try{
            sistema.obterDadosDoCandidato("lula");
        }catch (CanditadoInexistenteException e){
            fail("Não deveria dar essa exceção");
        }
    }
    @Test
    public void cadastrarCandidatoEEleitorTeste(){
        assertTrue(sistema.cadastraCandidato("lula",13,Partido.PARTIDO1),"inválido");
        assertTrue(sistema.cadastraEleitor("joão","1411"),"inválido");
    }





}
