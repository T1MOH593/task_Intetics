# intetics-task
Technical task:
Your program should get two parameters from command line: 

- string of size N^2, that describes squ­are matrix of charac­ters N*N; 

- string that descri­bes given word. 

The first string is converting to matrix using the following rule. String "QWEAS­DZXC" forms the matr­ix: 

['Q','W','E', 

'A','S','D', 

'Z','X','C'] 

Your program should print to the console the sequence of cel­ls those build the given word. 

Every next character of word can be plac­ed just in the neigh­bor cell: on the top, on the bottom, on the left or on the right from the cell with previous charact­er. 

E.g. if it is given matrix "QLGNAEKIRLRN­GEAE" and word "KING­", then sequence of cells will be [1,2]-­>[1,3]->[0,3]->[0,2] After solving the task test it carefully with different exa­mples.
