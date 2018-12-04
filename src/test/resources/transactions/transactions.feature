Feature: Perform transactions
	Transactions like withdraw, deposit and fundtransfer 
 
 Background: 
 For valid account and balance details
		Given Valid Account details
  	And Positive amount
  	
  Scenario: Perform withdrawal Operation
 		When For valid balance in the account
  	Then Perform account withdrawal 
  	
  Scenario: Perform deposit Operation
 		When Balance is positive
  	Then Perform account deposit 