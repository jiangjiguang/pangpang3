package com.pangpang3.utils.algorithm.model;

public class RandomForestParameters extends Parameters {
	private float[] parameters;
	public RandomForestParameters(float[] parameters){
		this.parameters=parameters;
	}
	public float at(int i){
		return parameters[i];
	}
}
