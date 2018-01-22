#include "twitter.h"
#include <queue>
#include <vector>
#include <iostream>

using namespace std;

// Twitter::Twitter(){};

void Twitter::post(int userId, int tweetId){
	//User& u = map[userId]; // must be User& u, not User u, because map[userId] return User&
	map.at(userId).post(tweetId,timestamp++);
}


void Twitter::follow(int uid1, int uid2){
	User& u = map.at(uid1);
	u.follow(uid2);
}

void Twitter::unfollow(int uid1, int uid2){
	User& u = map.at(uid1);
	u.unfollow(uid2);
}

void Twitter::addUser(int userId){
	User u {userId};
	map[userId] = u;
	std::cout << "Add a user " << userId << std::endl;
}

namespace{
	struct compare
	{
		bool operator()(Tweet* t1, Tweet* t2){
			return t1->time < t2->time;
		}
	};

};

int Twitter::timestamp = 0;

std::vector<int> Twitter::getNewsFeed(int userId) {
	std::priority_queue<Tweet*, std::vector<Tweet*>, compare> q;
	std::unordered_set<int> flws = map[userId].followers;
	for (int flw:flws){
		if (map[flw].head!=nullptr)
			q.push(map[flw].head);
	}

	int k=10;
	vector<int> res;
	while(k-->0 and !q.empty()){
		Tweet* tmp = q.top();
		q.pop();
		res.push_back(tmp->tweetId);
		if (tmp->next!=nullptr){
			tmp = tmp->next;
			q.push(tmp);
		}
	}
	return res;
}

int main(){
	Twitter twitter;
	// auto& map = twitter.map;
	twitter.addUser(1);
	twitter.addUser(2);
	twitter.addUser(3);
	twitter.follow(2,1);
	twitter.follow(2,3);

	twitter.post(1, 101);
	twitter.post(1, 102);
	twitter.post(3, 103);
	twitter.post(3, 104);
	twitter.post(1, 105);
	for (auto e:twitter.getNewsFeed(2)){
		std::cout << e << std::endl;
	}

	twitter.post(3, 106);
	twitter.post(1, 107);
	twitter.post(3, 108);
	twitter.post(3, 109);
	twitter.post(1, 110);
	twitter.post(3, 111);
	twitter.post(1, 112);

	for (auto e:twitter.getNewsFeed(2)){
		std::cout << e << std::endl;
	}

	return 0;
}