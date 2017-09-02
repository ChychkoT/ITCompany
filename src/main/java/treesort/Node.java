package treesort;

public class Node {
	
	
	public Node left;
    public Node right;
    public int value;
	
	 
	 public Node(int value) {
	  this(value, null, null);
	 }

	 public Node(int value, Node lLink, Node rLink) {
	  this.value = value;
	  this.left = lLink;
	  this.right = rLink;
	 }
	 
	 

}
