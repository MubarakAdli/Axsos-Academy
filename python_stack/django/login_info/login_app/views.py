from multiprocessing import context
from django.shortcuts import render,redirect
from .models import User
import bcrypt
from django.contrib import messages

def show(request):
    return render(request,'show.html')

def register(request):
    errors = User.objects.register_validator(request.POST)
    request.session['coming_from']='register'
    request.session['email']=request.POST['email']
    request.session['password']=request.POST['password']
    user=User.objects.filter(email=request.session['email'])
    
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/')

    elif user:
        for key, value in errors.items():
            messages.error(request, value)
            request.session['error']=str('Email already exists')
        return redirect('/')

    else:
        password =request.session['password'] 
        confirm=request.POST['confirm']
        if confirm==password:
                hash = bcrypt.hashpw(password.encode(), bcrypt.gensalt()).decode()
                User.objects.create(first_name=request.POST['first'],last_name=request.POST['last'],email=request.POST['email'],password=hash)
        return redirect('/')

def login(request):
    errors = User.objects.login_validator(request.POST)
    request.session['coming_from']='login'
    this_user=User.objects.get(email=request.POST['login-email'])
    if this_user:
        if bcrypt.checkpw(request.POST['login-password'].encode(), this_user.password.encode()):
            request.session['user_id'] = this_user.id
            return redirect('/success')
        else:
            for key, value in errors.items():
                messages.error(request, value)
            return redirect("/")


def success(request):
    user_name=User.objects.get(id=request.session['user_id'])
    context={
        'user_name': user_name
    }
    return render(request,'info.html',context)



