#include "user.h"
#include <iostream>

Tweet::Tweet(int id, int ts){
	tweetId = id;
	time = ts;
}

User::User(int id){
	userId = id;
	head = nullptr;
}


void User::post(int tweetId, int ts){
	Tweet* t = new Tweet(tweetId, ts);
	t->next = this->head;
	this->head = t;
	std::cout << "User " << this->userId << " post Tweet " << tweetId << std::endl;
}

void User::follow(int userId){
	followers.insert(userId);
	std::cout << "User " << this->userId << " follow User " << userId << std::endl;
	std::cout << "User " << this->userId << " has " << followers.size() << " followers"<< std::endl;
}

void User::unfollow(int userId){
	followers.erase(followers.find(userId));
}