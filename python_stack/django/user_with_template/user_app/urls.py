from django.urls import path
from . import views

urlpatterns = [
    path('',views.show),
    path('process', views.info),
]