Project #1:  Variables
===
As you do this lab, answer the numbered questions.  Those answers are what you submit for this project.  READ THE ENTIRE ASSIGNMENT BEFORE YOU GET STARTED!!!
# Introduction
In this lab, you are going to learn how awful things can be when someone doesn’t name variables (and methods) nicely.  I have taken one of my solutions to a programming team problem and made it messy – I played with names, where variables are declared, added useless variables, and mucked up the formatting.  Your job is going to be to figure out what the code is doing and use that knowledge to clean things up.  As you go along, keep notes about exactly what changes you make - you are going to have to create a screen cast summarizing those changes.  The details of that screencast are at the end of this assignment.  Make sure you read that and think about it as you go along so that you keep track of important facts along the way.

Engineers keep a log of what they are doing - while you should always be doing that, that will be particularly critical in this lab
# Getting Started
First, just get my code into eclipse and make sure it works with this test data:

```
2
babgbag
bag
rabbbit
rabbit
```
The answer for that input should be:
```
5
3
```

Don’t worry if the output gets interleaved with the input – that is the way programming team problems work – they give the answer as soon as they can.
# Figure out what it is doing
Before you can start fixing things, you need to figure out what is going on.  Here are my clues:

* There are comments – use them and the great google machine
* This code is formatted very poorly.  Fixing that first might make things easier.
* You have a debugger in eclipse – watch it run with various sequences 
* As you figure out what each variable holds and what each method does, rename them to give them meaningful names (keep track of the original and new names – you will need them later).  You don’t really understand it until you have been able to give them all meaningful names.
* What is memoization? Yes, that is not a typo - it is supposed to be missing that 'r'.  
* Explain how this code uses memoization and why it was a wise choice for solving this problem.  To be able to do that well, you have to be able to give the recurrence the program is using and show how it gets converted to table form for memoization.

# Cleaning up the code further
For every variable, do one of the following:

* eliminate it if it is unused
* reduce its scope as far as you can – you can rearrange sequential logic as long as you don’t break the algorithm

As you do this, keep track of the following for each variable you keep:

* Its initial name
* Its initial scope (measured in lines of code)
* Its initial total span
* Its initial live time
* Its final name
* Its final scope
* Its final total span
* its final live time

# Analysis

Think about these questions:

* Which variable had the worst original names and where do you think they came from?
* What variables did you eliminate?  Why do you think the author originally thought they were necessary?
* How much did reducing scope improve the code?  If you can, give an example where the improvement was significant and explain why it was significant.  Otherwise explain why it didn’t make much difference.
* How much did reducing span improve the code?  If you can, give an example where the improvement was significant and explain why it was significant.  Otherwise explain why it didn’t make much difference.

# What to Submit
You must submit a screen cast to the assignment in the google classroom showing how you changed the code.  It should include these pieces of information:

First, you must demonstrate that you understand the problem, the solution, and how that solution is coded:

1. What is the purpose of this code?
2. What is memoization and how does it relate to recursion?
3. Show the structure of the table that the memoization in this code uses.
4. What recurrence is this code based on?
5. Why did this solution need to use memoization?

Second, you must demonstrate how you improved the code:

1. Which variable had the worst original names and where do you think they came from?
2. What variables did you eliminate?  Why do you think the author originally thought they were necessary?
3. How much did reducing scope improve the code?  If you can, give an example where the improvement was significant and explain why it was significant.  Otherwise explain why it didn’t make much difference.
4. How much did reducing span improve the code?  If you can, give an example where the improvement was significant and explain why it was significant.  Otherwise explain why it didn’t make much difference.

Hint:  Making it easy for me to find the answers to these questions will make it much more likely that you will get a good grade.  Also, presentation matters!  Think about what you are going to show on the screen and what you are going to say.   The screen cast should not be more than a couple minutes long.