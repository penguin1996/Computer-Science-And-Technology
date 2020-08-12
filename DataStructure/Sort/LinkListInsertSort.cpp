/*带头结点,待完善*/
#include<stdio.h>
#include<cstdlib>

typedef struct LNode
{
	int data;
	struct LNode *next;
}LNode;

LNode* initLink() {
	
	LNode* zero = (LNode*) malloc(sizeof(LNode));
	
	if(zero == NULL) {
		return NULL;
	}
	
	zero->data = 0;
	zero->next = NULL;
	return zero;
}

void Push(LNode* zero, int element[],int length){
	
	for(int i = 0; i < length; i++) {
		LNode* node = (LNode*)malloc(sizeof(LNode));
	
		node->data = element[i];
		node->next = zero->next;
		zero->next = node;
	}
}

void InsertSort(LNode* zero, int length){
	
	for(int i = 0; i < length; i++) {
		
		int temp;
		if(zero->next->data > zero->next->next->data) {
			temp = zero->next->data;
			zero->next->data = zero->next->next->data;
			zero->next->next->data = temp;
		}
		zero = zero->next;
	}
}

int Pop(LNode* zero){
	
	LNode* temp;
	
	temp = zero->next;
	int value = temp->data;
	return value;
}

int main() {
	
	LNode* node = initLink();
	
	int element[] = {1,2,3,4,5,6};
	
	Push(node,element,6);
	
	InsertSort(node,6);
	
	for(int i = 0; i < 6; i++) {
		
		printf("%d ",Pop(node));
		
		node = node->next;
	}

	return 0;
}



