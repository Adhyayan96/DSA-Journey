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

// 3. List : List is a container and it's dynamic like vector. Does same work like vector, but we can do front operations
void learnList(){

    list<int> ls;

    ls.push_back(2); // {2};
    ls.emplace_back(3); // {2, 3}

    // add an element at the beginning
    ls.push_front(5); // {5, 2, 3} -> in vector we can do this by insertion
    // but insertion more costly in vector in terms of time complexity than list
    // because list maintains doubly linked list, where vector maintains sigly linked list
    ls.emplace_front(1); // {1, 5, 2, 3}
    /*
    Difference between push-front and emplace_front is :

    push_front takes an already crreated object or value and inserts it.
    Ex. ->
    stsring s = "ray";
    ls.push_front(s);

    But emplace_front creates a object directly inside the list
    Ex. ->
    ls.push_front("ray");
    */

    // rest functions same as vector
    // begin, end, rbegin, rend, clear, insert, size, swap
}

// 4. Deque : A container, where operations are same as list and vector
void learnDeque(){
    deque<int> dq;
    dq.push_back(1); // {1}
    dq.emplace_back(2); // {1, 2}
    dq.push_front(3); // {3, 1, 2}
    dq.emplace_front(4); // {4, 3, 1, 2}

    dq.pop_back(); // {4, 3, 1}
    dq.pop_front(); // {3, 1}

    dq.back(); // gives last element 1
    dq.front(); // gives first element 3

    // rest functions same as vector
    // begin, end, rbegin, rend, clear, insert, size, swap
}

// 5. Stack : It follows LIFO (last In First Out)
void learnStack(){
    // see notebook for explanation
    // there is no index in stack, you can't see x at index y. So, you can't say st[3], its wrong.

    stack<int> st;

    // insertion
    st.push(1); // {1}
    st.push(2); // {2, 1} ==> automatically inserts new elements at first ***, as the Qs says last in first out
    st.push(3); // {3, 2, 1}
    st.emplace(4); // {4, 3, 2, 1}

    cout << st.top(); // prints 4, currrent top value that we pushed in stack last

    st.pop(); // removes current top element = 4, now {3, 2, 1}

    cout << st.size(); // gives size of stack, now its 3

    cout << st.empty(); // give true, if stack is empty. Otherwise returns true. 
    // For now it will return true because currently stack has 3 elements {3, 2, 1}

    // swap stacks
    stack<int> s1, s2;
    s1.swap(s2);

    // All the operatins, happen in O(1) time
}

// 6. Queue : Similar to stack but it follows FIFO (First In First out)
void learnQueue(){
    // concept : In a line of bank whoever is standing first, that person will be called first and then next person and then next.....
    queue<int> q;
    
    q.push(1); // {1}
    q.push(2); // pushes to last -> {1, 2}
    q.emplace(3); // {1, 2, 3}

    q.back() += 5; // adds 5 with last element in the queue {1, 2, 8}

    cout << q.back(); // prints current last element in the stack that's now 8
    cout << q.front(); // prints current first element in the stack that's now 1

    q.pop(); // removes current first element, now 1 -> {2, 8}

    // size, swap, empty same as stack

    // All the operatins below, happen in O(1) time
}

// 7. Priority Queue : keeps everything from top to bottom in a sorted order (ascending or descending)
void learnPriorityQueue(){
    // if you are using integer = largest integer stays on top
    // if you are using character = the character with largest value stays on top
    // if you are using string = lexiographically largest string stays on top

    // max heap => keeps largest value on top, then below 2nd largest and in bottom smallest value
    priority_queue<int> pq;
    pq.push(5); // {5}
    pq.push(2); // {5, 2}
    pq.push(8); // {8, 5, 2}
    pq.emplace(10); // { 10, 8, 5, 2}

    cout << pq.top(); // prints top value, that's 10

    pq.pop(); // deletes top element, that's 10. Now the stack looks like {8, 5, 2}

    pq.top(); // now it prints 8 as the top value

    // size, swap and empty functions are same as other

    // min heap => keeps smalles value on top, then below 2nd smallest and in bottom largest value
    priority_queue<int, vector<int>, greater<int>> pq;
    pq.push(5); // {5}
    pq.push(2); // {2, 5};
    pq.emplace(21); // {2, 5, 21}

    cout << pq.top(); // prints 2

    // push and pop happens in O(log n) time complexity & top takes O(1) time complexity
}

// 8. Set : it stores => everything in sorted order & stores only unique elements
void learnSet(){
    set<int> st;
    st.insert(2); // {2}
    st.emplace(3); // {2, 3}
    st. insert(5); // {2, 3, 5}

    // begin, end, rbegin, rend, swap, size, empty functions same as vector and others

    auto it = st.find(3);
    // it finds is there 3 in the set, if it is there there it returns the iterator => the memory address
    // if it doesn't find the value inside the set -> it will give the iterator, which points next adress right after the last element
    // or use this
    int cnt = st.count(3); // if 3 is there inside the set, it will return the occurance 
    // Inside set we store unique values, so occurance of each will be 1
    // so if 3 is there inside the set in will give the value 1, if it isn't there it will give 0

    st.erase(3); // it delets 3 from the set and set now becomes {2, 5}
    // it takes logarithmic time
    //or use this
    auto it = st.find(3);
    st.erase(it);
    // if 3 is there we got the memory address of 3, and we delete the value at that memory address

    // like vector, if you want to delete a range of values at once
    // {1, 2, 3, 4, 5}
    auto it1 = st.find(2);
    auto it2 = st.find(4); // give the right after element address
    st.erase(it1, it2); // it deletes 2 & 3 from the set and set becomes {1, 4, 5} => [first, last)

    // everything in set, happens in O(log N) itme complexity

    // ================= LOWER & UPPER BOUND CONCEPT =================

    // lower_bound(x)
    // -> Returns iterator to the first element >= x
    // Concept: Finds the first value which is equal to x or just greater than x.


    // upper_bound(x)
    // -> Returns iterator to the first element > x
    // Concept: Finds the first value strictly greater than x. Skips equal values.

    set<int> st = {1, 3, 5, 7};

    auto it1 = st.lower_bound(4);
    // points to 5
    // because 5 is the first element >= 4

    auto it2 = st.upper_bound(5);
    // points to 7
    // because 7 is the first element > 5

    // If no such element exists: Returns st.end()
}

// 9. Multiset : Only obey sorted form rule, but doesn't obey unique values rule in set. 
// So it can store many same values in a set.
void learnMultiSet(){
    multiset<int> ms;
    ms.insert(1); // {1}
    ms.insert(2); // {1,2}
    ms.insert(1); // {1, 1, 2}
    ms. insert(1); // {1, 1, 1, 2}

    // delete all occrances of a specific value at once
    ms.erase(1); // all 1s are erased -> {2}

    // only delete a single element, by finding out first occurance
    ms.erase(ms.find(1)); // first 1 is deleted -> {1, 1, 2}
    // concept : if i say earase this x element, it deletes all x elements in the set.
    // But if i say erase(only this address), it deletes only the element at that address

    // ================= ERASE RANGE IN A MULTISET =================
    // let's say, delete 2 occuraces of x => so delete first 2 occurances of x
    multiset<int> ms = {1, 1, 1, 2, 3};

    auto it1 = ms.find(1); // first 1
    auto it2 = next(it1, 2); // moves 2 positions ahead. Points to the element right AFTER the range we want to delete

    ms.erase(it1, it2); // deletes range [it1, it2) => start included, end excluded
    // Now multiset becomes: {1, 2, 3}
}

// 10. Unordered set : Obeys unique rule like set, but doesn't obey sorted format rule.
void learnUnorderedSet(){
    unordered_set<int> us;
    // Lower bound and upper bound function doesn't work
    // Rest all functions are same
    // It doesn't store elements in any particular format
    // In most cases it's time complexity is better than set, except when collision happens.
    // It mosttly takes O(1) time complexity, but in a year once it may take worst case time complexity of O(N)
}

int main(){
    return 0;
}