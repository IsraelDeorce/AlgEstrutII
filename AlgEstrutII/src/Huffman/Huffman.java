package Huffman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.plaf.synth.SynthSeparatorUI;


public class Huffman {	
	
	private Node root;
	private int count;	
	
	protected static final class Node{
		
		public Node father;
		public String element;
		public LinkedListOfNodes subtrees;
		
		public Node(String element){
			
			this.father = null;
			this.element = element;
			subtrees = new LinkedListOfNodes();
		}
		
		public void addSubtree(Node n){
			n.father = this;
			subtrees.add(n);					
		}		
		
		public boolean removeSubtree(Node n){
			n.father = null;
			return subtrees.remove(n);
		}
		
		public Node getSubtree(int i) {
			if(i<0 || i>=subtrees.size())				
				throw new RuntimeException("Index inválido");
			return subtrees.get(i);				
		}
		
		public int getSubtreeSize(){
			return subtrees.size();
		}
		@Override
		public String toString() {
			return "Node [father=" + father + ", element=" + element + ", subtrees=" + subtrees + "]";
		}	
	}
	
	public Huffman(){
	}
	public Huffman(String element){
	}


	@Override
	public String toString() {
		return "Huffman [root=" + root + ", count=" + count + "]";
	}
		
}
