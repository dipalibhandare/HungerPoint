import axios from "axios";
import react, { Component } from "react";
import { mystore } from "./store";
import { withRouter } from './withRouter';

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            phoneNumber: "",
            password: "",
            customer: {},
            admin: {},
            branchManager: {},
            deliveryExecutive: {},
            loginError: ""
        }
    }

    handleChange = (e) => {
        const name = e.target.name;
        const value = e.target.value;
        this.setState({ [name]: value });

    }

    submitData = (e) => {


        const reqOptions =
        {
            "phoneNumber": this.state.phoneNumber,
            "password": this.state.password

        }



        axios.post("http://localhost:8080/home/login", reqOptions)
            .then(resp => {

                if (resp.data.login.role == "customer") {

                    this.setState({ customer: resp.data });
                    localStorage.setItem("loggedUser", JSON.stringify(this.state.customer));
                    mystore.dispatch({ type: 'LOGGEDIN' })
                    this.props.navigate("/");
                }


                else {
                    console.log("invalid")
                    this.setState({ loginError: "Wrong UserName /Password" });
                }

            })
            .then(data => {
                console.log("🚀 ~ file: login.js ~ line 51 ~ Login ~ data", data)

            })
    }

    render() {
        return (
            <div>
                <div style={{ width: "500px" }}>
                    <h2>Login</h2>
                    <form >
                        <div className="form-group">
                            <label htmlFor="phoneNumber">Phone Number</label>
                            <input type="text" name="phoneNumber" className="form-control" onChange={this.handleChange} />
                        </div>
                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <input type="password" name="password" className="form-control" onChange={this.handleChange} />
                        </div>
                        <button type="button" className="btn btn-primary" onClick={this.submitData}>Submit</button>
                    </form>

                </div>
            </div>
        )
    }


}

export default withRouter(Login);