#include "stack.h"

#pragma once

struct Node
{
	int value;
	char symbol;
	Node* parent;
	Node* right;
	Node* left;
};

void createValue(Node *&node, Node* parent, int value);
void createSymbol(Node *&node, Node* parent, char symbol);
Node* addValue(Node *&node, int value);
Node* addChar(Node *&node, char symbol);
void postorderPrint(Node* &node, Stack *stack);