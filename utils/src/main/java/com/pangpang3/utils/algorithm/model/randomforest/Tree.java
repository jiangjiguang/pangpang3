package com.pangpang3.utils.algorithm.model.randomforest;

public class Tree {
	private TreeNodeBase root;
	private int size;
	
	public TreeNodeBase getRoot() {
		return root;
	}

	public void setRoot(TreeNodeBase root) {
		this.root = root;
		this.size=size;
	}
	public int getSize(){
		return size;
	}
	public void setSize(int size){
		this.size=size;
	}
	
}
