const service = require("../services/email-service");

exports.getEmails = async (req, res) => {
  const emails = await service.getEmails();
  res.status(200).send(emails);
};