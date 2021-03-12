const express = require('express');

// Define routes
const index = require('./routes/index');
const sql = require('./routes/sql');

const app = express();

// Use routes
app.use('/', index);
app.use('/sql', sql);

module.exports = app;