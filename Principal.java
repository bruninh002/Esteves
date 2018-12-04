import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		//faça algo pra ler arquivo aqui, carregar a lista de produtos
		
		ArrayList<Produto> listaProdutos = new ArrayList();
		
		
		int menu = -1;
		while(menu != 0) {
		
		menu = Integer.parseInt(JOptionPane.showInputDialog(" XYZ COMERCIO DE PRODUTOS LTDA.\r\n" + 
				"SISTEMA DE CONTROLE DE ESTOQUE\r\n\n" + 
				"MENU PRINCIPAL\r\n\n" + 
				"1 - CADASTRO DE PRODUTOS\r\n" + 
				"2 - MOVIMENTAÇÃO\r\n" + 
				"3 - REAJUSTE DE PREÇOS\r\n" + 
				"4 - RELATÓRIOS\r\n" + 
				"0 - FINALIZAR\r\n"));
		if (menu == 1) {
			int subMenu = -1;
			while(subMenu != 0) {
				subMenu = Integer.parseInt(JOptionPane.showInputDialog("XYZ COMERCIO DE PRODUTOS LTDA.\r\n" + 
						"SISTEMA DE CONTROLE DE ESTOQUE\r\n" + 
						"CADASTRO DE PRODUTO\r\n" + 
						"1 - INCLUSÃO\r\n" + 
						"2 - ALTERAÇÃO\r\n" + 
						"3 - CONSULTA\r\n" + 
						"4 - EXCLUSÃO\r\n"));
				if (subMenu == 0) {
					int flagNext = 0;
					String nome = JOptionPane.showInputDialog("Nome:");
					for (Produto verifica : listaProdutos) {
						if(verifica.getNome().equals(nome)) {
							JOptionPane.showMessageDialog(null, "Produto ja cadastrado.");
							flagNext = 1;
						}
						if(flagNext == 1) {
							
							double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
							int unidade = Integer.parseInt(JOptionPane.showInputDialog("Unidade:"));
							int quantidadeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
							
							Produto p = new Produto();
							p.setNome(nome);
							p.setPrecoUnitario(preco);
							p.setQtdEstoque(quantidadeEstoque);
							p.setUnidade(unidade);
							
							String confirma = JOptionPane.showInputDialog("CONFIRMA ALTERAÇÃO (S/N) ?");
							if(confirma.equalsIgnoreCase("S")) {
								listaProdutos.add(p);
								//persistir no arquivo
							}else if(confirma.equalsIgnoreCase("N")){
								JOptionPane.showMessageDialog(null, "Cadastrado cancelado");
							}
						}
					}
					
					
				}else if (subMenu == 2) {
					String nome = JOptionPane.showInputDialog("Nome:");
					for (int i = 0; i < listaProdutos.size(); i++) {
						if(listaProdutos.get(i).getNome().equals(nome)) {
							String opcao = JOptionPane.showInputDialog("Produto ja cadastrado. \n"+
							"Nome: " + listaProdutos.get(i).getNome() 
							+ "Preço: " + listaProdutos.get(i).getPrecoUnitario()
							+ "Unidade:" + listaProdutos.get(i).getUnidade()
							+ "Quantidade" + listaProdutos.get(i).getQtdEstoque()
							+ "CONFIRMA ALTERAÇÃO? (S/N) ?");
							
							if(opcao.equalsIgnoreCase("S")) {
								
								double preco = Double.parseDouble(JOptionPane.showInputDialog("Pre�o:"));
								int unidade = Integer.parseInt(JOptionPane.showInputDialog("Unidade:"));
								int quantidadeEstoque = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));
								
								listaProdutos.get(i).setPrecoUnitario(preco);
								listaProdutos.get(i).setUnidade(unidade);
								listaProdutos.get(i).setQtdEstoque(quantidadeEstoque);
								
								//PERSSITIR EM ARQUIVO
								
							}else if(opcao.equalsIgnoreCase("N")){
								JOptionPane.showMessageDialog(null, "Alteração cancelado");
							}
						}else{
							JOptionPane.showMessageDialog(null, "Produto não cadastrado");
						}
					}
					
					
				}else if (subMenu == 3) {
					String nome = JOptionPane.showInputDialog("Nome:");
					for (int i = 0; i < listaProdutos.size(); i++) {
						if(listaProdutos.get(i).getNome().equals(nome)) {
							JOptionPane.showMessageDialog(null, "Produto: \n"+
							"Nome: " + listaProdutos.get(i).getNome() 
							+ "Preço: " + listaProdutos.get(i).getPrecoUnitario()
							+ "Unidade:" + listaProdutos.get(i).getUnidade()
							+ "Quantidade" + listaProdutos.get(i).getQtdEstoque());
						}else {
							JOptionPane.showMessageDialog(null, "Produto não existe");
						}
					}
				}else if (subMenu == 4) {
					String nome = JOptionPane.showInputDialog("Nome:");
					for (int i = 0; i < listaProdutos.size(); i++) {
						if(listaProdutos.get(i).getNome().equals(nome)) {
							String opcao = JOptionPane.showInputDialog("Produto ja cadastrado. \n"+
							"Nome: " + listaProdutos.get(i).getNome() 
							+ "Preço: " + listaProdutos.get(i).getPrecoUnitario()
							+ "Unidade:" + listaProdutos.get(i).getUnidade()
							+ "Quantidade" + listaProdutos.get(i).getQtdEstoque()
							+ "CONFIRMA EXCLUSÃO? (S/N) ?");
							if(opcao.equalsIgnoreCase("S")) {
								listaProdutos.remove(i);
								
								//PERSSITIR EM ARQUIVO
							}else if(opcao.equalsIgnoreCase("N")){
								JOptionPane.showMessageDialog(null, "Exclusão cancelada");
							}
							
					
				}else if (subMenu == 0) {
					JOptionPane.showMessageDialog(null, "Voltando ao menu principal.");
				}
				
			}
			
			
			
			
		}else if (menu == 2) {
			
		}else if (menu == 3) {
			
		}else if (menu == 4) {
			
		}
		
		
		
		}
		
	}
		}
	}
}


