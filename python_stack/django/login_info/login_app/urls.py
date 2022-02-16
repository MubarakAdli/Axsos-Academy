from django.urls import path
from . import views

urlpatterns = [
        path('',views.show),
        path('reg',views.reg),
        path('login',views.login),
        path('success',views.result),
]