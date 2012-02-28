#include <stdio.h>

int degree(int a, int n)
{ 
    int result = 1; 
    while (n) 
        if (n % 2 == 0)
        { 
            a *= a;
			n /= 2; 
        } 
        else 
        { 
            result *= a;
			n--; 
        } 
    return result; 
} 

int main()
{
	int a = 0;
	int n = 0;
printf("vvedite osnovanie stepeni a i pokazatel stepeni n\n");
scanf("%d%d", &a, &n);
printf("a^n = %d", degree(a, n));
return 0;
}

