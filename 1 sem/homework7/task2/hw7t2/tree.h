#pragma once

struct Node;

void create(Node* &node, Node* parent, int x);
void add(Node* &node, int x);
void remove(Node* &node, int x);
Node* find(Node* node, int x);
void printUp(Node* node);
void printDown(Node* node);
void deleteTree(Node* &node);