#include<stdio.h>

typedef int ElemType;

/*定义共享栈*/
#define MaxSize 10
typedef struct{
	ElemType data[MaxSize];
	ElemType top0;
	ElemType top1;
}SharedStack;

/*初始化*/
void InitStack(SharedStack &S){
	S.top0 = -1;			//初始化栈顶指针
	S.top1 = MaxSize;
}

/*判空*/
bool StackEmpty(SharedStack &S){
	if(S.top0 == -1 && S.top1 == MaxSize)
		return true;
	else
		return false;
}

/*入0号栈*/
bool PushStack0(SharedStack &S,ElemType x){
	if(S.top0+1 == S.top1)
		return false;			//判断栈满
	else
		S.data[++S.top0] = x;	//指针加1，再入栈
	return true;
}

/*入1号栈*/
bool PushStack1(SharedStack &S,ElemType x){
	if(S.top0+1 == S.top1)
		return -1;			//判断栈满
	else
		S.data[--S.top1] = x;	//指针减1，再入栈
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
