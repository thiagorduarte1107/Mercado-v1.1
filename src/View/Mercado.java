package View;

import Helper.Utils;
import Model.Produto;
import jdk.jshell.execution.Util;

import java.util.*;

public class Mercado {
    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho;

    public static void main(String[] args) {
        produtos = new ArrayList<Produto>();
        carrinho = new HashMap<Produto, Integer>();
        Mercado.menu();
    }

    private static void menu() {
        System.out.println("=================================");
        System.out.println("========= BEM-VINDO(A) ==========");
        System.out.println("======== MERCADO CENTRAL ========");
        System.out.println("=================================");
        System.out.println(" Selecione uma opção abaixo: ");
        System.out.println("01 - CADASTRAR PRODUTO: ");
        System.out.println("02 - LISTAR PRODUTO: ");
        System.out.println("03 - COMPRAR PRODUTO: ");
        System.out.println("04 - VISUALIZAR CARRINHO: ");
        System.out.println("05 - SAIR: ");
        int opcao = 0;
        try {
            opcao = Integer.parseInt(Mercado.teclado.nextLine());
        } catch (InputMismatchException e) {
            Mercado.menu();
        } catch (NumberFormatException f) {
            Mercado.menu();
        }
        switch (opcao) {
            case 1:
                Mercado.cadastrarProduto();
                break;
            case 2:
                Mercado.listarProdutos();
                break;
            case 3:
                Mercado.comprarProdutos();
                break;
            case 4:
                Mercado.visualizarCarrinho();
                break;
            case 5:
                System.out.println("===== OBRIGADO E VOLTE SEMPRE ======");
                Utils.pausar(2);
                System.exit(0);
            default:
                ;
                System.out.println("OPÇÃO INVÁLIDA.");
                Utils.pausar(2);
                Mercado.menu();
                break;

        }
    }

    private static void cadastrarProduto() {
        System.out.println("CADASTRO DE PRODUTO");
        System.out.println("===================");
        System.out.println("INFORME O NOME DO PRODUTO: ");
        String nome = Mercado.teclado.nextLine();
        System.out.println("INFORME O PREÇO DO PRODUTO: ");
        Double preco = Mercado.teclado.nextDouble();
        Produto produto = new Produto(nome, preco);
        Mercado.produtos.add(produto);
        System.out.println("O PRODUTO " + produto.getNome() + " FOI CADASTRADO COM SUCESSO.");
        Utils.pausar(2);
    }

    private static void listarProdutos() {
        System.out.println("LISTANDO PRODUTOS ... ");
    }

    private static void comprarProdutos() {
        System.out.println("COMPRANDO PRODUTOS ... ");
    }

    private static void visualizarCarrinho() {
        System.out.println("VISUALIZANDO PRODUTOS NO CARRINHO ... ");
    }

}
