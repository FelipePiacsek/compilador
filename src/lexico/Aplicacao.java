package lexico;

/**
 * @author FPiacsek
 */
public class Aplicacao {

    public static void main(String[] args) {
        TabelaSimbolosTerminaisRepository repository = new TabelaSimbolosTerminaisRepository();
        TabelaSimbolosTerminais tabela = repository.loadTable();
        tabela.print();
    }

}