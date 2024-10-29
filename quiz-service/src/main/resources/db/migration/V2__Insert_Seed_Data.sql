-- Insert data into quiz table
--INSERT INTO public.quiz(id, title) VALUES (1, 'General Knowledge Quiz');
--
--
---- Insert data into quiz_question_ids table
--INSERT INTO public.quiz_question_ids(question_ids, quiz_id) VALUES (1, 1);


-- Insert data into quiz table
INSERT INTO public.quiz(title) VALUES
('Java Basics Quiz'),
('Python Intermediate Quiz'),
('C and C++ Fundamentals Quiz');

-- Insert data into quiz_question_ids table
-- Quiz 1: Java Basics Quiz (Java questions)
INSERT INTO public.quiz_question_ids(question_ids, quiz_id) VALUES
(1, 1), -- Java Basics - Who is known as the father of Java programming language?
(2, 1), -- Java Basics - Which access modifier makes a member accessible from any other class?
(3, 1), -- Java Basics - What does the Java compiler convert Java code into?
(4, 1), -- Java Basics - Which is the superclass of all exceptions in Java?
(5, 1); -- Java Basics - What is the superclass of all classes in Java?

-- Quiz 2: Python Intermediate Quiz (Python questions)
INSERT INTO public.quiz_question_ids(question_ids, quiz_id) VALUES
(6, 2), -- Python Intermediate - Who created the Python programming language?
(7, 2), -- Python Intermediate - Which keyword is used to create an anonymous function in Python?
(8, 2), -- Python Intermediate - Which Python data type is immutable?
(9, 2), -- Python Intermediate - What is the constructor method in Python classes?
(10, 2); -- Python Intermediate - Which programming paradigm does Python support?

-- Quiz 3: C and C++ Fundamentals Quiz (C and C++ questions)
INSERT INTO public.quiz_question_ids(question_ids, quiz_id) VALUES
(11, 3), -- C and C++ Fundamentals - Who is the creator of the C programming language?
(12, 3), -- C and C++ Fundamentals - Which directive is used to include files in C?
(13, 3), -- C and C++ Fundamentals - Which function is used to dynamically allocate memory in C?
(16, 3), -- C and C++ Fundamentals - Who developed C++?
(18, 3); -- C and C++ Fundamentals - What feature of C++ allows multiple functions with the same name but different parameters?
