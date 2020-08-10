/**
*给定一个整数数组nums和一个目标值target,
*找出该数组中和为目标值的两个整数,并返回其下标。
**/
#include<stdio.h>

int target(int nums[],int target){
	
	for(int i = 0; i < 6;i++) {
		
		for(int j = i+1; j < 6; j++) {
			
			if(nums[i] == target - nums[j]){
				printf("[%d,%d]",i,j);
				break;
			}
		}
	}
	
	return 0;
}

int main(){
	
	int nums[6];
	
	printf("Please enter 6 numbers:");
	for(int i = 0; i < 6; i++) {
		scanf("%d",&nums[i]);
	}
	target(nums,9);
	
	return 0;
}