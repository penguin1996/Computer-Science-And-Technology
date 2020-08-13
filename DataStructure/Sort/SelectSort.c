#include<stdio.h>

void SelectSort(int a[], int n) {
	
	int i,j,temp,min;
	for(i=0;i<n-1;i++) {
		
		min = i;
		for(j=i+1;j<n;j++) 
		if(a[j] < a[min]) min = j;
		
		if(min!=i){
			temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}
}

int main() {
	
	int b[] = {49,38,65,97,76,13,27,49};
	SelectSort(b,8);
	for(int i = 0; i < 8; i++) {
		printf("%d ",b[i]);
	}
	return 0;
}