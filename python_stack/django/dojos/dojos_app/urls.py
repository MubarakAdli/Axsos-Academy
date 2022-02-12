from django.urls import path     
from . import views

urlpatterns = [
    path('', views.result),
    path('ninja', views.ninja),
    path('dojo', views.dojo),
]