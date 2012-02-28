#include <stdio.h>
#include "tree.h"
#include <iostream>
#include <locale.h>

using namespace std;

struct Node
{
	int value;
	Node* right;
	Node* left;
	Node* parent;
};

void create(Node* &node, Node* parent, int x)
{
	Node* newNode = new Node();
	newNode->value = x;
	newNode->parent = parent;
	node = newNode;
}

void add(Node* &node, int x)
{
	setlocale(LC_ALL,"Rus");
	if (node == NULL)
	{	
		node = new Node();
		node->parent = NULL;
		node->left = NULL;
		node->right = NULL;
		node->value = x;
		return;
	}
	if (node->value > x)
		if (node->left != NULL)
			add(node->left, x);
		else
			create(node->left, node, x);
	if (node->value < x)
		if (node->right != NULL)
			add(node->right, x);
		else
			create(node->right, node, x);
	if (node->value == x)
	{
		printf("Элемент уже содержится в множестве\n");
		return;
	}
}

void remove(Node* &node)
{
	if (node->left == NULL && node->right == NULL)
		{
			if (node->parent->left == node)
				node->parent->left = NULL;
			if (node->parent->right == node)
				node->parent->right = NULL;
			delete(node);		
			node = NULL;
			return;
		}
	if (node->left == NULL)
		{
			if (node->parent->left == node)
				node->parent->left = node->right;
			if (node->parent->right == node)
				node->parent->right = node->right;
			delete (node);
			return;
		}
	if (node->right == NULL)
		{
			if (node->parent->left == node)
				node->parent->left = node->left;
			if (node->parent->right == node)
				node->parent->right = node->left;
			delete (node);
			return;
		}
	if (node->right != NULL && node->left != NULL)
	{
		bool IsLeft;
		Node* temp = node;
		if (node->right != NULL)
		{
			temp = node->right;
			IsLeft = false;
		}
		else
			if(node->left != NULL)
			{
				temp = node->left;
				IsLeft = true;
			}
		if (IsLeft == true)
			while (temp->right != NULL)
				temp = temp->right;
		else
			if (IsLeft == false)
				while (temp->left != NULL)
					temp = temp->left;
		node->value = temp->value;
		remove(temp);
	}	
}

bool check(Node* node, int x)
{
	while (node->value != x )
	{
		if (node->value > x)
			node = node->left;
		else
			node = node->right;
		if (node == NULL)
			return false;
	}
	if (node->value == x)
		return true;
	return false;
}

Node* find(Node* node, int x)
{
	setlocale(LC_ALL, "Rus");
	if (!check(node, x))
	{
		printf("Множество не содержит данный элемент\n");
		return NULL;
	}
	if (check(node, x))
	{	
		while (node->value != x)
		{
			if (node->value > x)
				node = node->left;
			if (node->value < x)
				node = node->right;
		}
		return node;
	}
	return NULL;
}

void clear(Node* &node, int x)
{
	if (check(node, x) == false)
		return;
	bool IsLeft = false;
	Node* temp1 = node;
	Node* temp2 = temp1;
	temp1 = find(node, x);
	if (temp1->parent == NULL)
	{
		if (temp1->right != NULL)
		{
			temp2 = temp1->right;
			IsLeft = false;
		}
		else
			if(temp1->left != NULL)
			{
				temp2 = temp1->left;
				IsLeft = true;
			}
		if (IsLeft == true)
			while (temp2->right != NULL)
				temp2 = temp2->right;
		else
			if (IsLeft == false)
				while (temp2->left != NULL)
					temp2 = temp2->left;
		temp1->value = temp2->value;
		if (temp2->left)
			temp2->left->parent = temp1;
		if (temp2->right)
			temp2->right->parent = temp1;
		if(temp2 != temp1)
			remove(temp2);
		else
			if (temp2 == temp1 && node == temp1)
			{
				delete(node);
				node = NULL;
			}
		return;
	}
	if (temp1->parent != NULL)
	{		
		remove(temp1);
	}
}

void printUp(Node* node)
{
	setlocale(LC_ALL, "Rus");
	if (node == NULL)
	{
		printf("Пустое множество\n");
		return;
	}
	if (node->left != NULL)
		printUp(node->left);
	printf("%d ", node->value);
	if (node->right != NULL)
		printUp(node->right);
}

void printDown(Node* node)
{
	setlocale(LC_ALL, "Rus");
	if (node == NULL)
	{
		printf("Пустое множество\n");
		return;
	}
	if (node->right != NULL)
		printDown(node->right);
	printf("%d ", node->value);
	if (node->left != NULL)
		printDown(node->left);
}

void exit(Node* &node)
{
	if (node != NULL)
	{
		if (node->left != NULL)
			exit(node->left);
		if (node->right != NULL)
			exit(node->right);
		delete node;
		node = NULL;
	}
	else
		return;	
}