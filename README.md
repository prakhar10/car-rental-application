# car-rental-application
Car rental Application
Course : CSE 5330 Database Systems

Project Description:
Design and implement a database for keeping track of information about a car rental company. 
Assume that the following requirements were collected for this application:
1.	The database keeps track of CUSTOMERs. Customers can be individuals or companies. Each CUSTOMER has a unique IdNo (assume this is a unique integer generated by the system for each new CUSTOMER, such as 1, 2, 3, …), a Name (assume this is string consisting of an single initial and last name only for simplicity, such as “J.Smith” or “R.Wong”, for individual or company name), and a Phone (a string of 12 characters such as “817-272-3000”).
2.	The database keeps track of CARs available for rental, which are categorized based on their type. There are six main types: COMPACT, MEDIUM, LARGE, SUV (Sports Utility Vehice), TRUCK, and VAN. Each type of car has its own DailyRate and WeeklyRate (assume all cars of the same type have the same rental rates). For simplicity, we will assume that there is only one rental location.
3.	Each CAR has a VehicleID (a unique number for each car – assume it is a number 1001, 1002, 1003, …), Model (Chevy, Toyota, Ford, …), and Year (2015, 2014, …).
4.	Each car is either owned by the rental company, a bank or an individual owner who leased the vehicle to the company on a long term basis. Choose suitable attributes for these different type of owners to identify the right owner of a vehicle. 
5.	The database will keep track of the current (active) RENTALs as well as scheduled RENTALs of each CAR. The are two types of RENTAL: DAILY and WEEKLY. For each DAILY RENTAL, the information kept will include the specific CAR and CUSTOMER as well as the NoOfDays, StartDate, and ReturnDate (the ReturnDate can be calculated from the StartDate and NoOfDays). For each WEEKLY RENTAL, the information kept will include the specific CAR and CUSTOMER as well as the NoOfWeeks, StartDate, and ReturnDate (the ReturnDate can be calculated from the StartDate and NoOfWeeks). Each rental will also have the AmountDue for the rental, which is a derived value that can be calculated from the other information.
6.	The database will also keep track of which CARs are available for rental during which periods.

The following are the tasks for the third part of the project:
1.	Load some initial data (as discussed above) into the database tables that you created in Part 2 of the assignment. You can either write a loading program, or use SQL/PLUS (insert command), or use SQL/FORMS. Your data should be kept in files so that it can easily be reloaded during debugging. The data format should be designed by you. (Note: You can also use the transactions created by you in item 3 below to load some of the data).
2.	Write queries to retrieve and print all the data you entered. Try to print the data so that it is easy to understand (for example, print appropriate headings, such as: Customers, Compact Cars, SUVs, Current Rentals, etc.).
3.	Write a query that will prepare a report for weekly earnings by owner, by car type and per car unit that owner owns within that car type.
4.	Write the following database update transactions using either PRO*C or JAVA/JDBC or PHP or some other programming language or scripting language.
4.1	The first transaction is to add information about a new CUSTOMER.
4.2	The second transaction is to add all the information about a new CAR.
4.3	The third transaction is to add all the information about a new RENTAL reservation (this must find a free car of the appropriate type for the rental period).
4.4	The fourth transaction is to handle the return of a rented car. This transaction should print the total customer payment due for the rental, and enter it in the database.
4.5	The fifth transaction is to enter or update the rental rates (daily and weekly) for a type of car.
5.	Each transaction should have a user friendly interface to enter the information needed by the transaction. This can either be a Web-based interface, a command line interface, or a forms interface.
6.	Test your transactions by adding a few new customers, cars, reservations, by changing some rental rates and reservations rates.

This project is in progress and has not been completed.


