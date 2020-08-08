#include<bits/stdc++.h>
using namespace std;

class node
{
public:
	char data;
	bool termination;

	unordered_map<char, node*> mp;

	node(int d)
	{
		data = d;
		termination = false;
	}
};

class trie
{
	node *root;

public:
	trie()
	{
		root = new node('\0');
	}

	void insert(string word)
	{
		node *temp = root;

		for (int i = 0; i < word.length(); i++)
		{
			char ch = word[i];

			if (temp->mp.count(ch) == 0)
			{
				node * child = new node (ch);
				temp->mp[ch] = child;
				temp = child;
			}
			else
			{
				temp = temp->mp[ch];
			}
		}

		temp->termination = true;
	}

	bool search(string word)
	{
		node *temp = root;

		for (int i = 0; i < word.length(); i++)
		{
			char ch = word[i];

			if (temp->mp.count(ch) == 0)return false;

			else
			{
				temp = temp->mp[ch];
			}
		}

		return temp->termination;
	}
};

int main()
{
#ifndef ONLINE_JUDGE
	freopen("input1.txt" , "r" , stdin);
	freopen("output1.txt" , "w" , stdout);
#endif

	vector<string> arr = {"apple" , "ape" , "coder" , "codingblocks" , "no"};

	trie t ;

	for (int i = 0; i < arr.size(); i++)
	{
		t.insert(arr[i]);
	}

	cout << t.search("code");

}