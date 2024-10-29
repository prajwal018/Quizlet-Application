-- Insert data into question table
--INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES (41, 'Science', 'Medium', 'Hydrogen', 'Oxygen', 'Carbon', 'Nitrogen', 'What is the chemical symbol for water?','Hydrogen');

-- Java Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
('Java', 'Medium', 'James Gosling', 'Guido van Rossum', 'Bjarne Stroustrup', 'Dennis Ritchie', 'Who is known as the father of Java programming language?', 'James Gosling'),
('Java', 'Easy', 'public', 'private', 'protected', 'static', 'Which access modifier makes a member accessible from any other class?', 'public'),
('Java', 'Hard', 'Bytecode', 'Source code', 'Machine code', 'Assembly code', 'What does the Java compiler convert Java code into?', 'Bytecode'),
('Java', 'Medium', 'RuntimeException', 'IOException', 'Exception', 'Error', 'Which is the superclass of all exceptions in Java?', 'Exception'),
('Java', 'Easy', 'Object', 'String', 'Class', 'Array', 'What is the superclass of all classes in Java?', 'Object');

-- Python Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
('Python', 'Easy', 'Guido van Rossum', 'Brendan Eich', 'James Gosling', 'Bjarne Stroustrup', 'Who created the Python programming language?', 'Guido van Rossum'),
('Python', 'Medium', 'lambda', 'def', 'function', 'func', 'Which keyword is used to create an anonymous function in Python?', 'lambda'),
('Python', 'Hard', 'dict', 'set', 'tuple', 'list', 'Which Python data type is immutable?', 'tuple'),
('Python', 'Easy', '__init__', '__start__', '__create__', '__new__', 'What is the constructor method in Python classes?', '__init__'),
( 'Python', 'Medium', 'OOP', 'Functional', 'Procedural', 'All of the above', 'Which programming paradigm does Python support?', 'All of the above');

-- C Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
( 'C', 'Medium', 'Dennis Ritchie', 'Ken Thompson', 'Brian Kernighan', 'Bjarne Stroustrup', 'Who is the creator of the C programming language?', 'Dennis Ritchie'),
( 'C', 'Easy', '#include', 'import', 'use', '#define', 'Which directive is used to include files in C?', '#include'),
( 'C', 'Medium', 'malloc()', 'alloc()', 'calloc()', 'realloc()', 'Which function is used to dynamically allocate memory in C?', 'malloc()'),
( 'C', 'Hard', 'NULL pointer', 'Wild pointer', 'Dangling pointer', 'Smart pointer', 'What type of pointer points to a freed memory location?', 'Dangling pointer'),
( 'C', 'Easy', 'gcc', 'javac', 'c++', 'compile', 'Which is the default compiler for C language?', 'gcc');

-- C++ Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
( 'C++', 'Medium', 'Bjarne Stroustrup', 'Dennis Ritchie', 'James Gosling', 'Ken Thompson', 'Who developed C++?', 'Bjarne Stroustrup'),
( 'C++', 'Easy', 'Virtual', 'Override', 'Static', 'Friend', 'Which keyword is used to define a friend function in C++?', 'Friend'),
( 'C++', 'Hard', 'Function overloading', 'Function overriding', 'Operator overloading', 'Virtual functions', 'What feature of C++ allows multiple functions with the same name but different parameters?', 'Function overloading'),
( 'C++', 'Medium', 'Polymorphism', 'Inheritance', 'Encapsulation', 'Abstraction', 'Which OOP concept refers to hiding internal details?', 'Encapsulation'),
( 'C++', 'Easy', 'public:', 'private:', 'protected:', 'static:', 'What access modifier in C++ makes a member accessible from within the same class only?', 'private:');

-- .NET Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
( '.NET', 'Medium', 'Microsoft', 'Apple', 'Sun Microsystems', 'IBM', 'Which company developed the .NET framework?', 'Microsoft'),
( '.NET', 'Easy', 'CLR', 'JVM', 'JRE', 'JIT', 'What is the name of the virtual machine component in .NET?', 'CLR'),
( '.NET', 'Hard', 'Just-In-Time (JIT)', 'Ahead-Of-Time (AOT)', 'Runtime Compilation', 'Interpreted', 'What type of compilation does .NET primarily use?', 'Just-In-Time (JIT)'),
( '.NET', 'Medium', 'Common Language Specification', 'Common Type System', 'Common Language Runtime', 'Common Intermediate Language', 'What does CLS stand for in .NET?', 'Common Language Specification'),
( '.NET', 'Easy', 'ASP.NET', 'MVC.NET', 'WPF.NET', 'WCF.NET', 'Which framework is used for web development in .NET?', 'ASP.NET');

-- JavaScript Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
( 'JavaScript', 'Easy', 'JavaScript', 'Python', 'Ruby', 'Java', 'Which language is primarily used for adding interactivity to web pages?', 'JavaScript'),
( 'JavaScript', 'Medium', 'Brendan Eich', 'Tim Berners-Lee', 'Dennis Ritchie', 'Ken Thompson', 'Who created JavaScript?', 'Brendan Eich'),
( 'JavaScript', 'Hard', '==', '===', '=', '!=', 'Which operator checks both value and type equality in JavaScript?', '==='),
( 'JavaScript', 'Easy', 'let', 'var', 'both', 'none', 'Which keyword was introduced in ES6 for variable declaration?', 'let'),
( 'JavaScript', 'Medium', 'console.log()', 'print()', 'alert()', 'document.write()', 'Which function is commonly used to print messages to the console in JavaScript?', 'console.log()');

-- SQL Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
( 'SQL', 'Easy', 'Primary Key', 'Foreign Key', 'Composite Key', 'Unique Key', 'Which key uniquely identifies each record in a table?', 'Primary Key'),
( 'SQL', 'Medium', 'JOIN', 'SELECT', 'INSERT', 'DROP', 'Which SQL command is used to retrieve data from a database?', 'SELECT'),
( 'SQL', 'Hard', 'INNER JOIN', 'LEFT JOIN', 'RIGHT JOIN', 'FULL JOIN', 'Which JOIN returns records that have matching values in both tables?', 'INNER JOIN'),
( 'SQL', 'Easy', 'CREATE TABLE', 'ALTER TABLE', 'DROP TABLE', 'TRUNCATE TABLE', 'Which command is used to delete all rows in a table without deleting the table?', 'TRUNCATE TABLE'),
( 'SQL', 'Medium', 'SELECT', 'WHERE', 'GROUP BY', 'HAVING', 'Which clause is used to filter records in SQL based on conditions?', 'WHERE');

-- PHP Questions
INSERT INTO public.question( category, difficulty_level, option1, option2, option3, option4, question_title, right_answer) VALUES
( 'PHP', 'Easy', '<?php ... ?>', '<script ... />', '<php ... >', '<?script ... ?>', 'What is the correct syntax to start a PHP script?', '<?php ... ?>'),
( 'PHP', 'Medium', '$_POST', '$_GET', '$_REQUEST', '$_SESSION', 'Which PHP superglobal is used to collect form data after submitting an HTML form with method="get"?', '$_GET'),
( 'PHP', 'Hard', 'get()', 'set()', 'isset()', 'empty()', 'Which PHP function checks if a variable is set and is not NULL?', 'isset()'),
( 'PHP', 'Medium', 'echo', 'print', 'printf', 'console', 'Which function is commonly used to output text in PHP?', 'echo'),
( 'PHP', 'Easy', 'MySQL', 'Oracle', 'SQL Server', 'DB2', 'Which database is most commonly paired with PHP?', 'MySQL');
