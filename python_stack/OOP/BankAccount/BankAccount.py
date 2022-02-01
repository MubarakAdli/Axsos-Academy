class bankaccount:
    def __init__(self,interest_rate,balance):
        self.interest_rate=interest_rate
        self.balance=balance
    def deposit(self,amount):
        self.balance =self.balance+amount
        return self.balance
    def withdraw(self,amount):
        self.balance =self.balance-amount   
        return self.balance
    def display_account_info(self):
        print(self.balance)
    def yield_interest(self):
        self.balance=self.balance*(self.interest_rate + 1)
        return self.balance

account_1=bankaccount(0.02,1000)
account_2=bankaccount(0.03,900)

account_1.deposit(300)
account_1.deposit(200)
account_1.deposit(200)
account_1.withdraw(400)
account_1.yield_interest()
account_1.display_account_info()
account_2.deposit(100)
account_2.deposit(700)
account_2.withdraw(200)
account_2.withdraw(200)
account_2.withdraw(100)
account_2.withdraw(200)
account_2.yield_interest()
account_2.display_account_info()
