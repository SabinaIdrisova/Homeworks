#include <stdio.h>
#include <string.h>
int main ()

{
	int count = 0;
	char str[80];
	scanf("%s", str);
	for (int i = 0; i < strlen(str); i++)
	{
		if (str[i] == '(')
			count++;
		else count--;
		if (count < 0)
		{
			printf("pravilo vlogennosti skobok ne sobludeno\n");
			break;
		}
	}
	if (count == 0)
		printf("balans\n");
	else
		printf("disbalans\n");
}



