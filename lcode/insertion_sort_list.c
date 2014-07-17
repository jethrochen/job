#include <stdio.h>
#include <stdlib.h>
#include <math.h>

typedef struct LNode {
	int key;
	struct LNode *next;
}LNode, *List;



void insertSort(List *list)
{
	LNode *p;
	LNode *q;
	LNode *t;
	LNode *headNode;

	if (*list == NULL || (*list)->next == NULL)
		return ;

	headNode = (LNode *)malloc(sizeof(LNode));
	headNode->next = *list;
	
	q = *list;
	while (q->next != NULL)
	{
		p = headNode;
		while (q->next->key > p->next->key && p != q)
			p = p->next;
		if (p != q)
		{
			t = q->next;
			q->next = t->next;
			t->next = p->next;
			p->next = t;
		}
		else
		{
			q = q->next;
		}

	}
	*list = headNode->next;
}

int main(void)
{
	LNode *node1 = (LNode *)malloc(sizeof(LNode));
	LNode *node2 = (LNode *)malloc(sizeof(LNode));
	LNode *node3 = (LNode *)malloc(sizeof(LNode));
	LNode *node4 = (LNode *)malloc(sizeof(LNode));
	LNode *node5 = (LNode *)malloc(sizeof(LNode));
	LNode *node6 = (LNode *)malloc(sizeof(LNode));

	node1->key = rand()%100;
	node1->next = NULL;
	node2->key = rand()%100;
	node2->next = node1;
	node3->key = rand()%100;
	node3->next = node2;
	node4->key = rand()%100;
	node4->next = node3;
	node5->key = rand()%100;
	node5->next = node4;
	node6->key = rand()%100;
	node6->next = node5;
	insertSort(&node6);
	while(node6!=NULL)
	{
		printf("%d\n", node6->key);
		node6=node6->next;
	}
	return 0;	
}