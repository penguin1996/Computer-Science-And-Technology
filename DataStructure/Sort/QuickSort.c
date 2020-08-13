#include<stdio.h>

int Partitions(int a[], int low, int high){
	
	int pivot = a[low]; //将当前表中的第一个元素设置为基准值，对表进行划分
	while(low < high) { //循环跳出条件
		
		while(low < high && a[high] >= pivot) --high;
		
		a[low] = a[high]; //将小于基准值的元素移动到左端
		
		while(low < high && a[low] <= pivot) ++low;
		a[high] = a[low]; //将大于基准值的元素移动到右端
	}
	
	a[low] = pivot;
	
	return low; //返回存放基准值的最终位置
}

void QuickSort(int a[], int low, int high){
	
	if(low < high){ //递归跳出的条件
		
		int partition = Partitions(a,low,high);
		
		QuickSort(a,low,partition-1); //递归小的部分
		QuickSort(a,partition+1,high);//递归大的部分
	} 
}

int main() {
	
	int b[] = {-1,49,38,65,97,76,13,27,49};
	QuickSort(b,1,8);
	for(int i = 1; i < 9; i++) {
		printf("%d ",b[i]);
	}
	return 0;
}