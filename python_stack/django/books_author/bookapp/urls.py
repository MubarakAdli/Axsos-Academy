from django.urls import path
from . import views

urlpatterns = [
    path('', views.view),
    path('add_book', views.book),
    path('books/<book_id>', views.details),
    path('authors',views.show),
    path('add<book_id>', views.add),
    path('authors/<author_id>' , views.desc1),
    path('add_author', views.addauthor),
    path('plus<author_id>', views.insert)
]