package br.com.waldson.aula11;

public class Node {
    private Node left;
    private Node right;
    private int value;


    public int getValue() { return value; }
    public Node getLeft() { return left; }
    public Node getRight() { return right; }


    public void setLeft(Node left) { this.left = left; }
    public void setRight(Node right) { this.right = right; }
    public void setValue(int value) { this.value = value; }

    public Node(int value) {
        this.value = value;
    }


    public boolean hasleft(){
        return left == null;
    }

    public boolean hasright(){
        return right == null;
    }

    public void insert(Node node) {
        if (node.value < this.value) {
            if (this.left == null) { // se não tiver nó na esquerda -> vai adicionar um novo no ali na esquerda
                this.left = node;
            } else {
                this.left.insert(node); // se já tiver, ele vai pedir para seu nó da esquerda inserir o valor
            }
        } else if (node.value > this.value) {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.insert(node);
            }
        }
    }

    public Node search(int key) {
        if (key == this.value) {
            return this;
        }

        if (key < this.value) {
            if (this.left != null) {
                return this.left.search(key);
            }
        }

        if (key > this.value) {
            if (this.right != null) {
                return this.right.search(key);
            }
        }

        return null;
    }



    public void remove(Node root, int key){

        Node temp  = null;

        // LEFT
        if(root.left.value == key){
            if(root.left.left == null && root.left.right == null){
                root.left = null; // caso seja um nó folha
            }
            else{
                // caso possuir filho(s)
                if(root.left.left == null && root.left.right != null){ // caso possuir somente um filho e for na direita
                    temp = root.left.right;
                    root.left = temp;
                }
                else if(root.left.right == null && root.left.left != null ){ // caso possuir um filho e for na esquerda
                    temp = root.left.left;
                    root.left = temp;
                }
                else{ // caso possuir dois filhos

                    temp = root.left;

                    while(root.left.hasright()) {
                        temp = temp.right; // chegando ao nó mais a direita
                    }

                    root.left.value = temp.value;

                }

            }

        }

        // RIGHT
        else if (root.right.value == key){
            if(root.right.right == null && root.right.left == null){
                root.right = null; // caso seja um nó folha
            }

            else{
                // caso possuir filho(s)
                if(root.right.left == null && root.right.right != null){ // caso possuir somente um filho e for na direita
                    temp = root.right.right;
                    root.left = temp;
                }
                else if(root.right.right == null && root.right.left != null ){ // caso possuir um filho e for na esquerda
                    temp = root.right.left;
                    root.left = temp;
                }

                else{ // caso possuir dois filhos

                    temp = root.right;

                    while(root.right.hasleft()) {
                        temp = temp.left; // chegando ao nó mais a esquerda
                    }

                    root.left.value = temp.value;

                }

            }


        }

        else if(root.value == key){
            if(root.right == null && root.left == null){
                root = null;
            }
            else{

                temp = root.right;
                while(temp.hasleft()){ //  vai pegar o nó mais a esquerda
                    temp = temp.left;
                }

                remove(root,temp.value); // removendo o nó mais a esquerda
                root.value = temp.value; // mudando o valor do root

            }
        }


        else{
            remove(root.left, key);
            remove(root.right, key);
        }


    }



















}
