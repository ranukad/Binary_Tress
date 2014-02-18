
public class BinaryTree {

    public  Node root;
    public Node returnNode;

    // constructor 
    public BinaryTree() {
        root = null;
    }
    
    // pass the root Node
    public Node getRoot() {
        return root;
    }

    // inserting a node to the tree
    public void insert(int key) {

        Node newInsertnode = new Node(key);

        if (root == null) {
            root = newInsertnode;
        } else {

            traverseAndAddNode(root, newInsertnode);

        }
    }

    public boolean delete(int value) {

        Node nodeTobeDeleted = find(value);

        if (nodeTobeDeleted != null) {
            if (nodeTobeDeleted.getLeftChild() == null && nodeTobeDeleted.getRightChild() == null) {
                // Where Both leftchild and rightChild doesnot exsit in the tree
                deleteCase1(nodeTobeDeleted);
            }
             else if (nodeTobeDeleted.getLeftChild() != null) {
                // Where leftChild should be Deleted
                deleteCase2(nodeTobeDeleted);
            } else if (nodeTobeDeleted.getRightChild() != null && nodeTobeDeleted.getLeftChild() != null) {
                // Where rightChild Should be Deleted 
                deleteCase3(nodeTobeDeleted);
            }
            else if (nodeTobeDeleted.getRightChild()!=null){
                deleteCase2(nodeTobeDeleted);
            }
        }

        return false;
    }

    private void deleteCase1(Node nodeTobeDeleted) {

        if (nodeTobeDeleted.getParent().getLeftChild() == nodeTobeDeleted) {

            nodeTobeDeleted.getParent().setLeftChild(null);

        } else if (nodeTobeDeleted.getParent().getRightChild() == nodeTobeDeleted) {

            nodeTobeDeleted.getParent().setRightChild(null);

        }
    }

    public Node find(int value) {
        if (root != null) {

            return findNode(root, new Node(value));
        }
        return null;
    }

    private Node findNode(Node search, Node node) {

        if (search == null) 
            return null;
        
        if (search.getKey() == node.getKey()) {
            return search;

        } 
        else {
            returnNode = findNode(search.getLeftChild(), node);
        
        if (returnNode == null) {
            returnNode = findNode(search.getRightChild(), node);
        }
        return returnNode;
       }
      
    }

    private void deleteCase2(Node nodeTobeDeleted) {

        if (nodeTobeDeleted.getParent().getLeftChild() == nodeTobeDeleted) {

            if (nodeTobeDeleted.getLeftChild() != null) {

                nodeTobeDeleted.getParent().setLeftChild(nodeTobeDeleted.getLeftChild());
                
            } else if (nodeTobeDeleted.getRightChild() != null) {
                nodeTobeDeleted.getParent().setLeftChild(nodeTobeDeleted.getRightChild());
            }
        } 
        else if (nodeTobeDeleted.getParent().getRightChild() == nodeTobeDeleted) {

            if (nodeTobeDeleted.getLeftChild() != null) {

              nodeTobeDeleted.getParent().setRightChild(nodeTobeDeleted.getLeftChild());
                
            } else if (nodeTobeDeleted.getRightChild() != null) {
                nodeTobeDeleted.getParent().setRightChild(nodeTobeDeleted.getRightChild());
            }

        }
    }

    private void deleteCase3(Node nodeTobeDeleted) {

        Node minNode = minLeftTraversal(nodeTobeDeleted.getRightChild());

        deleteCase2(minNode);

        minNode.setParent(nodeTobeDeleted.getParent());
        minNode.setLeftChild(nodeTobeDeleted.getLeftChild());
        minNode.setRightChild(nodeTobeDeleted.getRightChild());

        if (nodeTobeDeleted.getParent() == null) {
            root = minNode;
        } else {
            if (nodeTobeDeleted.getParent().getLeftChild() == nodeTobeDeleted) {

                nodeTobeDeleted.getParent().setLeftChild(minNode);

            } else if (nodeTobeDeleted.getParent().getRightChild() == nodeTobeDeleted) {

                nodeTobeDeleted.getParent().setRightChild(minNode);
            }
        }
    }

    private Node minLeftTraversal(Node node) {
        if (node.getLeftChild() == null) {
            return node;
        }
        return minLeftTraversal(node.getLeftChild());
    }

    // find the place before adding the node
    private void traverseAndAddNode(Node node, Node newInsertnode) {
        if (newInsertnode.getKey() < node.getKey()) {

            if (node.getLeftChild() == null) {

                newInsertnode.setParent(node);
                node.setLeftChild(newInsertnode);

            } else {

                traverseAndAddNode(node.getLeftChild(), newInsertnode);
            }

        } else if (newInsertnode.getKey() > node.getKey()) {

            if (node.getRightChild() == null) {

                newInsertnode.setParent(node);
                node.setRightChild(newInsertnode);
            } else {

                traverseAndAddNode(node.getRightChild(), newInsertnode);
            }
        }
    }

    // taverse the tree through the nodes
    public void traverse() {
        if (root != null) {
                // if the root is empty there is no tree to be traverse , so the game close 
                // if not the root is not empty 
            Node nodetreverse = root;
            if (nodetreverse.getLeftChild() == null && nodetreverse.getRightChild() == null) {
                System.out.println(nodetreverse.getKey());
            } else 
            {
                if (nodetreverse.getLeftChild() != null) 
                {
                    
                    // if the left child of the node is null recursive call for the method Inordertraverse
                    Inordertraverse(nodetreverse.getLeftChild());

                }
                if (nodetreverse.getRightChild() != null) 
                {
                     
                    // if the right child of the node null recursive call for the method Inordertraverse
                    Inordertraverse(nodetreverse.getRightChild());

                }
            }

        }

    }
    
    // transversal through the nodes and print the nodes
    private void Inordertraverse(Node node) {

        if (node.getLeftChild() != null) {

            Inordertraverse(node.getLeftChild());

        }
        System.out.println(node.getKey());

        if (node.getRightChild() != null) {

            Inordertraverse(node.getRightChild());
        }
    }

}
