const express = require("express");
const app = express();
const port = 8000;

const { faker } = require('@faker-js/faker');

class User {
    constructor(id, firstName, lastName, email, phoneNumber) {
        this._id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

class Company {
    constructor(id, name, address) {
        this._id = id;
        this.name = name;
        this.address = address;
    }
}
const createUser = () => {
    const newUser = new User(
        faker.datatype.number(),
        faker.name.findName(),
        faker.name.findName(),
        faker.internet.email(),
        faker.phone.phoneNumber()
    )

    return newUser;
};

const createCompany = () => {
    const newCompany = new Company(
        faker.datatype.number(),
        faker.company.companyName(),
        {
            street: faker.address.streetName(),
            city: faker.address.cityName(), 
            state: faker.address.state(),
            zipCode: faker.address.zipCode(), 
            country: faker.address.country()
        }
    )

    return newCompany;
};
app.listen( port, () => console.log(`Listening on port: ${port}`) );

app.get("/api", (req, res) => {
    res.json({ message: "Hello World!!" });
});
app.get("/api/user/new", (req, res) => {
    const newUser = createUser()
    res.json(newUser);
});
app.get("/api/company/new", (req, res) => {
    const newCompany = createCompany()
    res.json(newCompany);
});
app.get("/api/user/company", (req, res) => {
    const newUser = createUser()
    const newCompany = createCompany()
    res.json({newUser, newCompany});
});