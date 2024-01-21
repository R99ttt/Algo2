//Rami_AboRabia

package algo_ass2;

public class Node {
	
	private String data;
	private Node left;
	private Node right;
	//private boolean visited;

	public Node(String data) {
		this.setData(data);
		this.setLeft(null);
		this.setRight(null);
		//this.visited = false;
	}
	
	public String toString() {
		return this.data;
		
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
}
