from django.urls import path
from . import views

urlpatterns = [
    path('wall',views.wall),
    path('message/<user_id>',views.message),
    path('comment/<i_id>/<user_id>',views.comment),
]