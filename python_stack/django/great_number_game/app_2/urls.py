from django.urls import path     
from . import views

urlpatterns = [
    path('', views.rand_num),
    path('result', views.result),
]