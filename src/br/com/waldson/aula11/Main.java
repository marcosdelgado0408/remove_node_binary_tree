package br.com.waldson.aula11;

public class Main {

    public static void main(String[] args) {
        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
        Node root  = new Node(10);
        arvore.insert(root);
        arvore.insert(11);
        arvore.insert(9);
        arvore.insert(8);
        arvore.insert(16);

        arvore.remove(root,8);

        Node n = arvore.search(80);
        if (n != null) {
            System.out.println("Elemento encontrado");
        } else {
            System.out.println("Elemento não encontrado");
        }
    }
}
