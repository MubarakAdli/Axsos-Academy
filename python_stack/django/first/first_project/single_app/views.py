
from django.shortcuts import render, HttpResponse,redirect
def index(request):
    return HttpResponse("placeholder to later display a list of all blogs")

def root(request):
    return redirect("/blogs")

def new(request):
    return HttpResponse("placeholder to later display a list of all blogs")

def create(request):
    return redirect("/")

def show(request,number):
    return HttpResponse('placeholder to display blog number'+str(number))

def edit(request,number):
    return HttpResponse('placeholder to edit blog'+''+str(number))

def destroy(request,number):
    return redirect("/blogs")




