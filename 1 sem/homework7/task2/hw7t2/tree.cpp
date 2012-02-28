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

void remove(Node* &node, int x)
{
	if (find(node, x) == NULL)
		return;
	if (node == NULL)
		return;
	if (node->value < x)
		remove(node->right, x);
	if (node->value > x)
		remove(node->left, x);
	if (node->value == x)
	{
		if (node->left == NULL && node->right == NULL)
	    {
		    if (node->parent->left == node)
			    node->parent->left = NULL;
		    if (node->parent->right == node)
		        node->parent->right = NULL;
	        delete node;		
		    node = NULL;
		    return;
	     }
        if (node->left == NULL)
	    {
			Node *temp = node->right;
		    node->right = temp->right;
			node->left = temp->left;
			node->value = temp->value;
			node->parent = NULL;
			delete temp;
			return;	   
	    }
		if (node->right == NULL)
	    {
            Node *temp = node->left;
		    node->right = temp->right;
			node->left = temp->left;
			node->value = temp->value;
			node->parent = NULL;
			delete temp;
			return;
	    }
		if (node->right != NULL && node->left != NULL)
	    {
		    Node* temp = node;
		    temp = node->right;
	        while (temp->left != NULL)
			    temp = temp->left;
		    node->value = temp->value;
		    remove(temp, temp->value);
    	}
	}
}

Node* find(Node* node, int x)
{
    while (node->value != x)
	{
		if (node->value > x)
			node = node->left;
		if (node->value < x)
			node = node->right;
		if (node == NULL)
			return node;
	}
	return node;
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

void deleteTree(Node* &node)
{
	if (node != NULL)
	{
		if (node->left != NULL)
			deleteTree(node->left);
		if (node->right != NULL)
			deleteTree(node->right);
		delete node;
		node = NULL;
	}
}