from django.shortcuts import render,redirect
import random
def rand_num(request):
    request.session['number']=random.randint(1,100)
    print("generated number",str(request.session['number']))
    return render(request,"index.html")

def result(request):
    request.session['user_num'] = request.POST['random']
    if int(request.session['user_num']) > request.session['number']:
        request.session['result'] = 'Too High'
        print(request.session['result'])

    elif int(request.session['user_num']) < request.session['number']:
        request.session['result'] ='Too Low'
        print(request.session['result'])

    else:
        request.session['result'] ='Correct Number'
        print(request.session['result'])

    return redirect('/')

        
