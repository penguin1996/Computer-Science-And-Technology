#include<stdio.h>

void ShellSort(int a[], int n) {
	
	int d,i,j;
	for(d = n/2; d >= 1; d = d/2) {
		
		for(i = d+1; i <= n ; i++ ) {
			
			if(a[i] < a[i-d]) {
				
				a[0] = a[i];
				for(j = i-d; j>0 && a[0]<a[j]; j-=d)
					a[j+d] = a[j];
				a[j+d] = a[0];
			} 
		}
	}
}

int main(){
	
	int b[] = {-1,49,38,65,97,76,13,27,49,55,04};
	
	ShellSort(b,10);

	for(int i = 1; i < 11; i++) {
		printf("%d ",b[i]);
	}
	return 0;
}