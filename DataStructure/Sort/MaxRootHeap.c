#include<stdio.h>

void HeadAdjust(int a[], int k, int n) { //函数HeadAdjust将元素k为根的子树进行调整

	int i;
	a[0] = a[k]; //a[0]暂存子树的根结点
	for(i = 2*k;i <= n; i*=2) {
		if(i<n && a[i]<a[i+1])
			i++; //取key较大的子结点向下筛选
		if(a[0] >= a[i]) break; //筛选结束
		else { 
			a[k] = a[i]; //将a[i]调整到双亲节点上
			k = i;	//修改k值，以便继续向下筛选
		}
	}
	a[k] = a[0]; //被筛选结点的值放入最终位置
}

void BuildMaxHeap(int a[], int n) {
	
	for(int i = n/2; i > 0; i--) //从i = n/2~1,反复的调整堆
		HeadAdjust(a,i,n);
}

void HeapSort(int a[], int n) {
	
	int i,temp;
	BuildMaxHeap(a,n); //构建初始堆
	for(i = n; i > 1 ; i--){ //n-1趟的交换和建堆过程
		temp = a[i];
		a[i] = a[1]; //输出堆顶元素和堆底元素的交换
		a[1] = temp;
		HeadAdjust(a,1,i-1); //调整，把剩余的i-1个元素整理成堆
	}
}

int main() {
	
	int b[8] = {49,38,65,97,76,13,27,49};
    int i;
    HeapSort(b,8);
    for(i=0; i<8; i++)
        printf("%d ", b[i]);
    printf("\n");
    return 0;
}