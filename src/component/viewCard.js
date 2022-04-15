import react from "react";
import { connect } from "react-redux";
import { mystore } from "./store";
import axios from 'axios';

class ViewCard extends react.Component {

    // constructor(props)
    // {
    //     super(props);
    //     this.state={
    //        cardDetails: props.carddetails
    //     }
    // }

    // componentDidMount() {
    //     this.setState( { cardDetails : this.props.carddetails} );
    // }

    addQty = menuId => {
        this.props.addMenuQty(menuId);
    }

    removeQty = menuId => {
        this.props.removeMenuQty(menuId);
    }

    removeItem = menuId => {
        this.props.removeMenuItem(menuId);
    }
    getAmount = () => {
        let amount = 0;
        this.props.carddetails.map(({ rate, qty }) => {

            amount = amount + rate * qty;
            // alert(amount+ ""+rate+""+qty);
        })
        return amount;
    }
    //customer_id ,"branchId":1,menuDetails:{ menuId,quantity}
    //http://localhost:8080/customer/saveOrder

    submitData = (e) => {

        const body = []
        e.map((ele) => {
            body.push({ "menuId": ele.menuId, "quantity": ele.qty })
        })
        //  console.log(body)
        const request = {

            "customerId": JSON.parse(localStorage.getItem('loggedUser')).customerId,
            "branchId": 1,
            "menuDetails": body

        }

        console.log("🚀 ~ file: viewCard.js ~ line 52 ~ ViewCard ~ request", request)

        axios.post('http://localhost:8080/customer/saveOrder', request)
            .then(response => {

                return response.data
            })
            .then((data) => {
                alert("Order Placed successfully")
                //     this.props.carddetails  ;
                this.setState({ carddetails: {} });
            })


    }
    render() {
        return (
            <div>
                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Menu</th>
                            <th scope="col">Rate</th>
                            <th scope="col">Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.props.carddetails.map(({ image, rate, menuId, qty }, index) => {
                            return (<tr key={menuId}>
                                <th scope="row">{index + 1}</th>
                                <td> <img src={`data:image/jpeg;base64,${image}`}></img></td>
                                <td> <label>{rate}</label></td>
                                <td>
                                    <button onClick={() => { this.removeQty(menuId) }} className="btn">-</button>
                                    <span>{` ${qty} `}</span>
                                    <button onClick={() => { this.addQty(menuId) }} className="btn">+</button>
                                    <button onClick={() => { this.removeItem(menuId) }} className="btn">Remove Item</button>
                                </td>
                            </tr>)
                        })}
                        <tr scope="row">Total Amount</tr>
                        <td><label id="amt">{this.getAmount()}</label> </td>
                        <td > <button onClick={() => this.submitData(this.props.carddetails)}>Place Order</button></td>
                    </tbody>
                </table>
            </div>
        )
    }
}

const mapStateToProps = (state) => {
    return {
        carddetails: state?.carddetails || []
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        addMenuQty: (id) => { dispatch({ type: 'ADD_QTY', payload: id }) },
        removeMenuQty: (id) => { dispatch({ type: 'REMOVE_QTY', payload: id }) },
        removeMenuItem: (id) => { dispatch({ type: 'REMOVE_ITEM', payload: id }) }
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ViewCard);