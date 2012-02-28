#include <stdio.h>
#include <string.h>
#include "list.h"
#include "hash.h"

int main()
{
	Hash *hash = createHash();
	int const wordLength = 25;
	char word[wordLength];
    FILE *file = fopen("test.txt", "r");
	while (!feof(file))
	{
		char c = fgetc(file);
		if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
		{   
			ungetc(c, file);
			fscanf(file, "%s ", word);
			add(hash, word);
		}
	}
	print(hash);
	fclose(file);
    return 0;
}
