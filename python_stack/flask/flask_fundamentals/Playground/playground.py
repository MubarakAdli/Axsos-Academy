
from flask import Flask, render_template
app = Flask(__name__)                     
    
@app.route('/play')                           
def play_ground():
    return render_template('index.html') 


@app.route('/play/<num>')                           
def play_ground_2(num):
    return render_template('index_2.html',num=int(num))

@app.route('/play_2/<root>/<color>')                           
def play_ground_3(root,color):
    return render_template('index_3.html',root=int(root),color=color) 
    
if __name__=="__main__":
    app.run(debug=True)  
