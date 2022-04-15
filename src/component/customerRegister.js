import react, { Component } from "react";

class CustomerRegister extends Component {
    constructor(props) {
        super(props);
        this.state = {
            firstName: "",
            lastName: "",
            phoneNumber: "",
            emailId: "",
            password: "",
            streetAddress: "",
            city: "",
            country: "",
            zipcode: 0,
            errors: { phoneNumbererror: "", passworderror: "", emailIderror: "", zipcodeerror: "" },
            userphonevalid: false,
            passwordvalid: false,
            emailIdvalid: false,
            zipcodevalid: false,
            formvalid: false
        }
    }

    handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        let errors = this.state.errors;

        let uphnflag = this.state.userphonevalid;
        let pwdflag = this.state.passwordvalid;
        let mailflag = this.state.emailIdvalid;
        let zipflag = this.state.zipcodevalid;
        const regexp = /^[0]?[789]\d{9}$/;
        //  const regexp1 = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$_]){8,12}/;
        //const regexp2=/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-()]){8, 12}$/;
        const regexp2 = /^[a-z0-9]{5}@[A-Za-z0-9.]{5,12}\.[a-z]{2,3}$/;
        const regexp3 = /^[1-9]{1}[0-9]{2}\\s{0, 1}[0-9]{3}$/;

        switch (name) {
            case 'phoneNumber':
                if (!regexp.test(value)) {
                    errors.phoneNumbererror = "Require 10 digits only";
                    uphnflag = false;
                }
                else {
                    errors.phoneNumbererror = "";
                    uphnflag = true;
                }
                break;

            // case 'password':
            //     if (!regexp1.test(value)) {
            //         errors.passworderror = "Password must contain atleast 1 capital,1 small letter,1 number , anything between @#$_ and must be 8 to 12 characters long";
            //         pwdflag = false;
            //         //alert("Password must contain atleast 1 capital,1 small letter ,@#$%^&-() and must be 8 to 12 characters long ");
            //     }
            //     else {
            //         errors.passworderror = "";
            //         // alert("Password accepted");
            //         pwdflag = true;
            //     }
            //     break;

            /* case 'emailId':
                 if(!regexp2.test(value))
                 {
                    // alert("Enter correct Email");
                     errors.emailIderror="Enter correct Email";
                     mailflag=false;
                 }
                 else
                 {
                     errors.emailIderror="";
                     mailflag=true;
                 }
                 break;
 
                 case 'zipcode':
                 if(!regexp3.test(value))
                 {
                     errors.zipcodeerror="Enter correct zipcode";
                     zipflag=false;
                 }
                 else
                 {
                     errors.zipcodeerror="";
                     zipflag=true;
                 }
                 break;*/
            default:
                {

                }

        }
        this.setState({ errors, [name]: value, userphonevalid: uphnflag }, () => { this.setState({ formvalid: uphnflag }) });

        //this.setState({ [name]: value });



    }

    submitData = (e) => {
        e.preventDefault();
        /// alert(this.state.firstName);
        const reqOptions = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(
                {
                    firstName: this.state.firstName,
                    lastName: this.state.lastName,
                    phoneNumber: this.state.phoneNumber,
                    emailId: this.state.emailId,
                    password: this.state.password,
                    streetAddress: this.state.streetAddress,
                    city: this.state.city,
                    country: this.state.country,
                    zipcode: this.state.zipcode,
                }
            )
        }


        fetch("http://localhost:8080/customer/register", reqOptions)
            .then(resp => resp.text())
            .then(data => {
                if (data.length != 0) {
                    const json = JSON.parse(data);
                    this.setState({ errors: "Regsiter success" });
                    alert("Registration Successful LOGIN NOW")
                    // this.props.history.push("/login");


                }
                else {
                    this.setState({ registerError: "Wrong UserName /Password" });
                }
            })
    }
    render() {
        return (
            <div>
                <div style={{ width: "500px" }}>
                    <h2>Customer Register</h2>
                    <form className="main-form needs-validation">
                        <div className="row">
                            <div className="col">
                                <div className="form-group">
                                    <label htmlfor="firstName">First Name</label>
                                    <input type="text" name="firstName" className="form-control" onChange={this.handleChange} required />
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-group">
                                    <label htmlfor="lastName">Last Name</label>
                                    <input type="text" name="lastName" className="form-control" onChange={this.handleChange} required />
                                </div>
                            </div>
                        </div>
                        <div className="row">
                            <div className="col">
                                <div className="form-group">
                                    <label htmlfor="phoneNumber">Phone Number</label>
                                    <input type="number" name="phoneNumber" className="form-control" onChange={this.handleChange} required minLength="10" maxLength="10" pattern="/^\d{10}$\/" />
                                    <span style={{ color: 'red' }}>{this.state.errors.phoneNumbererror}</span>
                                </div>
                            </div>

                            <div className="col">
                                <div className="form-group">
                                    <label htmlfor="emailId">Email Id</label>
                                    <input type="email" name="emailId" className="form-control" onChange={this.handleChange} required />
                                </div>
                            </div>
                        </div>
                        <div className="form-group">
                            <label htmlfor="password">Password</label>
                            <input type="password" name="password" className="form-control" onChange={this.handleChange} required max="6" min="4" />

                        </div>
                        <div className="form-group">
                            <label htmlfor="streetAddress">Street Address</label>
                            <input type="text" name="streetAddress" className="form-control" onChange={this.handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlfor="city">City</label>
                            <input type="text" name="city" className="form-control" onChange={this.handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlfor="country">Country</label>
                            <input type="text" name="country" className="form-control" onChange={this.handleChange} required />
                        </div>
                        <div className="form-group">
                            <label htmlfor="zipcode">Zipcode</label>
                            <input type="number" name="zipcode" className="form-control" onChange={this.handleChange} required maxLength="6" minLength="6" pattern="^[1-9][0-9]{5}$" />
                        </div>
                        <div>
                            <button type="button" className="btn btn-primary" disabled={!this.state.formvalid} onClick={this.submitData}>Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        )
    }


}

export default CustomerRegister;