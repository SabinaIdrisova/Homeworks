#include <stdio.h>

void closestToCapital(int cities, int capitals[], int roads[20][20], int &nearestCity, int &min, int currentCity)
{
	for (int j = 0; j <= cities; j++)
		{
			if (roads[capitals[currentCity]][j] > 0)
			{
				min = roads[capitals[currentCity]][j];
				nearestCity = j;
				break;
			}
		}
	for (int j = 0; j <= cities; j++)
		if (roads[capitals[currentCity]][j] < min && roads[capitals[currentCity]][j] > 0)
		{
			min = roads[capitals[currentCity]][j];
			nearestCity = j;
		}
}

void closestToOtherCity(int cities, int towns[], int roads[20][20], int &nearestCity, int &min, int currentCity, int capitalsNumber)
{
	while (towns[currentCity] != 0)
		{
            for (int j = 0; j <= cities; j++)
		    {
		    	if (roads[towns[currentCity]][j] > 0)
			    {
			    	min = roads[towns[currentCity]][j];
					nearestCity = j;
				    break;
			    }
		    }
		    if (min > 0)
			    break;
		    else
		        currentCity +=capitalsNumber;
		}
		while (towns[currentCity] != 0)
	    {
	        for (int j = 0; j <= cities; j++)
	        {
		        if (roads[towns[currentCity]][j] < min && roads[towns[currentCity]][j] > 0)
		        {
		        	min = roads[towns[currentCity]][j];
			        nearestCity = j;
		        }		
	        }
	        currentCity += capitalsNumber;
		}
}

void delRoads(int roads[20][20], int ind1, int ind2)
{
	roads[ind1][ind2] = 0;
	roads[ind2][ind1] = 0;
}

void delRoadsToOtherStates(int roads[20][20], int ind1, int ind2)
{
		if (roads[ind1][ind2] != 0)
			delRoads(roads, ind1, ind2);		
}

int main()
{
	FILE* file = fopen("test.txt", "r");
	int const size = 20;
	int roads[size][size];
	for (int i = 0; i < size; i++)
		for (int j = 0; j < size; j++)
			roads[i][j] = 0;
	int cities = 0;
	int roadsNumber = 0;
	fscanf(file, "%d %d", &cities, &roadsNumber);
	int city1 = 0;
	int city2 = 0;
	int road = 0;
	int count = 0;
	while (count != roadsNumber)
	{
		fscanf(file, "%d %d %d", &city1, &city2, &road);
		roads[city1][city2] = road;
		roads[city2][city1] = road;
		count ++;
	}
	int capitalsNumber = 0;
	fscanf(file, "%d", &capitalsNumber);
	int capitals[size];
	for (int i = 0; i < capitalsNumber; i++)
	{   
		int capital = 0;
        fscanf(file, "%d", &capital);
		capitals[i] = capital;
	}
	fclose(file);
	for (int i = 0; i < capitalsNumber; i++)
		for (int j = 0; j < capitalsNumber; j++)
			roads[capitals[i]][capitals[j]] = 0;
	int towns[size];
	for (int i = 0; i < size; i++)
		towns[i] = 0;
	for (int i = 0; i < capitalsNumber; i++)
	{
		int min = 0;
		int nearestCity = 0;
		closestToCapital(cities, capitals, roads, nearestCity, min, i);
		delRoads(roads, capitals[i], nearestCity);
		towns[i] = nearestCity;
		for (int k = 0; k < capitalsNumber; k++)
		{
			delRoadsToOtherStates(roads, nearestCity, towns[k]);
			delRoadsToOtherStates(roads, nearestCity, capitals[k]);
		}
	}
	int indexInTowns = capitalsNumber;
	for (int i = 0; i <= cities; i++)
	{
		int currentCity = i % capitalsNumber; 
		int nearestCity1 = 0;
		int min1 = 0;
		closestToCapital(cities, capitals, roads, nearestCity1, min1, currentCity);
		int nearestCity2 = 0;
		int ind = i % capitalsNumber; 
		int min2 = 0;
		closestToOtherCity(cities, towns, roads, nearestCity2, min2, ind, capitalsNumber);
        if (min1 < min2 && min1 > 0 || min2 == 0 && min1 > 0)
	    {
		    delRoads(roads, capitals[currentCity], nearestCity1);
		    towns[indexInTowns] = nearestCity1;
			for (int k = 0; k < indexInTowns; k++)
				delRoadsToOtherStates(roads, nearestCity1, towns[k]);
			for (int k = 0; k < capitalsNumber; k++)
				delRoadsToOtherStates(roads, nearestCity1, capitals[k]);
		    indexInTowns++;
	    }
	    else
            if (min1 == 0 && min2 > 0 || min2 < min1 && min2 > 0)
         	{
	        	delRoads(roads, towns[ind], nearestCity2);
		        towns[indexInTowns] = nearestCity2;
				for (int k = 0; k < indexInTowns; k++)
				    delRoadsToOtherStates(roads, towns[k], nearestCity2);
                for (int k = 0; k < capitalsNumber; k++)
					delRoadsToOtherStates(roads, capitals[k], nearestCity2);
		        indexInTowns++;
	        }
		if (min1 == 0 && min2 == 0)
		{
			towns[indexInTowns] = 0;
			indexInTowns++;
		}
	}
	int land = 1;
	for (int i = 0; i < capitalsNumber; i++)
	{
		printf("State number %d\n ", land);
		printf("Capital %d ", capitals[i]);
		int ind = i;
		count = 0;
		printf("Other cities: ");
		while (count < size - i)
		{
			if (towns[ind] != 0)
			    printf("%d ", towns[ind]);
			ind = ind + capitalsNumber;
			count = count + capitalsNumber;
		}
		printf("\n");
		land++;
	 }
	 return 0;
}