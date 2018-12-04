/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


public class GerenciadorProduto {
    
      private String nomeArquivo;
    private RandomAccessFile arquivo;

    public GerenciadorProduto() {
        setNomeArquivo("PRODUTO.DAT");
        abrirArquivo();
    }

    public GerenciadorProduto(String nomeArquivo) {
        setNomeArquivo(nomeArquivo);
        abrirArquivo();
    }

    public void finalize() {
        fecharArquivo();
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public RandomAccessFile getArquivo() {
        return arquivo;
    }

    public void setArquivo(RandomAccessFile arquivo) {
        this.arquivo = arquivo;
    }

    public void abrirArquivo() {
        try {

            File fileArquivo = new File(getNomeArquivo());

            arquivo = new RandomAccessFile(fileArquivo, "rw");
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
    }

    public void fecharArquivo() {
        try {

            arquivo.close();
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
    }

    public boolean inserir(RegistroProduto registro) {
        try {

            arquivo.seek(arquivo.length());

            registro.escrita(arquivo);
            return true;
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;
    }
     
    public int posicao(String nome) {
        int posicao = -1;

        RegistroProduto registro = new RegistroProduto();
        try {

            arquivo.seek(0);
            boolean achei = false;

            while ((getArquivo().getFilePointer() < getArquivo().length()) && (achei == false)) {

                registro.leitura(arquivo);

                if (registro.getNome() == nome) {
                    achei = true;
                }

                posicao = posicao + 1;
            }

            if (achei == true) {

                return posicao;
            } else {
                return -1;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return posicao;
    }
    
     public boolean atualizar(String nome, RegistroProduto produto) {
        try {

            int posicao = posicao(nome);
            if (posicao != -1) {

                RegistroProduto registro = produto;

                arquivo.seek(posicao * registro.getTamanhoRegistro());

                registro.escrita(arquivo);
                return true;

            } else {
                return false;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;

}

    public RegistroProduto consultar(String nome) {

        RegistroProduto retorno = null;

        RegistroProduto registro = new RegistroProduto();
        try {

            arquivo.seek(0);

            registro.leitura(arquivo);

            while ((getArquivo().getFilePointer() < getArquivo().length()) && (registro.getNome() != nome)) {

                registro.leitura(arquivo);
            }

            if (registro.getNome().equals(nome)) {

                retorno = registro;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return retorno;
    }
    
     public boolean excluir(String nome) {
        int posicao = -1;

        RegistroProduto registro = new RegistroProduto();
        try {

            arquivo.seek(0);
            boolean achei = false;

            while ((getArquivo().getFilePointer() < getArquivo().length()) && (achei == false)) {
                registro.leitura(arquivo);
                if (registro.getNome() == nome) {
                    achei = true;
                }
                posicao = posicao + 1;
            }
            if (achei == true) {
                registro.setNome(null);
                arquivo.seek(posicao * registro.getTamanhoRegistro());
                registro.escrita(arquivo);
                return true;
            } else {
                return false;
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return false;
    }

  public String listar() {
        String linha = "";

        RegistroProduto registro = new RegistroProduto();
        try {

            arquivo.seek(0);

            while (getArquivo().getFilePointer() < getArquivo().length()) {

                registro.leitura(arquivo);

                if (registro.getNome() != null) {

                    linha =  linha + registro.toString() + "\n";
                }
            }
        } catch (EOFException eof) {
            System.out.println("Chegou ao final do arquivo: " + eof);
        } catch (IOException io) {
            System.out.println("Problemas ao manipular o arquivo: " + io);
        }
        return linha;
    }

}

