
 
public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private int key;

    public Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }
    
  

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }
    
    public void setParent(Node parent){
        this.parent=parent;
    }

    public Node getLeftChild() {
        return left;
    }

    public Node getRightChild() {
        return right;
    }

    public int getKey() {
        return key;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public void print(){
        System.out.println("The Key is "+""+getKey());
    }

}
