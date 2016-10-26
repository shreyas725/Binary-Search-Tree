package valkyrie;

import java.util.Scanner;

public class BinarySearchTree  {

	public Node root;
	public BinarySearchTree(){
		this.root = null;
	}

	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}

	public void insert(int id){
		Node newNode = new Node(id);
		if(root==null){
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while(true){
			parent = current;
			if(id<current.data){				
				current = current.left;
				if(current==null){
					parent.left = newNode;
					return;
				}
			}else{
				current = current.right;
				if(current==null){
					parent.right = newNode;
					return;
				}
			}
		}
	}

	private int getLevelUtil(Node node, int data, int level)
	{
		if (node == null)
			return 0;

		if (node.data == data)
			return level;

		int downlevel = getLevelUtil(node.left, data, level+1);
		if (downlevel != 0)
			return downlevel;

		downlevel = getLevelUtil(node.right, data, level+1);
		return downlevel;
	}

	/* Returns level of given data value */
	public int getLevel(int data)
	{
		return getLevelUtil(root,data,1);
	}

	private class Node{
		int data;
		Node left;
		Node right;	
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		BinarySearchTree bst = new BinarySearchTree();
		String line = "";
		int a, b;
		a = Integer.parseInt(scanner.nextLine());
		b = Integer.parseInt(scanner.nextLine());
		line = scanner.nextLine();
		for (String s : line.split("\\s")) 
			bst.insert(Integer.parseInt(s));
		scanner.close();
		if(bst.find(a) && bst.find(b)) {
			int heightA = bst.getLevel(a);
			int heightB = bst.getLevel(b);
			System.out.println(Math.abs(heightA - heightB));
		}
		else 
			System.out.println("Not found");			

	}

}
