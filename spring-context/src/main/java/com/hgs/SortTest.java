package com.hgs;

import java.util.Arrays;

public class SortTest {

	public int[] sort(int[] sourceArray){
		int [] arr = Arrays.copyOf(sourceArray,sourceArray.length);
		return bubbleSort(arr);
	}

	/**
	 * 冒泡排序只会操作相邻的两个元素进行比较，看是否满足大小关系要求，如果不满足就让它两互换，一次冒泡会让至少一个元素
	 * 移动到它应该在的位置，重复n次，就完成了n个数据的排序工作
	 * 时间复杂度 ：O(n^2)，空间复杂度：O(n)
	 * @param ary
	 * @return
	 */
	public int[] bubbleSort(int[] ary){
		for(int i=0;i<ary.length-1;i++){//length-1 是因为1个元素不用排
			boolean flag = false;
			for(int j = 0;j<ary.length-1-i;j++){//-i 是因为每一趟都选好一个元素
				if(ary[j]>ary[j+1]){
					ary[j] = ary[j]+ary[j+1];
					ary[j+1] = ary[j]-ary[j+1];
					ary[j] = ary[j] - ary[j+1];
//					int a = ary[j];
//					ary[j] = ary[j+1];
//					ary[j+1] = a;
					flag = true;
				}
			}
			if(!flag){
				//如果一次都没有交换，说明它是有序的
				break;
			}
		}
		return ary;
	}

	/**
	 * 快速排序
	 * 1.找一个基准数，把大于基准数的放右边，小于基准数的放左边
	 * 2.直到左边的数都比基数数小，右边的数都比基准数大
	 * 继续重复上面 1,2 两步
	 * 递归的进行
	 * @param ary
	 * @return
	 */
	public void quickSort(int[] ary,int left,int right){
		if(left > right){
			return;
		}
		int ll = left;
		int rr = right;
		int base = ary[left];
		//左边的必须小于右边的
		while(ll<rr){
			//如果右边的大指针就往前左边移动
			while (ll<rr && base<=ary[rr]){
				rr--;
			}
			if(ll<rr){
				int temp = ary[ll];
				ary[ll]= ary[rr];
				ary[rr] = temp;
				ll++;
			}
			//如果左边的小指针就往右边移动
			while (ll<rr && base>= ary[ll]){
				ll ++;
			}
			if(ll<rr){
				int temp = ary[ll];
				ary[ll]= ary[rr];
				ary[rr] = temp;
				rr--;
			}
		}
//		ary[left] = ary[ll];
//		ary[ll] = base;
		quickSort(ary,left,rr-1);
		quickSort(ary,rr+1,right);
	}

	/**
	 * 插入排序
	 * 找出合适的位置，数组往后移动
	 * @param ary
	 */
	public void insertSort(int[] ary){
		for(int i =1 ;i<ary.length;i++){
			int current = ary[i];
			int preIndex = i-1;
			//跟前面的比，如果前面的大，则数据往后移动
			while(preIndex>=0 && ary[preIndex]>current){
				ary[preIndex+1] = ary[preIndex];
				preIndex --;
			}
			ary[preIndex+1] = current;
		}
	}

	/**
	 * 每次选择最小的下标，然后替换
	 * @param ary
	 */
	public void selectSort(int[] ary){
		for(int i =0 ;i<ary.length-1;i++){
			int minIdex = i;
			for(int j=i+1;j<ary.length;j++){
				while (ary[j]<ary[minIdex]){
					minIdex = j;
				}
			}
			int base = ary[i];
			ary[i] = ary[minIdex];
			ary[minIdex] = base;
		}
	}

	public static void main(String[] args) {
		SortTest test = new SortTest();
		int ary[] = {2, 33, 4, 1, 55, 6, 7, 56, 9, 98, 22};
//		int[] arysort = test.sort(ary);
//		test.quickSort(ary,0,ary.length-1);
//		test.insertSort(ary);
		test.selectSort(ary);
		System.out.print("排序后：");
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		System.out.println();
	}
}
