# Online Banking Project

## 1- Introduction (Scenario)

The Online Banking System is an online application in which customers can view account details, such as account type, balance, loan interest rates, and transaction history. Customers can also review credit and debit transactions, including deposit and withdrawal amounts with corresponding dates. As for managers, they get the right to do what customers do, adding the maintain of customer records.

## 2- Functional requirements (Design Paradigm)

This Online Banking System is based on two services (the two hierarchies(superclass)) :

1. Customer
* View Account Details : Account type, Balance and Transaction History
* Update Customer Details
* Review Transaction History
* Deposit and Withdrawal amount
* Take loan from credit card
* Make transfers


2. Manager
* Accessing Customer Records
* Update Customer Details
* Review Transaction History
* Open or Close Customer Account
* Make or delete bank card



## 3- Expected Output 

1. Customer
* View Account Details:
If the customer wishes to view his account details, he will need to enter his full name, and his Social Insurance Number (SIN). Also, for verification, the customer will need to enter his date of birth and email address. Once entered, the customer will have to select which card he would like to view. Then, he will be able to view his account type, balance, loan interest rates and transaction history.
* Update Customer Details:
If the customer wishes to update his personal details, he will need to enter his full name and his Social Insurance Number (SIN). After that, he can change any of the personal details: date of birth, email address or home address.
* Deposit and Withdrawal amount:
For depositing and withdrawing an amount of money, the customer will need to enter his full name and SIN. After that, he will need to select in which account he would like to do either operation. Then the money will be deposited or withdrawn. There could be a message to say if there isn't enough money in the account, the amount will not be able to be withdrawn.
* Take loan from credit card:
The customer can loan an amount of money from the credit card.
* Make Transfers:
The customer can make amount transfers between accounts (between the customer's debit and credit cards) if the customer has more than one account. There is also another option in which the customer can make a transfer with another customer account.


2. Manager
* Accessing Customer Records:
The manager has the right to access customer records, meaning the manager can see the credit score, the net worth of bank accounts, account activity, etc.
* Update Customer Details:
Just like the customer, the manager can update the customer's details by providing the customer's full name and SIN.
* Review Transaction History:
The manager can review the transaction history of the customer.
* Open and Close Customer Account:
The manager can open and close customer account. To do so, the manager will need the customer details (such as full name, SIN, date of birth, email address, home address and phone number, etc).Then, the account is made. If a customer has already closed an account with the same full name and SIN, he will not be able to make another account. 
* Make or delete bank card:
A customer is allowed to max 2 debit cards and 2 credit cards. If debit is selected, there will be two options: savings or chequing. If credit is selected, there will be a specific loaning amount depending of the type of person in society (senior, worker, student, etc). Both type of cards require a 8-digit card number and a 4-digit NIP.


## 4- Implementation Details
**(Some methods, I have not put the parameters because there could be some changes and still figuring which parameters to put.)

Methods specifications
* `ViewAccountDetails(String name, int SIN)`: to view account details, the customer will need to enter his full name and SIN. After that, if the customer possesses an account, there will be an option for him to select which card he               would like to view. Then, he will be able to view the details of the account
* `UpdateCustomerDetails(String name, int SIN)`: This method will be an interface method, since both customers and managers are allowed to update the customer's details. By providing the customer's full name and SSN, either of them will be able to change their personal details.
* `Deposit()`: This method will be used to deposit an amount in an account, especially in a bank card. You can only deposit from debit cards.
* `Withdrawal()`: This method will be used to withdraw an amount , if possible, from an account, especially from a bank card. You can only withdraw from debit cards.
* `Loan()`: This method will allow the customer to loan an amount of money from the credit card, if the customer possesses one.
* `ReviewTransactionHistory()`: This method will be an interface method. It will allow both the customers and the managers to review the transaction history of the customer, depending on which card.
* `Transfer()`: This will allow the customer to transfer money to another account or to transfer between cards of the customer.
* `CustomerRecords()`: This will allow the manager to view the customer's credit score, net worth of bank accounts, account activity, etc. That is, of course, if the customer has a bank account.
* `OpenAccount()`: This will allow the manager to open a brand new account for a customer.
* `CloseAccount()`: This will allow the manager to close an account
* `MakeCard()`: This will allow the manager to make a new bank card.
* `DeleteCard()`: This will allow the manager to delete a bank card.
* `balance()`: The balance method will be used to show the balance of the account or card, depending on the class and the situation.

## 5- Interface 

The interface that will be used in this project is the CustomerDetails Interface, meaning that the methods that both customers and managers are allowed to use are accessible through the CustomerDetails Interface. There will be empty body methods that both Customers and Managers are allowed to use.

## 6- The use of Polymorphism
There will be use of polymorphism in both Customer and Manager superclasses. The balance() method will be used as polymorphism. They will be implemented in the Card and CardOperation classes. ***(There might be more methods that will be used as polymorphism)

## 7- The Comparable and Comparator
The comparable will be used in the Account class to filter the transaction by amount. The comparable will also be used in the Card class to filter balance of the cards. The comparator will be used to sort the customer accounts based on different sorting (could be by name, balance, date of birth, etc). 

## 8- What to expect for deliverable 2
We should expect to implement the two hierarchies(superclasses) of the project (Customer and Manager), almost all the empty methods and the interface. Also, there could be some changes as the making of the project goes on. Documentation will also be in for the methods.







