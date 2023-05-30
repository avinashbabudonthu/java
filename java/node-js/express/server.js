// add express
const express = require('express');
const app = express();
const bodyParser = require('body-parser');

// to make server listen on port 3000
app.listen(3000, () => {
    console.log("server listening on 3000");
});

app.use(bodyParser.json()); // to read income request body json

// get api
app.get('/get-api1', (request, response) => {
    response.send("Hello Express");
});

// post api
// For post api we need to read income request body. For this we need to install body-parser module
// npm install body-parser
app.post("/post-api1", (request, response) => {
    let body = request.body;
    console.log(body); // { name: 'jim' }
    body.message = "Hello " + body.name;
    response.json(body);
});