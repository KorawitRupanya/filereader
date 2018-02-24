# Input-Output Tasks
by Korawit Rupanya

I ran the tasks on a MacBook Pro 2.3 GHz Intel Core i5,
and got these results:

Task                                          | Time
----------------------------------------------|-------:
Read file 1-char at a time to String          |  0.6140897740000001 sec
Read file 1-char at a time to StringBuilder   |  0.008474333 sec
Read file line at a time using BufferedReader |  0.022365007000000003 sec

## Explanation of Results

### String vs StringBuilder

As you can see for the result that if compared between two type of class that are
String and StringBuilder .The String Builder is faster than the String.That Because Strings in java are immutable. This means that methods that operate on strings cannot ever change the value of a string.String concatenation using += works by allocating memory for an entirely new string that is the concatenation of the 2 previous ones, and replacing the reference with this new string. Each new concatenation requires the construction of an entirely new String object.In constrast, the StringBuilder class is implemented as a mutable sequence of characters. This means that as you append new Strings or chars onto a StringBuilder, it simply updates its internal array to reflect the changes you've made. This means that new memory is only allocated when the string grows past the buffer already existing in a StringBuilder.

### InputStreamReader vs BufferReader

But if you compared between BufferReader and InputStreamReader classes.
You can see that the time consuming for FileReader to read a file is more than
BufferReader.That Because BufferedReader reads a couple of characters from the specified stream and stores it in a buffer. This makes input faster.
For the InputStreamReader,it reads only one character from specified stream and remaining characters still remain in the stream.So,BufferedReader is fast because it maintains a buffer and retrieving data from buffer is always fast as compared to retrieving data from disk.