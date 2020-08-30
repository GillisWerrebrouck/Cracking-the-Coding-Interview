/**
 * @file Last_K_Lines.cpp
 *
 * @brief Algorithm to print the last K lines of a file by only reading the file once.
 *
 * @author Gillis Werrebrouck
 */

#include <fstream>
#include <iostream>
#include <string>
using namespace std;

void lastKLines();

int main() {
  lastKLines();

  return 0;
}

void lastKLines() {
  const int K = 3;
  string kLines[K];

  int index = 0;
  ifstream file("./test.txt");
  if (file.is_open()) {
    while (file.peek() != EOF) {
      getline(file, kLines[index++ % K]);
    }
    file.close();
  } else {
    cout << "could not open file";
  }

  for (int i = 0; i < K; i++) {
    cout << kLines[(index + i) % K] << endl;
  }
}
