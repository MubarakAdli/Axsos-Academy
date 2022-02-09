from django.shortcuts import render,redirect
from .models import User

def show(request):
    context={
        'users': User.objects.all()
    }
    return render(request,'index.html',context)


def info(request):
    User.objects.create(first_name=request.POST['first'],last_name=request.POST['last'],email_address=request.POST['email_address'],age=request.POST['age'])
    
    return redirect('/')