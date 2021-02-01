#include<stdio.h>
 
void halfInsertSort(int a[], int n){
	
	int i , j;
	int low , high, mid;
	
	for(i = 2; i <= n ; i++) {
		if(a[i] < a[i-1]){
			a[0] = a[i];
			low = 1;
			high = i-1;
			while(low <= high){
				mid = (low + high)/2;
				if(a[mid] > a[0])
					high = mid - 1; 
				else low = mid + 1; 
			}
			
			for(j = i - 1; j >= high + 1; --j)
				a[j+1] = a[j]; 
			//a[high+1] = a[0]; 
			a[j+1] = a[0];			
		}
	}
}

int main() {

	int i;
	int b[] = {-1,49,38,65,97,76,13,27,49};
	halfInsertSort(b, 8);
	for(i = 1; i < 9; i++){
		printf("%d ",b[i]);
	}
	return 0;
}
