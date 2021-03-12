const app = require('./app');

const server = app.listen(3000, () => {
    console.log(`Started express server on port ${server.address().port}`)
})