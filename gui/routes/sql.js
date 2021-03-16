// SQL CRUD routes

const express = require('express');

const router = express.Router();

// See if we can hit the SQL server
router.get('/', (req, res) => {
    res.send("welcome to sql");
});

module.exports = router;