/**
 * @file Reverse_String.cpp
 *
 * @brief Algorithm to reverse a string.
 *
 * @author Gillis Werrebrouck
 */

#include <iostream>
#include <string>
using namespace std;

void reverse(char* str);

int main() {
  string str = "Reverse this string";
  cout << str << endl;
  reverse(&str[0]);
  cout << str << endl;

  return 0;
}

void reverse(char* str) {
  char * end = str;
  while (*end) {
    end++;
  }
  end--;

  while (str < end) {
    swap(*str++, *end--);
  }
}
