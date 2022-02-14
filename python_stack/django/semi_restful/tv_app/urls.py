from django.urls import path
from . import views	

urlpatterns = [
    path('', views.show),
    path('new', views.add_show),
    path('movie', views.movie),
    path('<show_id>', views.display),
    path('remove/<show_id>', views.remove),
    path('<show_id>/edit', views.edit_info),
    path('edit/<show_id>', views.update_info),
]
    
