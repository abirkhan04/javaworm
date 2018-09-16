const Contact = require('../model/contact.model.js');

exports.create = (req, res) => {
    if (!req.body) {
        return res.status(400).send({
            message: "Contact can not be empty"
        });
    }

    const contact = new Contact({
        phone: req.body.phone,
        address: req.body.address
    });

    contact.save()
        .then(data => {
            res.send(data);
        }).catch(err => {
            res.status(500).send({
                message: err.message || "Some error occurred while creating the Contact."
            });
        });
};


exports.findAll = (req, res) => {
    Contact.find()
        .then(contacts => {
            res.send(contacts);
        }).catch(err => {
            res.status(500).send({
                message: err.message || "Some error occurred while retrieving contacts."
            });
        });
};


exports.findOne = (req, res) => {
    console.log(req.params.contactId);
    Contact.findById(req.params.contactId)
        .then(contact => {
            if (!contact) {
                return res.status(404).send({
                    message: "Contact not found with id " + req.params.contactId
                });
            }
            res.send(contact);
        }).catch(err => {
            if (err.kind === 'ObjectId') {
                return res.status(404).send({
                    message: "Contact not found with id " + req.params.contactId
                });
            }
            return res.status(500).send({
                message: "Error retrieving contact with id " + req.params.contactId
            });
        });
};


exports.update = (req, res) => {
    // Validate Request
    if (!req.body) {
        return res.status(400).send({
            message: "Contact content can not be empty"
        });
    }

    // Find note and update it with the request body
    Contact.findByIdAndUpdate(req.params.contactId, {
        phone: req.body.phone,
        address: req.body.address
    }, { new: true })
        .then(contact => {
            if (!contact) {
                return res.status(404).send({
                    message: "Contact is not found with id " + req.params.contactId
                });
            }
            res.send(contact);
        }).catch(err => {
            if (err.kind === 'ObjectId') {
                return res.status(404).send({
                    message: "Contact not found with id " + req.params.contactId
                });
            }
            return res.status(500).send({
                message: "Error updating note with id " + req.params.contactId
            });
        });
};

exports.delete = (req, res) => {

};
