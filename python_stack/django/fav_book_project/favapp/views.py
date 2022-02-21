from multiprocessing import context
from django.shortcuts import render,redirect
from login_app.models import User,Book
import bcrypt
from django.contrib import messages

def view(request):
    user_name=User.objects.get(id=request.session['user_id'])
    context={
        'user_name': user_name,
        'allbooks':Book.objects.all(),
    }
    return render(request,'addbok.html',context)

def addbook(request):
    errors = Book.objects.book_validator(request.POST)
    if len(errors)>0:
        for key, value in errors.items():
            messages.error(request,value)
        return redirect('/book')
    else:
        uploaded = User.objects.get(id=request.session['user_id'])
        new_book = Book.objects.create(title=request.POST['title'],desc = request.POST['desc'],uploaded_by = uploaded)
        this_user=User.objects.get(id=request.session['user_id'])
        new_book.users_who_like.add(this_user)
        uploaded.liked_books.add(new_book)
    return redirect('/book')

def favarite(request,book_id):
    new_book=Book.objects.get(id=book_id)
    new_user=User.objects.get(id=request.session['user_id'])
    new_book.users_who_like.add(new_user)
    return redirect('/book')

def edit(request,book_id):
    user=User.objects.get(id=request.session['user_id'])
    book=Book.objects.get(id=book_id)
    context={
        'user':user,
        'book':book,
    }
    if book.uploadedby.id == user.id :
        return render(request,'bookedit.html',context)
    else:
        return render(request,'booklike.html',context)

def delete(request,book_id):
    book=Book.objects.get(id=book_id)
    book.delete()
    return redirect('/book')

def update(request,book_id):
    book=Book.objects.get(id=book_id)
    book.title=request.POST['title']
    book.desc=request.POST['desc']
    book.save()
    return redirect(f'/book/{book_id}')

def deletefavarite(request,book_id):
    book=Book.objects.get(id=book_id)
    user=User.objects.get(id=request.session['user_id'])
    book.liked_books.remove(user)
    return redirect(f'/book/{book_id}')
