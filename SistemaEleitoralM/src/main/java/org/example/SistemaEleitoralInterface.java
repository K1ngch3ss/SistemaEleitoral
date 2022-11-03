package org.example;
/**
 * interface representa um sistema eleitoral
 */
public interface SistemaEleitoralInterface {
    /**
     * O método votar que recebe o numero do titulo e o numero votado
     * e armazena o voto na coleção de votos
     * @param numTitulo o número do titulo de eleitor
     * @param numeroVotado o número votado
     */
    void votar(String numTitulo,int numeroVotado) throws EleitorInexistenteException;
    /**
     * O metodo recebe o nome de um possível candidato e procura na coleção
     * de candidatos por algum candidato com o mesmo nome
     * @param nome o nome do candidato
     * @return os dados do candidato caso encontre um candidado com o nome buscado.
     */
    Candidato obterDadosDoCandidato(String nome) throws CanditadoInexistenteException;
    /**
     * O metodo recebe o número de algum candidato e varre a coleção de
     * votos contando os votos com aquele número
     * @param numero o número votado a ser contado
     * @throws CanditadoInexistenteException quando o candidato com o nome não existir na coleção de candidatos
     * @return a quantidade de votos com aquele número
     */
    int contarVotosParaCandidato(int numero);
    /**
     * O metodo recebe o nome, número e partido de um candidado e caso não exista
     * nenhum outro canditado igual já cadastrado ele cadastra.
     * @param nome o nome do candidato
     * @param numero o número do condidato
     * @param partido o partido do candidato
     * @return true caso tenha cadastrado o novo candidato e false caso o contrário
     */
    boolean cadastraCandidato(String nome,int numero,Partido partido) ;
    /**
     * O metodo recebe o nome, número e partido de um eleitor e caso não exista
     * nenhum outro eleitor igual já cadastrado ele cadastra.
     * @param nome o nome do eleitor
     * @param titulo o título do eleitor
     * @return true caso tenha cadastrado o novo eleitor e false caso o contrário
     */
    boolean cadastraEleitor(String nome,String titulo);


}
