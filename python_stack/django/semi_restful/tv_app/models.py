from django.db import models
from datetime import datetime

class ShowManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['title']) < 2:
            errors["title"] = "Title should be at least 2 characters"
        if len(postData['network']) < 3:
            errors["network"] = "Network should be at least 3 characters"
        if len(postData['desc']) < 10:
            errors["desc"] = "Description should be at least 10 characters"
        if postData['date']>str(datetime.now()):
            errors["date"] = " Release_date should be in the past"
        return errors


class Show(models.Model):
    title=models.CharField(max_length=255)
    network=models.CharField(max_length=255)
    release_date=models.DateTimeField()
    desc=models.TextField()
    created_at=models.DateTimeField(auto_now_add=True)
    updated_at=models.DateTimeField(auto_now=True)
    objects = ShowManager()