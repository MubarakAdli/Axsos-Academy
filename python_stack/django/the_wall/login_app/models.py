from django.db import models
import re
from datetime import datetime
import bcrypt

class UserManager(models.Manager):
        def register_validator(self, postData):
                errors = {}
                if len(postData['first']) < 2:
                        errors["name"] = "User first name should be at least 2 characters"
                if len(postData['last']) < 2:
                        errors["last"] = "User last name should be at least 2 characters"
                if len(postData['password']) < 8:
                        errors["password"] = "password should be at least 8 characters"
                if postData['password'] != postData['confirm'] :
                        errors["password"] = "passwords dont match"
                if  postData['date'] > str(datetime.now()) :
                        errors["date"] = "Birthday should be in the past"
                EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
                if not EMAIL_REGEX.match(postData['email']):               
                        errors['email'] = "Invalid email address!"
                return errors


        def login_validator(self,postData):
                errors={}
                this_user=User.objects.get(email=postData['login-email'])
                if not bcrypt.checkpw(postData['login-password'].encode(), this_user.password.encode()):
                        errors['not_match']="password is not correct"
                EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
                if not EMAIL_REGEX.match(postData['login-email']):
                        errors['email'] = "Invalid email address!"
                return errors


class User(models.Model):
        first_name = models.CharField(max_length=255)
        last_name= models.CharField(max_length=255)
        email = models.TextField()
        password= models.CharField(max_length=255)
        birthday=models.DateField(null=True)
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)
        objects=UserManager()


class Message(models.Model):
        message=models.TextField()
        users = models.ForeignKey(User,related_name="messages", on_delete = models.CASCADE)
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)


class Comment(models.Model):
        comment=models.TextField()
        users = models.ForeignKey(User, related_name="comments", on_delete = models.CASCADE)
        message = models.ForeignKey(Message, related_name="comments", on_delete = models.CASCADE)
        created_at = models.DateTimeField(auto_now_add=True)
        updated_at = models.DateTimeField(auto_now=True)