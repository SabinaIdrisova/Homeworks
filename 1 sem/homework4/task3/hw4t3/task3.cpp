#include <stdio.h>
#include <string.h>

int main()
{
	FILE *f = fopen("test.txt", "r");
	char *buf = new char[1000];
	int count = 0;
	do
	{
	    fgets(buf, 1000, f);
		int i = 0;
		while (buf[i] != '\n')
		{
			if ((buf[i] != ' ') && (buf[i] != '\t'))
			{
				count++;
				break;
			}
		}
	}
	while (!feof(f));
	delete [] buf;
	fclose(f);
	printf("%d\n", count);
	return 0;
}

