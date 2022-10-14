const express = require("express");
const app = express();
const mongoose = require("mongoose");
const cors = require("cors");

require("dotenv").config();

mongoose.connect("mongodb+srv://admin:Fiap%402022@clusterfiap.uyj4sie.mongodb.net/produto");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cors());

app.use((req, res, next) => {
  next();
});

require("./models/product");

const product = require("./routes/product-route");
const emails = require("./routes/emails-route");

app.use("/products", product);
app.use("/emails", emails);

module.exports = app;
