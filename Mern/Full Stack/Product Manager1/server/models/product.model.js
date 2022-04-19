const mongoose = require('mongoose');
const ProductSchema = new mongoose.Schema({
    
    description: { type: String },
    title: { type: String },
    price: { type: Number }
}, { timestamps: true });
module.exports.Product = mongoose.model('Person', ProductSchema);
