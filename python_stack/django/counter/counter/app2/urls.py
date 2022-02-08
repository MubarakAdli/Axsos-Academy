from django.urls import path
from . import views

urlpatterns = [
    path('',views.show),
    path('result', views.result),
    path('destroy', views.clear),
    path('add2', views.add2),
    path('increment',views.increment)
]