package com.hgs;

import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {
//		给定无限个不同重量的金属球和一个总重量，求可以凑成总重量所需的最少球的个数， 如果凑不成返回-1,例如：
//		输入：ball_weights = [1, 2 , 5],  amount=11
//		输出：3          11=5+5+1
		int[] ary = {1,2,5};
	}

	public int test(int[] ary,int max){
		if(max<=0){
			return -1;
		}
		//排好序的
		if(ary[0]>max){
			return -1;
		}

		for (int i = 0; i < ary.length; i++) {

		}


		return -1;
	}
}
