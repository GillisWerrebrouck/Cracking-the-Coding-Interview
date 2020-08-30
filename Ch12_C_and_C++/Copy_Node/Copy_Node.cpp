/**
 * @file Copy_Node.cpp
 *
 * @brief Algorithm to make a deep copy of a node.
 *
 * @author Gillis Werrebrouck
 */

#include <iostream>
#include <string>
#include <map>
using namespace std;

class Node {
  public:
    int value = -1;
    Node * pointer1 = nullptr;
    Node * pointer2 = nullptr;

  Node() {}
  Node(int value) : value(value) {}
};
typedef map<Node*, Node*> NodeMap;
Node * copyNode(Node *);
Node * copyNode(Node *, NodeMap &);


int main() {
  Node * node = new Node;
  node->pointer1 = new Node;
  node->pointer2 = new Node;
  node->pointer1->pointer1 = new Node;
  node->pointer1->pointer2 = new Node;
  node->pointer2->pointer1 = new Node;

  Node * copy = copyNode(node);

  cout << node << endl;
  cout << copy << endl;

  return 0;
}

Node * copyNode(Node * root) {
  NodeMap nodeMap;
  return copyNode(root, nodeMap);
}

Node * copyNode(Node * node, NodeMap & nodeMap) {
  if (node == nullptr) {
    return nullptr;
  }

  NodeMap::iterator i = nodeMap.find(node);
  if (i != nodeMap.end()) {
    return i->second;
  }

  Node * newNode = new Node;
  nodeMap[node] = newNode;
  newNode->pointer1 = copyNode(node->pointer1, nodeMap);
  newNode->pointer2 = copyNode(node->pointer2, nodeMap);
  return newNode;
}
