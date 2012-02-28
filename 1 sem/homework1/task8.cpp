#include <stdio.h>

#include <string.h>

int main()
{
	char s[80], s1[80];
	printf("vvedite stroky s ");
	scanf("%s", s);
	printf("vvedite podstroky s1 ");
	scanf("%s", s1);
	bool f = true;
	int count = 0;
	for (int i = 0; i < strlen (s); i++)
	{
		for (int j = 0; j < strlen (s1); j++)
		{
			if (s[i] == s1[j])
			{
				i++;
				f = true;
			}
			else
			{
				f = false;
				break;
			}
		}
			if (f)
			{
				count++;
			}
	}
	printf("kolichestvo vhozhdenii s1 v s = %d", count);
	return 0;
}