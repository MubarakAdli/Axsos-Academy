
from django.db import models
import re
import bcrypt

class LoginManager(models.Manager):
        def basic_validator(self, postData):
                errors = {}
                if len(postData['first']) < 2:
                        errors["first"] = "First Name should be at least 2 characters"
                if len(postData['last']) < 2:
                        errors["last"] = "Last Name should be at least 2 characters"
                if len(postData['pass'])!= len(postData['confirm']):
                        errors["pass"] = "password doesnot match"
                if len(postData['pass']) < 8:
                        errors["pass"] = "password must be at least 8 characters "
                EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
                if not EMAIL_REGEX.match(postData['email']):
                        errors['email'] = "Invalid email address"
                return errors
        

class Login(models.Model):
        first_name = models.CharField(max_length=255)
        last_name = models.CharField(max_length=255)
        email_address = models.CharField(max_length=255)
        password = models.CharField(max_length=255)
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)
        objects = LoginManager()