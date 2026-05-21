#include <bits/stdc++.h>
using namespace std;
// STL : It's Standered Template Library, that helps you to use predefind algorithms, containers, functins to save your time

// 1. Pairs (it belongs from utility library)
void learnPairs(){

    // pair
    pair <int, int> p = {1, 3};
    // access pair of p
    cout << p.first << " " << p.second;
    // p.first gives output 1 & p.second gives output 3

    // multi pairs or nested pairs
    pair<int, pair<int, int>> mp = {1, {3, 4}};
    // access pair of mp
    cout << p.first << " " << mp.second.second << " " << mp.second.first;
    /*
    mp.first gives first element = 1
    mp.second.second, first "second" points second element = {3, 4} and next second points second element of second element
    In the same way mp.second.first gives = fist element of 2nd element
    */

    // pair array
    pair<int, int> arr[] = {{1,3}, {2,5}, {5,1}};
    // here {1,3} is idx 0, {2,5} is idx 1 & {5,1} is idx 2
    // print any element of pair array
    cout << arr[1].first << arr[1].second;
    /*
    arr[1].first prints = first element of index 1, that is 2
    arr[1].second prints = second element of index 1, that is 5
    */

}

// 2. Vector : Dynamic array, where you can increase or decrease size as your wish. Vector is a container, that contains elements.
void learnVector(){
    // declaring a vector
    vector<int> v; // it's now a vector of size 0
    // push values into it
    v.push_back(1); // now dynamically it increases it's size to 1 and puts 1 into last index of it. So now v = {1} and it's length = 1
    v.emplace_back(2); // same as push_back but it's faster than push_back

    // create a vector that will contain pairs
    vector<pair<int,int>> vec;
    // push values into it
    vec.push_back({1,2}); // Declare {} - carly brackets because it contains pair
    vec.emplace_back(3,5); // emplace_back automatically assumes it as a pair and takes as input without {}


    vector<int> x(5, 100);
    // It's a vector of size 5 & initially all 5 elements in it are 100 
    
    // copy a vector
    vector<int> v1(5, 20);
    vector<int> v2(v1); // copied v1 in v2

    // accessing values in vector
    cout << v2[0];
    cout << v2.at(0); // gives same output as v2[0]
    cout << v.back(); // gives last element of the array

    // Using iterator to access elements = Iterator points to the memory where the element is
    vector<int>:: iterator it = v.begin(); 
    cout << *(it);
    it++;
    /*
    Explanation : let v = {1, 3, 45};
    Through v.begin, the iterator points to memory location of first index of v, not the element. That means a memory address like = 444...
    So, now it points to first element's memory address of v, not actually 1
    But when we use *(it), it fetches the element at that memory address with the help of "*"
    Then we shift our memory address to next memory address, that means next index
    */

    // end iterator
    vector<int>:: iterator it = v.end();
    /*
    let v = {1, 3, 45};
    VVI point to remember : End doesn't mean it points to last element 45.
    Rather, end means -> it points to the memeory address right after last element 45's memory address.
    If you do it--, and continuing decreasing value of it then you can access all elements in this v vector from back through same *(it)
    */

    // other iterators, but no one uses these. Just know these for knowledge.
    vector<int>:: iterator it = v.rend(); // it points right before first element, just opposite to end iterator. But if you do it-- it continues pointing left to right just as we do normally.
    vector<int>:: iterator it = v.rbegin(); // it points last element, just opposite to begin iterator. But if you do it++ it continues pointing right to left just as we do normally.

    // print values of a vector using iterator (though I know basic index wise (0 to n-1th index) printing through a loop )
    for(vector<int>:: iterator it = v.begin(); it != v.end(); it++) cout << *(it) << " ";
    // simplest version of this upper printing through iterator by using STL
    for(auto it = v.begin(); it != v.end(); it++) cout << *(it) << " "; // automatically assigns the data as vector
    // best version of these upper printing through iterator, through for each loop
    for(auto it: v) cout << it << " "; // or for(int i: v)....

    // auto = automatically assigning
    // automatically assigning data based on their datatype
    auto a = 5;
    // here I don't need to declare long long or int, it will automatically storet the data based on it's type
    auto b = "Adhyayan"; // it will be automatically stored as a string

    // deletion in a vector
    // let v = {1, 2, 3, 4, 5};
    v.erase(v.begin() + 1); // v.begin() = 0 & 0 + 1 = 1, so it deletes index 1 that's 2. So now v = {1,3,4,5};
    // if i need to delete a couple of elements at once
    v.erase(v.begin() + 1, v.begin() + 3); // VVI point : as ending point, mention the index right after the last index you want to delete
    // so let v = {1,3,4,5}. Now it deletes index 1 to the previous index of 0+3 = 3. So, 1st index to 2nd index have been deleted & v becomes = {1,5}

    // insert function in vector
    vector<int>(2, 100); // {100, 100}
    // insert one element -> {give index to insert on, give the element}
    v.insert(v.begin(), 300); // {300, 100, 100}
    // insert multiple elements at once -> {give index to insert on, give occurances of that element, give the element}
    v.insert(v.begin() + 1, 2, 10); // {300, 10, 10, 100, 100} --> rarely required multiple insertion at once in DSA
    // insert a portion into a vector
    vector<int>copy(2, 100);
    v.insert(v.begin(), copy.begin(), copy.end()); // now v = {100, 100, 300, 10, 10, 100, 100}
    // {give index of insertion, give elements range} --. same way as ending point mention the index right after the actual ending index

    // size
    cout << v.size(); // gives you how many elements in v vector, as of now or size of v vector

    // pop back --> pops out the last element
    // let v = {10, 20}
    v.pop_back(); // now v = {10}

    // swaping vectors
    // let v1 = {10, 30} & v2 = {1, 2}
    v1.swap(v2); // swaps their values --> now v1 = {1, 2} & v2 = {10, 30}

    // erase everything in a vector, at once
    // let v = {1, 3, 6}
    v.clear(); // now v = {} -> an empty vector

    // empty fuction in vector
    // if a vector has minimum one element it will give false, if it has 0 elements then it will give true
    cout << v.empty();

}

int main(){
    return 0;
}