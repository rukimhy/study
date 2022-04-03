#include <stdio.h>
#include <stdlib.h>

struct node {
    int data;
    struct node* nextNode;
    struct node* beforeNode;
};

struct node* createNode(int data) {
    struct node* newNode = (struct node*)malloc(sizeof(struct node));
    newNode->data = data;
    newNode->nextNode = NULL;
    newNode->beforeNode = NULL;

    return newNode;
}

struct node* insertNode(struct node* current, int data) {
    struct node* newNode = (struct node*)malloc(sizeof(struct node));

    newNode->data = data;
    newNode->nextNode = current->nextNode;
    if (newNode->nextNode) {
        newNode->nextNode->beforeNode = newNode;
    }
    current->nextNode = newNode;
    newNode->beforeNode = current;

    return newNode;
}

void destroyNode(struct node** destroy) {
    if ((*destroy)->beforeNode == NULL) {
        (*destroy)->nextNode->beforeNode = NULL;
    } else {
        (*destroy)->beforeNode->nextNode = (*destroy)->nextNode;
    }

    free(*destroy);
    *destroy = NULL;
}

void printNode(struct node* n) {
    if (n != NULL) {
        while (n) {
            printf("node의 data : %d\n", n->data);
            n = n->nextNode;
        }
    } else {
        printf("존재하지 않는 노드입니다.\n");
    }
}

int main() {
    struct node* n1 = createNode(100);
    struct node* n2 = insertNode(n1, 200);
    struct node* n3 = insertNode(n2, 300);
    struct node* n4 = insertNode(n2, 400);
    printNode(n1);
    printf("========\n");
    destroyNode(&n1);
    printNode(n1);

    return 0;
}