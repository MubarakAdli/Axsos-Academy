const express = require('express');
const { Socket } = require('socket.io');
const app = express();

const server = app.listen(8000, () =>
    console.log('The server is all fired up on port 8000')
);

const io = require('socket.io')(server, { cors: true });
io.on("connection",Socket=>{
    Socket.emit("connection",null)
    Socket.on("message",data=>{
        console.log(data)
        Socket.broadcast.emit("message",data)
    })
});