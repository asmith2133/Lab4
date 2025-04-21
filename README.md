Decorator Pattern
I chose the decorator pattern to implement an alternative way to display the contents of the purse. I implemented a PurseDisplay() interface with a display method. Then I implemented a PurseCount() method that formats the Purse() object into a string for display. 
Observer Pattern
I chose the observer pattern implement a panel to keep transaction history. This way every test data can be stored in history for easy access. I created an interface named ChangeObserver  with an Update() method. Then I created a HistoryPanel that implements and displays all the transactions in a scrollpane. The Register class was updated with a list of observers. So whenever makeChange() is called, it notifies the observers and passes them the updated purse and amount. The HistoryPanel class adds the entry to its log.
Now when the user enters an amount and gets change, a list and count of each coin/bill is shown and the history is updated with each transaction.
