package com.pangpang3.utils.algorithm.model.randomforest;

public class RandomForest {
	TreeNodeBase[] roots;
	
	public RandomForest(TreeNodeBase[] roots){
		this.roots=roots;
	}
	
	public TreeNodeBase tree(int index){
		return roots[index];
	}
	public int treeCount(){
		return roots.length;
	}
}
