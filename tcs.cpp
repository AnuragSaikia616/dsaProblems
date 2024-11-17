#include <bits/stdc++.h>
#include <map>
#include <ostream>
#include <string>
using namespace std;

string solver(string s) {
  string curr = "";
  map<string, int> mpp;
  for (char c : s) {
    if (c == ' ') {
      mpp[curr] = mpp[curr] + 1;
      curr = "";
    } else {
      curr += c;
    }
  }
  if (curr != "") {
    mpp[curr] = mpp[curr] + 1;
  }
  string ans = "";
  for (auto entry : mpp) {
    string word = entry.first;
    string num = to_string(entry.second);
    ans += word + " " + num + " ";
  }
  return ans;
}
int main(int argc, char *argv[]) {
  int t;
  cin >> t;
  while (t--) {
    string input;
    getline(cin, input);
    string output = solver(input);
    cout << output << endl;
  }

  return 0;
}
