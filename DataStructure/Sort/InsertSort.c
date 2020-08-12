#include<stdio.h>

void InsertSort(int a[], int n){
	int i, j;
	for (i = 2; i <= n; i++) {//依次将a[2]~a[n]插入到前面已经排序的序列中
		if(a[i] < a[i-1]) {
			a[0] = a[i];//将待插入从数复制为哨兵
			for (j = i-1;a[j] > a[0]; j--) //从后往前查找待插入位置
				a[j+1] = a[j];
			a[j+1] = a[0];
		}
	}
}

int main(){
	
	int b[] = {-1,49,38,65,97,76,13,27,49}; //b[0]为辅助内存空间
	InsertSort(b, 8);
	for(int i = 1; i < 9; i++) {
		printf("%d ",b[i]);
	}
	return 0;
}