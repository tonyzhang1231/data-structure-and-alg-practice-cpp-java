#include "user.h"
#include <unordered_map>
#include <vector>

using namespace std;

class Twitter{
public:
	// Twitter();
	void post(int userId, int tweetId);
	void follow(int userId1, int userId2);
	void unfollow(int userId1, int userId2);
	std::vector<int> getNewsFeed(int userId);
	void addUser(int userId);

	static int timestamp;
	std::unordered_map<int, User> map;
};

