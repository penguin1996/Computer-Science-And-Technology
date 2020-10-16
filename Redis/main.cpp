#include <iostream>
typedef struct listNode {
    struct listNode *prev;
    struct listNode *next;
    void *value;
} listNode;

typedef struct list {
    listNode *head;
    listNode *tail;
    unsigned long len;
}list;

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}