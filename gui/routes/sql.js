// Routes relating to SQL CRUD operations

const express = require('express');

const router = express.Router();

// See if we can hit the SQL server
router.get('/', (req, res) => {
    res.send("got into sql");
});

module.exports = router;