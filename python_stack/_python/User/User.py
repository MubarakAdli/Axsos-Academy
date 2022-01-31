class user:
    def __init__(self,name,age,address,email):
        self.name=name
        self.age=age
        self.address=address
        self.email=email
        self.account_deposit=0
        self.account_withdrawal=0
        self.account_balance=0
    def make_deposit(self,amount):
        self.account_deposit+=amount
        print(self.account_deposit)
    def make_withdrawal(self,amount):
        self.account_withdrawal+=amount
        print(self.account_withdrawal)
    def display_user_balance(self):
        self.account_balance=self.account_deposit-self.account_withdrawal
        print(self.account_balance)


mubarak=user("mubarak",30,"Ramallah","mubarak@hotmail.com")
mubarak.make_deposit(200)
mubarak.make_withdrawal(100)
mubarak.display_user_balance()

ahmed=user("ahmed",25,"Jenin","ahmed@hotmail.com")
ahmed.make_deposit(200)
ahmed.make_deposit(400)
ahmed.make_withdrawal(100)
ahmed.make_withdrawal(100)
ahmed.display_user_balance()

khalid=user("khalid",27,"Nablus","khalid@hotmail.com")
khalid.make_deposit(400)
khalid.make_withdrawal(100)
khalid.make_withdrawal(100)
khalid.make_withdrawal(100)
khalid.display_user_balance()
