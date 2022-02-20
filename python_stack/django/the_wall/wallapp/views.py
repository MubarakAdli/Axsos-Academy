from django.shortcuts import render,redirect

from login_app.models import User,Message,Comment


def wall(request):

    context={
        'message':Message.objects.all(),
        'comment':Comment.objects.all(),
        'user' : User.objects.get(id=request.session['user_id'])
    }
    return render(request,'wall.html',context)

def message(request,user_id):
    Message.objects.create(message=request.POST['message'],users=User.objects.get(id=user_id))

    return redirect('/wall')

def comment(request,user_id,message_id):
    Comment.objects.create(comment=request.POST['comment'],users=User.objects.get(id=user_id),message=Message.objects.get(id=message_id))
    return redirect('/wall')

