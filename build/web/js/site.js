function validateRepair() {

    var valid = true;

    //Validate the owner field
    if (document.getElementById("owner").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0 || document.getElementById("owner").value == "Invalid Name")         //name should be at least 6 characters. Not complete regex. Each character should be a-z OR A-Z OR ' or - or _ or space
    {
        valid = false;
        document.getElementById("owner").value = "Invalid Name";
        document.getElementById("owner").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {

        document.getElementById("owner").style = "none";
    }


    //Validate the serial number field
    if (document.getElementById("serial-number").value.search(/\d{2}-\d{5}-\d{6}/) != 0 || document.getElementById("serial-number").value == "Inavlid Serial Number")        //XX-XXXXX-XXXXXX  
    {
        valid = false;
        document.getElementById("serial-number").value = "Inavlid Serial Number";
        document.getElementById("serial-number").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("serial-number").style = "none";
    }


    //Validate the type field
    if (document.getElementById("type").value == "Select One Type") {
        valid = false;
        document.getElementById("type").value = "Select One Type";
        document.getElementById("type").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("type").style = "none";
    }

    //Validate the model field
    if (document.getElementById("model").value == "" || document.getElementById("model").value == "Please Enter The Model")       // empty
    {
        valid = false;
        document.getElementById("model").value = "Please Enter The Model";
        document.getElementById("model").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("model").style = "none";
    }

    //Validate the memory size field
    if (document.getElementById("memory-size").value.search(/^[0-9]/) != 0 || document.getElementById("memory-size").value == "Invalid HardDesk Size")        // only numbers 
    {
        valid = false;
        document.getElementById("memory-size").value = "Invalid HardDesk Size";
        document.getElementById("memory-size").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("memory-size").style = "none";
    }

    //Validate the harddesk size field
    if (document.getElementById("harddesk-size").value.search(/^[0-9]/) != 0 || document.getElementById("harddesk-size").value == "Invalid HardDesk Size")        // only numbers 
    {
        valid = false;
        document.getElementById("harddesk-size").value = "Invalid HardDesk Size";
        document.getElementById("harddesk-size").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("harddesk-size").style = "none";
    }

    //Validate the problems field
    if (document.getElementById("problems").value == "" || document.getElementById("problems").value == "Please Enter Your Problems")       // empty
    {
        valid = false;
        document.getElementById("problems").value = "Please Enter Your Problems";
        document.getElementById("problems").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("problems").style = "none";
    }

    //Validate the repair cost field
    if (document.getElementById("repair-cost").value != "") {
        if (document.getElementById("repair-cost").value.search(/^[0-9]/) != 0 || document.getElementById("repair-cost").value == "Invalid Repair Cost !")        // only numbers 
        {
            valid = false;
            document.getElementById("repair-cost").value = "Invalid Repair Cost !";
            document.getElementById("repair-cost").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
        }
        else {
            document.getElementById("repair-cost").style = "none";
        }
    }
    else {
        document.getElementById("repair-cost").style = "none";
    }

    //Validate the repair status field
    if (document.getElementById("repair-status").value != "") {
        if (document.getElementById("repair-status").value == "Enter short status" || document.getElementById("repair-status").value.length > 20)        // numbers not alowed
        {
            valid = false;
            document.getElementById("repair-status").value = "Enter short status";
            document.getElementById("repair-status").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
        }
        else {
            document.getElementById("repair-status").style = "none";
        }
    } else {
        document.getElementById("repair-status").style = "none";
    }

    //Validate the Repair Finish DateTime fields
    if (document.getElementById("finish-date").value != "") {
        if (document.getElementById("finish-date").value.search(/^([0-9]{2,4})-([0-1][0-9])-([0-3][0-9])(?:( [0-2][0-9]):([0-5][0-9]):([0-5][0-9]))?$/) != 0 || document.getElementByName("finish-date").value == "Invalid DateTime") {
            valid = false;
            document.getElementById("finish-date").value = "Invalid DateTime";
            document.getElementById("finish-date").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
        }
        else {
            document.getElementById("finish-date").style = "none";
        }
    }
    else {
        document.getElementById("finish-date").style = "none";
    }

    //Validate the Repair Delivery DateTime fields
    if (document.getElementById("delivery-date").value.search(/^([0-9]{2,4})-([0-1][0-9])-([0-3][0-9])(?:( [0-2][0-9]):([0-5][0-9]):([0-5][0-9]))?$/) != 0 || document.getElementById("delivery-date").value == "Invalid DateTime") {
        valid = false;
        document.getElementById("delivery-date").value = "Invalid DateTime";
        document.getElementById("delivery-date").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("delivery-date").style = "none";
    }

    if (valid == false) {
        return false;    // don't submit the form data to the server because of validation error(s)
    }
    else {
        return true;     // submit the form data to the server because all data looks correct
    }

}
function validateFeedback() {

    var valid = true;

    //Validate the name field
    if (document.getElementById("name").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0 || document.getElementById("name").value == "Invalid Name")         //name should be at least 6 characters. Not complete regex. Each character should be a-z OR A-Z OR ' or - or _ or space
    {
        valid = false;
        document.getElementById("name").value = "Invalid Name";
        document.getElementById("name").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {

        document.getElementById("name").style = "none";
    }

    //Validate the country field
    if (document.getElementById("country").value == "Select One Country") {
        valid = false;
        document.getElementById("country").value = "Select One Country";
        document.getElementById("country").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("country").style = "none";
    }

    //Validate the phone number field
    if (document.getElementById("phone").value.search(/^(05\d{8}|9665\d{8})$/) != 0 || document.getElementById("phone").value == "Invalid Phone Number") {
        valid = false;
        document.getElementById("phone").value = "Invalid Phone Number";
        document.getElementById("phone").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("phone").style = "none";
    }


    //Validate the email field
    if (document.getElementById("email").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0 || document.getElementById("email").value == "Invalid Email") {
        valid = false;
        document.getElementById("email").value = "Invalid Email";
        document.getElementById("email").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("email").style = "none";
    }

    //Validate the subject field
    if (document.getElementById("subject").value == "" || document.getElementById("subject").value == "Please Enter The Subject") {
        valid = false;
        document.getElementById("subject").value = "Please Enter The Subject";
        document.getElementById("subject").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("subject").style = "none";
    }

    //Validate the type field
    if (document.getElementById("type").value == "" || document.getElementById("type").value == "Please Enter The Type") {
        valid = false;
        document.getElementById("type").value = "Please Enter The Type";
        document.getElementById("type").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("type").style = "none";
    }

    //Validate the message field
    if (document.getElementById("message").value == "" || document.getElementById("message").value == "Please Enter Your Message") {
        valid = false;
        document.getElementById("message").value = "Please Enter Your Message";
        document.getElementById("message").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("message").style = "none";
    }



    if (valid == false) {
        return false;    // don't submit the form data to the server because of validation error(s)
    }
    else {
        return true;     // submit the form data to the server because all data looks correct
    }

}
function validateRegister() {

    var valid = true;

    //Validate the name field
    if (document.getElementById("name").value.search(/^[A-Za-z'\-\._ ]{6,}$/) != 0 || document.getElementById("name").value == "Invalid Name")         //name should be at least 6 characters. Not complete regex. Each character should be a-z OR A-Z OR ' or - or _ or space
    {
        valid = false;
        document.getElementById("name").value = "Invalid Name";
        document.getElementById("name").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {

        document.getElementById("name").style = "none";
    }


    //Validate the email field
    if (document.getElementById("email").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0 || document.getElementById("email").value == "Invalid Email") {
        valid = false;
        document.getElementById("email").value = "Invalid Email";
        document.getElementById("email").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("email").style = "none";
    }

    //Validate the password and confirm password field
    if (document.getElementById("password").value.length < 6 || document.getElementById("password").value != document.getElementById("confirm-password").value || document.getElementById("password").value == "two Passwords should match and be at least 6 characters") {
        valid = false;
        document.getElementById("password").type = "text";
        document.getElementById("password").value = "two Passwords should match and be at least 6 characters";
        document.getElementById("password").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
        document.getElementById("confirm-password").value = "";
        document.getElementById("confirm-password").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("password").style = "none";
        document.getElementById("confirm-password").style = "none";
    }

    if (valid == false) {
        return false;    // don't submit the form data to the server because of validation error(s)
    }
    else {
        return true;     // submit the form data to the server because all data looks correct
    }

}
function validateLogin() {

    var valid = true;

    //Validate the email field
    if (document.getElementById("email").value.search(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/) != 0 || document.getElementById("email").value == "Invalid Email") {
        valid = false;
        document.getElementById("email").value = "Invalid Email";
        document.getElementById("email").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("email").style = "none";
    }

    //Validate the password and confirm password field
    if (document.getElementById("password").value.length < 6 || document.getElementById("password").value == "Password should be at least 6 characters") {
        valid = false;
        document.getElementById("password").type = "text";
        document.getElementById("password").value = "Password should be at least 6 characters";
        document.getElementById("password").style = "border-color: #c92432; color: #c92432;background: #F7C7CB;";
    }
    else {
        document.getElementById("password").style = "none";
    }

    if (valid == false) {
        return false;    // don't submit the form data to the server because of validation error(s)
    }
    else {
        return true;     // submit the form data to the server because all data looks correct
    }

}

// to change the type of input tag
function changeType() {
    let pass = document.getElementById("password");
    if (pass.value == "two Passwords should match and be at least 6 characters" || pass.value == "Password should be at least 6 characters") {
        pass.value = "";
        pass.type = "password";
    }
}

// after the full page is loaded this function will be excuted
document.addEventListener('DOMContentLoaded', function () {
    document.getElementById("password").onclick = changeType;
});


/*
 String sql = "INSERT INTO Repairs (ComputerOwner, ComputerSerialNumber, Type, "
                    + "Model, MemoryGB, HardDeskGB, Problems, RepairCost, RepairStatus, "
                    + "RepairFinishDateTime, RepairDeliveryDateTime) VALUES (?, ?, ?, ?, ?, ?, "
                    + "?, ?, ?, ?, NOW())";   //NOW())";
            PreparedStatement pStmt  =  conn.prepareStatement(sql);
            pStmt.setString(1, uname);                     // 1 specifies the first parameter in the query
            pStmt.setString(2, phone);             // 2 specifies the second parameter in the query
            pStmt.setString(3, country);
            pStmt.setString(4, gender_character);
            pStmt.setString(5, english_character);
            pStmt.setString(6, arabic_character);
            pStmt.setString(7, french_character);
            pStmt.setString(8, italian_character);
            pStmt.setString(9, email);
            pStmt.setString(10, password);
 */

