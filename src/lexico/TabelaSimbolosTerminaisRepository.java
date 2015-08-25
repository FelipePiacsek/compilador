package lexico;

import static java.lang.Math.round;
import static java.nio.file.Files.exists;
import static java.nio.file.Paths.get;
import static lexico.TabelaSimbolosTerminais.n;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TabelaSimbolosTerminaisRepository {

    private final double LIMITE = 2 * n * 0.65;

    public List<String> readWordsFromTextFile() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("C:\\Development\\Workspace\\Compilador\\bin\\words.txt"), Charset.forName("UTF-8"));
            return lines;
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo texto com os dados da tabela.");
            e.printStackTrace();
        }
        return null;

    }

    private TabelaSimbolosTerminais createTableFromTextFile() {
        TabelaSimbolosTerminais tabela = new TabelaSimbolosTerminais();
        List<String> palavras = readWordsFromTextFile();
        if (palavras.size() > LIMITE) {
            throw new RuntimeException("A quantidade de símbolos não pode superar " + round(LIMITE) + ".");
        }
        for (String palavra : palavras) {
            tabela.insereBusca(palavra, TabelaSimbolosTerminais.Modo.INSERCAO);
        }
        saveTable(tabela);
        return tabela;
    }

    private void saveTable(TabelaSimbolosTerminais tabela) {
        try {
            FileOutputStream fout;
            fout = new FileOutputStream("C:\\Development\\Workspace\\Compilador\\bin\\words.blob");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(tabela);
            oos.close();
            System.out.println("Tabela salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar a tabela.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("resource")
    private TabelaSimbolosTerminais loadTableFromBinaryFile() {
        FileInputStream fin;
        ObjectInputStream ois = null;
        try {
            fin = new FileInputStream("C:\\Development\\Workspace\\Compilador\\bin\\words.blob");
            ois = new ObjectInputStream(fin);
            TabelaSimbolosTerminais tabela = (lexico.TabelaSimbolosTerminais) ois.readObject();
            System.out.println("Tabela lida do arquivo binário com sucesso.");
            return tabela;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar a tabela do arquivo binário.");
            e.printStackTrace();
        }
        return null;
    }

    public TabelaSimbolosTerminais loadTable() {
        if (exists(get("C:\\Development\\Workspace\\Compilador\\bin\\words.blob"))) {
            return loadTableFromBinaryFile();
        }
        return createTableFromTextFile();
    }

}
