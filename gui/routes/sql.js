// SQL CRUD routes

const express = require('express');

const router = express.Router();

router.get('/', (req, res) => {
    res.send("welcome to sql");
});



module.exports = router;