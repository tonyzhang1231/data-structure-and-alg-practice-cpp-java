#include <unordered_set>
#include <string>

class Tweet{
public:
	int time;
	int tweetId;
	std::string content;
	Tweet* next; //linked list
	Tweet(int id, int ts);

};

class User{
public:
	int userId;
	//string name;
	std::unordered_set<int> followers;
	Tweet* head;
	
	User() = default;
	User(int id);
	void post(int tweetId, int ts);
	void follow(int userId);
	void unfollow(int userId);

};
