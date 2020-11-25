#include <stdio.h>

#define MAXLEN 255 //预定最大的串长度255。

//静态数组定义串，静态数组实现定长顺序存储，当有关静态数组实现的代码执行成功后，其所占的空间会自动被回收。
struct{
    char ch[MAXLEN]; //每个分量存储一个字符串。
    int length;  //串的实际长度。
}SString;

//动态数组定义串,动态数组实现是基于堆分配存储，当有关动态数组的代码执行完之后，堆空间需要通过free函数手动回收。
struct{
    char *ch;
    int length;
}HString;

/*
 * HString S;
 * S.ch = (char *) malloc(MAXLEN * sizeof(char));
 * S.length = 0;
 * */

int f(char *s) {
    int n = 0, i;
    for(i = 0; s[i] != '\0'; i++) {
        //简单十六进制数0~15为：0，1，2，3，4，5，6，7，8，9，a，b，c，d，e，f
        //0~15对应的ASCII表为：48，49，50，51，52，53，54，55，56，97，98，99，100，101，102
        //'a'到'f'的ASCII码是97到102
        //s[i] >= 97在ASCII码表中为a及以后的字符
        //s[i] - 87表示为，如果十六进制数中某位为a,b,c,d,e,f中的某一位，则对应10进制中的10，11，12，13，14，15
        //s[i] - 48表示为，十六进制数中某位为0~9，则满足该规则
        n = n*16 + (s[i] >= 97 ? s[i] - 87:s[i] - 48);
    }
    return n;
}

int main() {
    char s[10];
    scanf("%s",s);
    printf("%d\n",f(s));
    return 0;
}