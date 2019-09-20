package br.com.waldson.aula11;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }



    public void remove(Node root, int key){

        Node temp  = null;

        // LEFT
        if(root.getLeft().getValue() == key){
            if(root.getLeft().getLeft() == null && root.getLeft().getRight() == null){ // caso for um nó folha
                root.setLeft(null); // caso seja um nó folha
            }
            else{
                // caso possuir filho(s)
                if(root.getLeft().getLeft() == null && root.getLeft().getRight() != null){ // caso possuir somente um filho e for na direita
                    temp = root.getLeft().getRight();
                    root.setLeft(temp);
                }
                else if(root.getLeft().getRight() == null && root.getLeft().getLeft() != null ){ // caso possuir um filho e for na esquerda
                    temp = root.getLeft().getLeft();
                    root.setLeft(temp);
                }
                else{ // caso possuir dois filhos

                    temp = root.getLeft();

                    while(root.getLeft().hasright()) {
                        temp = temp.getRight(); // chegando ao nó mais a direita
                    }

                    root.getLeft().setValue(temp.getValue());

                }

            }

        }

        // RIGHT
        else if (root.getRight().getValue() == key){
            if(root.getRight().getRight() == null && root.getRight().getLeft() == null){
                root.setRight(null); // caso seja um nó folha
            }

            else{
                // caso possuir filho(s)
                if(root.getRight().getLeft() == null && root.getRight().getRight() != null){ // caso possuir somente um filho e for na direita
                    temp = root.getRight().getRight();
                    root.setLeft(temp);
                }
                else if(root.getRight().getRight() == null && root.getRight().getLeft() != null ){ // caso possuir um filho e for na esquerda
                    temp = root.getRight().getLeft();
                    root.setLeft(temp);
                }

                else{ // caso possuir dois filhos

                    temp = root.getRight();

                    while(root.getRight().hasleft()) {
                        temp = temp.getLeft(); // chegando ao nó mais a esquerda
                    }

                    root.getLeft().setValue(temp.getValue());

                }

            }


        }

        else if(root.getValue() == key){
            if(root.getRight() == null && root.getLeft() == null){
                root = null;
            }
            else{

                temp = root.getRight();
                while(temp.hasleft()){ //  vai pegar o nó mais a esquerda
                    temp = temp.getLeft();
                }

                remove(root,temp.getValue()); //remove(root,temp.getValue()); // removendo o nó mais a esquerda
                root.setValue(temp.getValue()); // mudando o valor do root

            }
        }


        else{
           remove(root.getLeft(), key);
           remove(root.getRight(), key);
        }


    }









}
