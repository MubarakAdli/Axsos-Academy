from operator import index
from django.shortcuts import redirect, render
from .models import Dojo,Ninja


def dojo(request):
    Dojo.objects.create(name=request.POST['dojo'],city=request.POST['city'],state=request.POST['state'])
    return redirect('/')

def ninja(request):
    Ninja.objects.create(first_name=request.POST['first'],last_name=request.POST['last'],dojo=Dojo.objects.get(id=request.POST['x']))
    
    return redirect('/')

def result(request):
    context={
    'Dojos':Dojo.objects.all()
    }

    return render(request,'index.html',context)


