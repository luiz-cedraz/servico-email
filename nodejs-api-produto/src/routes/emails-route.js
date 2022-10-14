const express = require("express");
const router = express.Router();
const controller = require("../controllers/email-controller");

router.get("/", controller.getEmails);

module.exports = router;
