package treesort;

import org.apache.log4j.Logger;

public class TreeSort {
	
	private static final Logger LOGGER = Logger.getLogger(TreeSort.class);

    public Node root;
 
    public TreeSort (Node root) {
        this.root = root;
    }
    

    
    public void insert(int value) {
        if(root == null) {
            this.root = new Node(value);
        } else {
            this.root = insert(this.root, value);
        }
    }

    private Node insert(Node node, int value) {
        if(node == null) {
            return new Node(value);
        } else if(node.value < value) {
            node.right = insert(node.right, value);
        } else if(node.value > value) {
            node.left = insert(node.left, value);
        }
        return node;
    }
    
    public void printRightToLeft(Node node) {
        if(node != null) {
            if(node.right != null) {
                printRightToLeft(node.right);
            }
            LOGGER.info(((Integer)node.value).intValue() + " ");
            if(node.left != null) {
                printRightToLeft(node.left);
            }
        }
    }
    
     
    public void printLeftToRight(Node node) {
        if(node != null) {
            if(node.left != null) {
                printLeftToRight(node.left);
            }
            LOGGER.info(((Integer)node.value).intValue() + " ");
            if(node.right != null) {
                printLeftToRight(node.right);
            }
        }
    }
	
    public void delete(int value) {
        this.root = delete(this.root, value);
    }
    
    public Node delete(Node node, int value) {
        if(node.value < value) {
            node.right = delete(node.right, value);
        } else if(node.value > value) {
            node.left = delete(node.left, value);
        } else {
            if(node.right == null) {
                return node.left;
            }
            if(node.left == null) {
                return node.right;
            }
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }
	
    private Node min(Node node) {
        if(node.left == null) {
            return node;
        } else {
            return min(node.left);
        }
    }   
    
    private Node deleteMin(Node node) {
        if(node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

	}

