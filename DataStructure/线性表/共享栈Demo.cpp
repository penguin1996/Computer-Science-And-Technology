#include<stdio.h>

typedef int ElemType;

/*���干��ջ*/
#define MaxSize 10
typedef struct{
	ElemType data[MaxSize];
	ElemType top0;
	ElemType top1;
}SharedStack;

/*��ʼ��*/
void InitStack(SharedStack &S){
	S.top0 = -1;			//��ʼ��ջ��ָ��
	S.top1 = MaxSize;
}

/*�п�*/
bool StackEmpty(SharedStack &S){
	if(S.top0 == -1 && S.top1 == MaxSize)
		return true;
	else
		return false;
}

/*��0��ջ*/
bool PushStack0(SharedStack &S,ElemType x){
	if(S.top0+1 == S.top1)
		return false;			//�ж�ջ��
	else
		S.data[++S.top0] = x;	//ָ���1������ջ
	return true;
}

/*��1��ջ*/
bool PushStack1(SharedStack &S,ElemType x){
	if(S.top0+1 == S.top1)
		return -1;			//�ж�ջ��
	else
		S.data[--S.top1] = x;	//ָ���1������ջ
	return true;
}

int PopStack(ElemType x){
	
	return x;
} 

int main(){
	
	SharedStack S;
	InitStack(S);
	ElemType x;
	
	for(int i = 1; i <= MaxSize/2; i++){
		PushStack0(S,i);
		PushStack1(S,MaxSize-i+1);
	}
	
	printf("top_Stack0:");
	for(int i = 0; i < MaxSize/2; i++) {
		
		printf("%d ",PopStack(S.data[S.top0-i]));
	}
	printf("\ntop_Stack1:");
	for(int i = 0; i < MaxSize/2; i++) {
	
		printf("%d ",PopStack(S.data[S.top1+i]));
	}
	
	return 0;
}
