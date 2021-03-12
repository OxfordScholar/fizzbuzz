const express = require('express');

const router = express.Router();

router.get('/', (req, res) => {
    res.send("Hit the endpoint");
});

module.exports = router;