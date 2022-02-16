from django.shortcuts import render,redirect
from django.contrib import messages
import bcrypt
from .models import Login

def show(request):
    return render(request,'show.html')


def reg(request):    
    errors = Login.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')
    else:
        password=request.POST['pass']
        confirm=request.POST['confirm']
        if confirm==password:
            hash_1=bcrypt.hashpw('password'.encode(), bcrypt.gensalt()).decode()
            Login.objects.create(first_name=request.POST['first'],last_name=request.POST['last'],email_address=request.POST['email'],password=hash_1)
            this_user=Login.objects.get(email_address=request.POST['email'])
            request.session['user_id']=this_user.id
    return redirect('/')

def login(request):
    user=Login.objects.get(email_address=request.POST['email-1'])
    if user:
        if bcrypt.checkpw(request.POST['pass_1'].encode(), user.password.encode()):
            request.session['user_id']=user.id
        return redirect('/success')
    else:
        return redirect('/')

def result(request):
    new_user=Login.objects.get(id=request.session['user_id'])

    context={
        'new_user':new_user
    }
        
    return render(request,'info.html',context)
    

