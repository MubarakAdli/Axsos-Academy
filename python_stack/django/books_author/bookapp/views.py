from django.shortcuts import render,redirect
from .models import Book,Author

def view(request):
    context={
        'books': Book.objects.all(),
    }
    return render(request,'info.html',context)


def book(request):
    Book.objects.create(title=request.POST['title'],desc=request.POST['desc'])
    return redirect ('/')


def details(request,book_id):
    book_info=Book.objects.get(id=book_id)
    author=book_info.authors.all()
    authors=Author.objects.exclude(id__in = author.values_list('id', flat=True))
    context={
        'book_info' : book_info,
        'author' : author,
        'authors' :authors
    }
    return render(request,'bookauthor.html', context)

def show(request):
    context={
        'allauthors' : Author.objects.all()
    }
    return render (request,'addauthor.html',context)


def add(request,book_id):
    this_book=Book.objects.get(id=book_id)
    this_author=Author.objects.get(id=request.POST['select_name'])
    this_book.authors.add(this_author)
    return redirect(f"books/{book_id}")


def addauthor(request):
    Author.objects.create(first_name=request.POST['first_name'],last_name=request.POST['last_name'],
    notes=request.POST['notes'])
    return redirect ('/desc1')


def desc1(request,author_id):
    author_info=Author.objects.get(id=author_id)
    print(author_info)
    book=author_info.books.all()
    books=Book.objects.exclude(id__in = book.values_list('id', flat=True))
    context={
        'author_info' : author_info,
        'book' : book,
        'books' : books
    }
    return render(request,'show.html', context)

def insert(request,author_id):
    this_author=Author.objects.get(id=author_id)
    this_book=Book.objects.get(id=request.POST['book_select_name'])
    this_author.books.add(this_book)
    return redirect(f"authors/{author_id}")
