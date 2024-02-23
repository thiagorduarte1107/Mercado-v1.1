package View;

import Helper.Utils;
import Model.Produto;

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
        Mercado.menu();
    }
    private  static void fecharPedido(){
        Double valorTotal = 0.00;
        System.out.println("PRODUTOS NO CARRINHO: ");
        System.out.println("======================");
        for (Produto p : Mercado.carrinho.keySet()){
            int quant = Mercado.carrinho.get(p);
            valorTotal += p.getPreco() * quant;
            System.out.println(p);
            System.out.println("QUANTIDADE : " + quant);
            System.out.println("==================");
        }
        System.out.println("TOTAL: " + Utils.doubleParaString(valorTotal));
        Mercado.carrinho.clear();
        System.out.println("FORMA DE PAGAMENTO: ");
        System.out.println("01 - DINHEIRO \n 02 - DEBITO \n 03 - CREDITO \n 04 - PIX");
        int pg = Integer.parseInt(Mercado.teclado.nextLine());
        Utils.pausar(5);
        System.out.println("OBRIGADO E VOLTE SEMPRE.");
        Utils.pausar(5 );
        System.exit(0);
    }

    private static void listarProdutos() {
        if (Mercado.produtos.size() > 0) {
            System.out.println("LISTAGEM DE PRODUTOS ");
            System.out.println();

            for (Produto p : Mercado.produtos) {
                System.out.println(p);
                System.out.println();
            }
        } else {
            System.out.println("AINDA NÃO EXISTEM PRODUTOS CADASTRADOS. ");
        }
        Utils.pausar(2);
        Mercado.menu();
    }

    private static void comprarProdutos() {
        if (Mercado.produtos.size() > 0) {
            System.out.println("INFORME O CÓDIGO DO PRODUTO QUE DESEJA COMPRAR: ");
            System.out.println();

            System.out.println("=======PRODUTOS DISPONIVEIS======");
            for (Produto p : Mercado.produtos) {
                System.out.println(p);
                System.out.println("==============================");
            }
            int codigo = Integer.parseInt(Mercado.teclado.nextLine());
            boolean tem = false;

            for (Produto p : Mercado.produtos) {
                if (p.getCodigo() == codigo) {
                    int quant = 0;
                    try {
                        quant = Mercado.carrinho.get(p);
                        // se ja tem o produto no carrinho, atualiza a quantidade
                        Mercado.carrinho.put(p, quant + 1);
                    } catch (NullPointerException e) {
                        //Primeiro produto no carrinho
                        Mercado.carrinho.put(p , 1);
                    }
                    System.out.println("O PRODUTO " + p.getNome() + " FOI ADICIONADO AO CARRINHO. ");
                    tem = true;
                }
                if (tem) {
                    System.out.println("DESEJA ADICIONAR MAIS ITENS AO CARRINHO? ");
                    System.out.println("INFORME 1 PARA CONTINUAR COMPRANDO OU 0 PARA FINALIZAR A COMPRA: ");
                    int op = Integer.parseInt(Mercado.teclado.nextLine());

                    if (op == 1) {
                        Mercado.comprarProdutos();
                    } else {
                        System.out.println("AGUARDE ENQUANTO FECHAMOS SEU PEDIDO. ");
                        Utils.pausar(2);
                        Mercado.fecharPedido();
                    }
                } else {
                    System.out.println("NÃO FOI ENCONTRADO O PRODUTO COM O CÓDIGO " + codigo);
                    Utils.pausar(2);
                    Mercado.menu();
                }
            }


        } else {
            System.out.println("AINDA NÃO EXISTE PRODUTOS CADASTRADOS NO MERCADO. ");
            Utils.pausar(2);
            Mercado.menu();
        }
    }

    private static void visualizarCarrinho() {
        if (Mercado.carrinho.size() > 0) {
            System.out.println("PRODUTOS NO CARRINHO: ");
            for (Produto p : Mercado.carrinho.keySet()) {
                System.out.println("PRODUTO: " + p + "\n QUANTIDADE: " + Mercado.carrinho.get(p));
            }
        } else {
            System.out.println("AINDA NÃO EXISTEM PRODUTOS NO CARRINHO. ");
        }
        Utils.pausar(2);
        Mercado.menu();
    }


}
