from django.shortcuts import render,redirect
def show(request):
    if not "count" in request.session:
        request.session['count']=0
    else : 
        request.session['count']+=1
    return render(request,'counter.html')

def clear(request):
    del request.session['count']
    return redirect('/')

def result(request):
    return redirect('/')

def add2(request):
    request.session['count']+=1
    return redirect('/')

def increment(request):
    request.session['num']=int(request.POST['number'])-1
    request.session['count']+=request.session['num']
    return redirect('/') 
