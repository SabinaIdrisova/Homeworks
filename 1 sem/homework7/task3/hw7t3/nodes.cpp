#include <iostream>
#include "nodes.h"
#include "stack.h"

using namespace std;

void createValue(Node* &node, Node* parent, int value)
{
	Node* newNode = new Node();
	newNode->value = value;
	newNode->symbol = 0;
	newNode->parent = parent;
	node = newNode;
}

void createSymbol(Node* &node, Node* parent, char symbol)
{
	Node *newNode = new Node();
	newNode->symbol = symbol;
	newNode->parent = parent;
	node = newNode;
}

Node* addValue(Node* &node, int value)
{
	if (node == NULL)
	{
		node = new Node;
		node->value = value;
		node->left = NULL;
		node->right = NULL;
		node->parent = NULL;
		return node;
	}
	if (node->symbol != 0)
	{
		if (node->left == NULL)
		{
			createValue(node->left, node, value);
			return node->left;
		}
		else
			if (node->right == NULL)
			{
				createValue(node->right, node, value);
				return node->right;
			}
		createValue(node->parent->right, node->parent, value);
		return node->parent->right;
	}
	if (node->symbol == 0)
	{
		createValue(node->parent->right, node->parent, value);
		return node->parent->right;
	}
}

Node* addChar(Node* &node, char symbol)
{
	if (node == NULL)
	{
		node = new Node;
		node->symbol = symbol;
		node->left = NULL;
		node->right = NULL;
		node->parent = NULL;
		return node;
	}
	if (node->left == NULL)
	{
		createSymbol(node->left, node, symbol);
		return node->left;
	}
	else
		if (node->right == NULL)
		{
			createSymbol(node->right, node, symbol);
			return node->right;
		}
	createSymbol(node->parent->right, node->parent, symbol);
	return node->parent->right;
}


void postorderPrint(Node* &node, Stack *stack)
{
	if (node != NULL)
	{
		if (node->left != NULL)
			postorderPrint(node->left, stack);
		if (node->right != NULL)
			postorderPrint(node->right, stack);
		if (node->symbol == 0)
		{
			add(stack, node->value);
			printf("%d ", node->value);
		}
		else
			if (node->symbol != 0)
			{
				calculate(stack, node->symbol);
				printf("%c ", node->symbol);
			}
		delete node;
	}
	else
		return;	
}

