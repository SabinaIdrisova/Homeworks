#include <stdio.h>
#include "hash.h"
#include "list.h"
#include <string.h>

int const hashLength = 1000;

struct Hash
{
	List *h[hashLength];
};

Hash *createHash()
{
	Hash *result = new Hash;
	for (int i = 0; i < hashLength; i++)
	    result->h[i] = NULL;
	return result;
}

int hash1(char word[])
{
	int result = 0;
	for (int i = 0; i < strlen(word); ++i)
		if ((word[i] >= 'A' && word[i] <= 'Z') || (word[i] >= 'a' && word[i] <= 'z'))
			result = (result + word[i]) % hashLength;
	return result;
}

bool findWord(Hash *hash, char word[])
{
	return strcmp(hash->h[hash1(word)]->string, word) == 0;
}

void add(Hash *hash, char word[])
{
	int const hashValue = hash1(word);
	if (hash->h[hashValue] == NULL)
	{
		hash->h[hashValue] = new List();
		strcpy(hash->h[hashValue]->string, word);
		hash->h[hashValue]->next = NULL;
		hash->h[hashValue]->count = 1;
		return;
	}
	else
	{
		List *temp = hash->h[hashValue];
		bool same = findWord(hash, word);
		if (same)
			temp->count++;
		else
		{
			List *list = new List();
			strcpy(list->string, word);
			list->next = NULL;
			list->count = 1;
			temp->next = list;
		}
	}
}

void print(Hash *hash)
{
    for (int i = 0; i < hashLength; i++)
        if (hash->h[i])
		{
	        List *temp = hash->h[i];
			while (temp)
			{
				printf("%s\t\t%d\n", temp->string, temp->count);
				List *t = temp;
				temp = temp->next;
				delete (t);
			}
		}
}

