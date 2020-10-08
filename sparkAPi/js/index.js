
/*var obj = JSON.parse('{"firstName":"John", "lastName":"Doe"}');
console.log(obj.lastName)
*/

const https = require('http');



fs = require('fs');


let url = "http://localhost:8080";

https.get(url, (res) => {
    let body = "";

    res.on("data", (chunk) => {
        body += chunk;
    });

    res.on("end", () => {
        try {
            let json = JSON.parse(body);
            console.log(json.wings)
            fs.writeFileSync("customtEST.txt", json.wings)
        } catch (error) {
            console.error(error.message);
        };
    });

}).on("error", (error) => {
    console.error(error.message);
});