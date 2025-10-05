#include <stdio.h>
typedef struct Node {
    int value;
    int amount;
    Node* left;
    Node* right;

} Node;

int main(void) {



}

Node* new_node(int i) {
    Node* n = malloc(sizeof(Node));
    n->value = NULL;
    n->left, n->right = NULL;
    n->amount = 1;
    return n;
}

Node* add_node(Node* root, int i) {

    Node* n = new_node(i);

    if (root == NULL) {
        return n;
    }

    if (i > root->value) {
        // insert to the right
        root->right = n;
        return n;
    } else if (i < root->value) {
        // intert to the left
        root->left = n;
    } else {
        // do nothing
        root->amount = root->amount + 1;
        return root;
    }


    return n;

}
