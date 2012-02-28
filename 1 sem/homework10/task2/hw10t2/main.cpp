#include <stdio.h>
#include <locale.>

void minDistance(int ind, int whichMin[], int distance[], int number, int array[20][20])
{
	for (int i = 0; i < number; i++)
		if ((array[ind][i] != 0) && (distance[i] > array[ind][i]))
		{
			distance[i] = array[ind][i];
			whichMin[i] = ind;
		}
}

int main()
{
	int array[20][20];
	setlocale(LC_ALL, "Rus");
	int const size = 10;
	int whichMin[size];
	int number = 0;
	FILE *file = fopen("test.txt", "r");
	fscanf(file, "%d", &number);
	for (int i = 0; i < number; i++)
		for (int j = 0; j < number; j++)
			fscanf(file, "%d", &array[i][j]);
	fclose(file);
	int distance[size];
	char used[size];
	for (int i = 0; i < number; i++)
		distance[i] = 100000;
	for (int i = 0; i < number; i++)
		used[i] = 0;
	printf("Добавление узла %c\n", 0 + 'A');
	used[0] = 1;
	minDistance(0, whichMin, distance, number, array);
	int sum = 0;
	for (int j = 1; j < number; j++)
	{
		int min = -1;
		for (int i = 0; i < number; i++)
			if (!used[i])
				if ((min == -1) || (distance[i] < distance[min]))
					min = i;
		printf("Добавление вершины %c-%c\n", whichMin[min] + 'A', min + 'A');
		used[min] = 1;
		sum += distance[min];
		minDistance(min, whichMin, distance, number, array);
	}
	printf("Полное расстояние: %d\n", sum);
	return 0;
}