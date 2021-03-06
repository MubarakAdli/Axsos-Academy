
from platform import release
from django.shortcuts import redirect, render
from .models import Show
from django.contrib import messages

def add_show(request):
    return render(request,"index.html")

def show(request):
        context={
        'show':Show.objects.all(),
            }
        return render(request,'show.html',context)

def movie(request):
    errors = Show.objects.basic_validator(request.POST)
    if len(errors) > 0:
        for key, value in errors.items():
            messages.error(request, value)
        return redirect('/new')
    else:
        this_show=Show.objects.create(title=request.POST['title'],network=request.POST['network'],release_date=request.POST['date'],desc=request.POST['desc'])
        num=this_show.id
        messages.success(request, "show successfully updated")
    return redirect(f"/{num}")

def display(request,show_id):
    this_show=Show.objects.get(id=show_id)
    context={
        'this_show':this_show
    }
    return render(request,'desc.html',context)

def edit_info(request,show_id):
    this_show=Show.objects.get(id=show_id)
    context={
        'this_show':this_show
    }
    return render(request,'edit.html',context)

def update_info(request,show_id):
    new_info=Show.objects.get(id=show_id)
    new_info.title=request.POST['title-1']
    new_info.network=request.POST['network-1']
    new_info.date=request.POST['date-1']
    new_info.desc=request.POST['desc-1']
    new_info.save()
    return redirect(f'/{show_id}')

def remove(request,show_id):
    info=Show.objects.get(id=show_id)
    info.delete()
    return redirect('/')