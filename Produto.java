/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pichau
 */
public class Produto {
 
    private String nome;
    private double precoUnitario;
    private int unidade;
    private double qtdEstoque;

 
    public Produto(){
    
    this("",0.0,0,0.0);
    
    }
    
    public Produto (String nome, double precoUnitario, int unidade, double qtdEstoque){
    
    setNome(nome);
    setPrecoUnitario(precoUnitario);
    setUnidade(unidade);
    setQtdEstoque(qtdEstoque);
    
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
    
    
     @Override
    public String toString() {
        return ("Nome: " + getNome() + " \\ Preço Unitário: " + getPrecoUnitario()
                + "\\ Unidade: " + getUnidade() + " \\ Quantidade em Estoque "
                + getQtdEstoque());
    }
}
