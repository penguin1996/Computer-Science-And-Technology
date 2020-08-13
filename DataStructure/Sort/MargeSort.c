#include<stdio.h>
#include<stdlib.h>

//声明辅助数组
//int *b = (int *)malloc((n+1)*sizeof(int));
//int *b = (int *)malloc((9)*sizeof(int));
int b[8];


//将两个有序表合并成一个有序表
void Marge(int a[], int low,int mid ,int high) {

	int i,j,k;
	//表a的两段a[low...mid]和a[mid+1...high]各自有序，将它们合并成一个有序表。
	for(k = low; k <= high; k++)
		b[k] = a[k]; //将A中所有元素复制到B中
	
	for(j = low,i = mid+1, k = j ;j <= mid&&i<=high;k++){
		
		if(b[i]<=b[j]) //比较B的左右两段中的元素
			a[k] = b[i++]; //将较小的值复制到a中
		else
			a[k] = a[j++]; //同样是将较小的值复制到a中
	} 
	
	while(i <= mid) a[k++] = b[i++]; //当第一个子表比第二个子表长时，多余的元素直接复制
	while(j <= high) a[k++] = b[j++]; //当第二个子表比第一个子表长时，多余的元素直接复制
}

void MargeSort(int a[],int low,int high) {

	if(low < high) {
		//基于分治实现递归形式的2路归并
		int mid = (low + high)/2;	//从中间划分两个子序列
		MargeSort(a,low,mid);	//对左侧子序列进行递归排序
		MargeSort(a,mid+1,high); //对右侧子序列进行递归排序
		Marge(a,low,mid,high); //归并
	}
}

int main() {

	int c[] = {49,38,65,97,76,13,27,49};
	MargeSort(c,0,7);
	for(int i = 0; i < 8; i++) {
		printf("%d ",c[i]);
	}
	return 0;

}