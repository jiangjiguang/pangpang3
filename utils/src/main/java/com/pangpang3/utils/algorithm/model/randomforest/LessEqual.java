package com.pangpang3.utils.algorithm.model.randomforest;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LessEqual extends Function {
	@Override
	public boolean apply(float left,float right) {
		return Float.compare(left, right)<=0;
		//return bdleft.compareTo(bdright)<=0;
		//return Double.compare(left, right)<=0;
	}
	@Override
	public String toString() {
		return "<=";
	}
}
