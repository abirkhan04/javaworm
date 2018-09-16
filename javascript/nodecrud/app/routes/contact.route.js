module.exports = (app) => {
    const contacts = require('../controller/contact.controller.js');

    // Create a new Note
    app.post('/createcontact', contacts.create);

    // Retrieve all Notes
    app.get('/findcontacts', contacts.findAll);

    // Retrieve a single Note with contactId
    app.get('/contacts/:contactId', contacts.findOne);

    // Update a Note with noteId
    app.put('/contacts/:contactId', contacts.update);

    // Delete a Note with noteId
    app.delete('/contacts/:contactId', contacts.delete);
}