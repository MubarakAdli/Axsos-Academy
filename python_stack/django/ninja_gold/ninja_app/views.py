from django.shortcuts import render,redirect
import random
from time import gmtime, strftime


def ninja(reaquest):
        return render(reaquest,"index.html")

def gold(request):
        request.session['total']=0
        request.session['time']=strftime("%Y-%m-%d %H:%M %p", gmtime())

        if request.POST['which_form'] =='farm':
                request.session['farm_earned']= random.randint(10,20)
                request.session['total']+=request.session['farm_earned']

        elif request.POST['which_form']=='cave':
                request.session['cave_earned']= random.randint(5,10)
                request.session['total']+=request.session['cave_earned']

        elif request.POST['which_form'] =='house':
                request.session['house_earned']= random.randint(2,5)
                request.session['total']+= request.session['house_earned']

        elif request.POST['which_form'] =='casino':
                request.session['casino_earned']= int(random.randint(-50,50))
                request.session['total']+= request.session['casino_earned']
        return redirect('/')
