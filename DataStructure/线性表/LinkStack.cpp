/**
*带头结点的链栈实现
*参考连接：https://blog.csdn.net/wangxiaobupt/article/details/26751797
*https://blog.csdn.net/qlzx_syzx/article/details/81415283
*https://www.cnblogs.com/yiluyisha/p/9268415.html
*https://www.iteye.com/blog/chinrui-1856347
**/
#include<stdio.h>
#include<cstdlib>

struct StackNode{
	int data;
	StackNode *next;
};

/*struct linkStack {
	StackNode *top; //栈顶指针
	int count;	//计数器
};*/

//链栈的初始化,创建头结点
StackNode* initLinkStack() {

	StackNode *head = (StackNode*)malloc(sizeof(StackNode));
	
	if(head == NULL) {
		printf("Allocate Memory failed.\n");
		return NULL;
	}
	
	head->data = 0;
	head->next = NULL;
	return head;
}

//数据入栈
void Push(StackNode* head, int element) {
	
	if(head == NULL) {
		printf("The head node don't exist!");
		return;
	}
	
	StackNode* node = (StackNode*)malloc(sizeof(StackNode));
	if(node == NULL){
		printf("Error!");
		return;
	}
	
	node->data = element;
	node->next = head->next;
	head->next = node;
}

//数据出栈
int Pop(StackNode* head) {
	
	if(head == NULL||head->next == NULL) {
		printf("Error!");
	}
	
	StackNode* temp = head->next;
	head->next = temp->next;
	int value = temp->data;
	free(temp);
	return value;
}

//栈的长度
int getLinkStackLength(StackNode* head){
	
	if(head == NULL||head->next == NULL) {
		return 0;
	}
	
	int length = 0;
	StackNode* p = head->next;
	while(p != NULL) {
		length++;
		p = p->next;
	}
	
	return length;
}

int main() {
	StackNode* head = NULL;
	printf("initStack");
	head = initLinkStack();
	Push(head, 3);
	Push(head, 2);
	Push(head, 1);
	printf("output the length of the stack:");
	printf("%d\n",getLinkStackLength(head));
	printf("%d\n",Pop(head));
	printf("%d\n",Pop(head));
	printf("output the length of the stack:");
	printf("%d\n",getLinkStackLength(head));
	printf("%d\n",Pop(head));
	printf("output the length of the stack:");
	printf("%d\n",getLinkStackLength(head));
	return 0;
}
