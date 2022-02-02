from ast import Num
from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')          
def hello():
    return ("Hello World!")
@app.route('/dojo')          
def hello_1():
    return ("Dojo")
@app.route('/<name>') 
def hello_person(name):
    print("in the hello_person function")
    print(name)
    return f"Hi  {name}"
@app.route('/repeat/<num>/<name>') 
def hello_number(name,num):
    return f'{name}' * int(num)
if __name__=="__main__":     
    app.run(debug=True)

