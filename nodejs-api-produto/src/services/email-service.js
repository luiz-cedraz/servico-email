const { formatCoin } = require("../utils/formatCoin");

const axios = require("axios").default;

const env = process.env;

exports.sendEmail = async ({ title, description, price, active }) => {
  try {
    await axios.post(`${env.URL_SERVICE_EMAIL}/send-email`, {
      emailFrom: env.EMAIL_FROM,
      emailTo: env.EMAIL_TO,
      subject: "Produto cadastrado",
      text: `O produto ${title} foi cadastrado\nPreço: ${formatCoin(price)}\nDescrição: ${description}`,
    });
    return true;
  } catch (error) {
    throw error
  }
};

exports.getEmails = async () => {
  try {
    return (await axios.get(`${env.URL_SERVICE_EMAIL}/retrieve-email`)).data;
  } catch (error) {
    throw error
  }
};
