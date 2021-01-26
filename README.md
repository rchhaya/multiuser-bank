# multiuserBank
A banking application that remembers previous users and allows users to deposit, withdraw, and check the balance

As a whole, the program is similar to simpleBank and the README for that file applies to this. A user can deposit, withdraw, check the balance, 
leave the bank, or close the bank using commands '1', '2', '3', '4', and '5', respectively. 

The additional functionality from simpleBank results from the use of a TreeMap that stores the name (key) and account balance (value) of each user. 
This means that once a user leaves the bank, a new user (defined by a new name) can join the bank. If an existing user returns to the bank (the name entered
matches an existing entry in the TreeMap), their balance will be saved from the previous time. Note that the name must match exactly and is case sensitive. 

For depositing, the user provides an amount to deposit. The amount is added to their current balance. For withdrawing, the user provides an amount that they
wish to withdraw. If the amount is less than their current balance, it is allowed. Otherwise, the user is notified that they are overdrafting and 
will not be allowed to withdraw that amount. For checking balance, the user is simply notified of their account balance and requires no user input. For leaving the 
bank, the user is notified of their balance, the TreeMap entry is updated, and the next user is prompted for their name. For closing the bank, the program 
prints out the number of customers the bank saw today and the program closes.  

There are checks for ensuring that the user input is of the correct form and is a valid input for the prompt. For example, checking for a name that 
consists only of letters, depositing/withdrawing only numeric values, and choosing a valid option regarding the 5 options. This `ents input-induced 
program failure.



This is the base for a project that would make use of databases to store user accounts even after the program is closed to improve functionality. It could 
also use more front-end development to build up a user interface with buttons to create a rich application. 
