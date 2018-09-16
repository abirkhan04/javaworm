const mongoose = require('mongoose');

const contactSchema = mongoose.Schema({
    phone: String,
    address: String
  }, {
    timestamps: true
});

module.exports = mongoose.model('Contact', contactSchema);