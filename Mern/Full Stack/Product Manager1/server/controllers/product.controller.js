const { Product } = require('../models/product.model');
module.exports.index = (request, response) => {
    response.json({
        message: "Hello World"
    });
}
    // The method below is new
module.exports.createProduct = (request, response) => {
    const { title, description,price } = request.body;
    Product.create({
    title,
    price,
    description
    })
    .then(product =>┬áresponse.json(product))
    .catch(err =>┬áresponse.json(err));
}
