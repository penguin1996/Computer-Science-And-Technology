#include <stdio.h>
#include <stdbool.h>


#define MAXLEN 255 //预定最大的串长度255。

//静态数组定义串，静态数组实现定长顺序存储，当有关静态数组实现的代码执行成功后，其所占的空间会自动被回收。
typedef  struct{
    char ch[MAXLEN]; //每个分量存储一个字符串。
    int length;  //串的实际长度。
}SString;

//动态数组定义串,动态数组实现是基于堆分配存储，当有关动态数组的代码执行完之后，堆空间需要通过free函数手动回收。
typedef struct{
    char *ch;
    int length;
}HString;

/*
 * HString S;
 * S.ch = (char *) malloc(MAXLEN * sizeof(char));
 * S.length = 0;
 * */

//求子串,用Sub返回串S的第pos个字符起长度为len的子串
bool SubString(SString *Sub,SString S, int pos, int len){

    //子串范围越界
    if(pos+len-1 > S.length){
        return false;
    }

    for(int i = pos; i < pos + len; i++){
        Sub->ch[i-pos+1] = S.ch[i];
        Sub->length = len;
    }
    return true;
}

//子串与主串的比较操作。若S>T,则返回值 > 0; 若S = T, 则返回值 = 0； 若S < T, 则返回值 < 0
int StrCompare(SString S,SString T) {
    for (int i = 1; i <= S.length && i <= T.length; i++) {
        if(S.ch[i] != T.ch[i]) {
            return S.ch[i] - T.ch[i];
        }
    }
    //扫描过的所有字符都相同，则长度长的串更大
    return S.length - T.length;
}

//定位操作。若主串S中存在与串T值相同的子串，则返回它在主串S中第一次出现的位置，否则函数值为0.
int Index(SString S, SString T) {
    int i = 1, n = S.length, m = T.length;
    SString *sub;
    while(i <= n-m+1) {
        SubString(sub,S,i,m);
        if(StrCompare(*sub,T) != 0) ++i;
        else return i; //返回子串在主串的位置
    }
    return 0;   //S中不存在与T相同的子串
}

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