from django.urls import path
from . import views

urlpatterns = [
        path('book', views.view),
        path('addbook', views.addbook),
        path('add_fav/<book_id>',views.favarite),
        path('book/<book_id>',views.edit),
        path('delete/<book_id>',views.delete),
        path('update/<book_id>',views.update),
        path('delete/fav/<x>',views.deletefavarite),
]
