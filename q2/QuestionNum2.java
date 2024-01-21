//Rami_AboRabia
package algo_ass2;

import java.util.ArrayList;

public class QuestionNum2 {

	public static void main(String[] args) {
		
		//creating a list with binary representation
		ArrayList<String> vertices = new ArrayList<String>();
		
		createList(vertices);// the graph, with numbers between 0 and 100
		
		//replace this number:
		int test = 3;
		
		Node root = new Node(vertices.get(test));
		ArrayList<Node> subTree = new ArrayList<Node>();
		vertices.remove(test);// to avoid duplicates
		
		createBinaryTree(vertices, root, subTree);//root is holding the tree here we build it
		
		
	}

	private static void createBinaryTree(ArrayList<String> vertices, Node root, ArrayList<Node> subTree) {
			while(!vertices.isEmpty()) {
			
			createTree(root,subTree); //building the subtrees list and connect them using Node interface
			
			for(int i = 0; i < vertices.size(); i++) {
				
				boolean toTheRight = true; //a change from 0 to 1
				boolean insert = false;
				
				int count = 0; //number of different bits
				
				int index = -1;
				
				for (Node node : subTree) {
					
					//if(subTree.size() > 1) { // we don't want to check the differences between the root and himself
						for (int j = 0; j < 7 && count < 2; j++) {
						
							if(node.getData().charAt(j) != vertices.get(i).charAt(j)) {
							
								count++;
						
								if (node.getData().charAt(j) == '1') 
									toTheRight = false;
							
							}
						
							if(count == 1)
								index = i;
						
						}
					//}
					if(count == 1) {
						
						if(toTheRight) {
							
							node.setRight(new Node(vertices.get(index)));
							vertices.remove(index);
							insert = true;

						}
						else {
							
							node.setLeft(new Node(vertices.get(index)));
							vertices.remove(index);
							insert = true;

						}
					}
					
					
				
				}
				
				if(insert == true) {
					subTree.clear();
					createTree(root,subTree); //updating the list tree
				}
			
			}
		
		}		
	}

	private static void createList(ArrayList<String> vertices) {
		for (int i = 0; i <= 100; i++) { //test <= 100
			
			String bin = Integer.toBinaryString(i);
			
			int binLength = bin.length();
			if(binLength != 7) {// test: change 3 to 7
				int diff = 7 - binLength;// adding zeros to make sure that all of the numbers are with 7 bit length
				String zeros = "0".repeat(diff);
				bin = zeros + bin;
			}
			
			vertices.add(bin);
		}		
	}

	private static void createTree(Node root, ArrayList<Node> binaryTree) {
		if(root == null)//stop condition
			return;
		
		else {
			
			if (root.getLeft() == null && root.getRight() == null) {
				binaryTree.add(root);
		    }
		      
		    if (root.getLeft() != null) { 
		    	createTree(root.getLeft(), binaryTree);
		    }
		          
		    if (root.getRight() != null) { 
		    	createTree(root.getRight(), binaryTree);
		    }
			
		}
	}

}
