
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pichau
 */
public class RegistroProduto extends Produto {

    public RegistroProduto() {
        super();
    }

    public RegistroProduto(String nome, double precoUnitario, int unidade, double qtdEstoque) {
        super(nome, precoUnitario, unidade, qtdEstoque);
    }

    public void leitura(RandomAccessFile arquivo) throws IOException {
        setNome(montaPalavra(arquivo, 30).trim());
        //Retira os espaços da leitura da String com método trim
        setPrecoUnitario(arquivo.readDouble());
        //Retira os espaços da leitura da String com o método trim
        setUnidade(arquivo.readInt());
        setQtdEstoque(arquivo.readDouble());

    }

    private String montaPalavra(RandomAccessFile arquivo, int tamanho) throws IOException {
        //Vetor de char da palavra a ser montada
        char palavra[] = new char[tamanho];
        char temp;
        // Recupera do arquivo 15 caracteres
        for (int i = 0; i < palavra.length; i++) {
            temp = arquivo.readChar();
            palavra[i] = temp;
        }
        return new String(palavra).replace('\0', ' ');
    }

    public void escrita(RandomAccessFile arquivo) throws IOException {

        escrevePalavra(arquivo, getNome(), 15);

        arquivo.writeDouble(getPrecoUnitario());

        arquivo.writeDouble(getQtdEstoque());

        arquivo.writeInt(getUnidade());

    }

    private void escrevePalavra(RandomAccessFile arquivo, String palavra, int tamanho) throws IOException {
        StringBuffer buf = null;
        if (palavra != null) {
            buf = new StringBuffer(palavra);
        } else {
            buf = new StringBuffer(tamanho);
        }

        buf.setLength(tamanho);
        arquivo.writeChars(buf.toString());
    }
 
    public int getTamanhoRegistro() {

        return (4 + (2 * 30) + (2 * 15) + 8);
    }
}

