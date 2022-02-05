from flask import Flask, render_template
app = Flask(__name__)    

@app.route('/')                           
def play_ground_2():
    
    return render_template('check2.html')

@app.route('/<num>')                           
def play_ground__(num):
    c=int(num)/2
    
    return render_template('check3.html',y=int(c))

@app.route('/<num>/<num2>')                           
def play_ground(num,num2):
    a=int(num)/2
    b=int(num2)/2
    
    return render_template('check.html',x=int(a),y=int(b))

@app.route('/<num>/<num2>/<color_1>/<color_2>')                           
def color(num,num2,color_1,color_2):
    a=int(num)/2
    b=int(num2)/2
    
    return render_template('color.html',x=int(a),y=int(int(b)/2),color1=color_1,color2=color_2)

if __name__=="__main__":       
    app.run(debug=True)    
