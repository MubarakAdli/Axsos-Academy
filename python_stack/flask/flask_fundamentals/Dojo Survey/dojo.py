
from flask import Flask, render_template, request, redirect 
app = Flask(__name__)


@app.route('/')
def index():
    return render_template("dojo.html")

@app.route('/users', methods=['POST'])
def form():
    name = request.form['name']
    location = request.form['location']
    favorite_lang= request.form['language']
    comment= request.form['comment']

    return render_template("form.html",name=request.form['name'],location=request.form['location'],language=request.form['language'],comment=request.form['comment'])

if __name__ == "__main__":
    app.run(debug=True)
