import React, { Component } from 'react'
import CartService from '../../services/CartService';
import OrderService from '../../services/OrderService';
import ReactDOM from "react-dom"

const PayPalButton = window.paypal.Buttons.driver("react", { React, ReactDOM });

class Address extends Component {
    constructor(props) {
        super(props)

        this.state = {
               cart:[],
               item:[],
                profileid:'',
                fullName:'',
                mobileNumber:'',
                houseNumber:'',
                city:'',
                state1:'',
                pincode:'',
                fulladdress:'',
                modeOfPayment:'COD'
        }
        
        this.changeFullnameHandler = this.changeFullnameHandler.bind(this);
        this.changeHouseNumberHandler = this.changeHouseNumberHandler.bind(this);
        this.changeMobileNumberHandler = this.changeMobileNumberHandler.bind(this);
        this.changeState = this.changeState.bind(this);
        this.changeCity = this.changeCity.bind(this);
        this.changePincode = this.changePincode.bind(this);
        this.changeFulladdress = this.changeFulladdress.bind(this);
        this.addAddress = this.addAddress.bind(this);
    }


    createOrder(data, actions) {
        return actions.order.create({
          purchase_units: [
            {
              amount: {
                value: this.state.cart.totalPrice || 2,
              },
            },
          ],
        });
    }
    
    // onSuccess(){
    //     this.setState({modeOfPayment: "online"});
    //     this.addAddress();
    //     this.props.history.push(`/cart`);
    // }
   

    onApprove(data, actions) {
        this.setState({modeOfPayment: "PayPal"});
        this.addAddress();
        return actions.order.capture().then(function(details){
            console.log("Paid");
            console.log(details);
            
        });
    }

    onCancel(data){
        console.log('The payment was cancelled!', data);
        this.props.history.push(`/cart`);
    }

     
    addAddress = (e) => {

        let address = {
                profileid: localStorage.userid,
                fullName: this.state.fullName,
                houseNumber: this.state.houseNumber,
                mobilenumber: this.state.mobilenumber,
                city: this.state.city,
                state: localStorage.state1,
                pincode: this.state.pincode,
                fulladdress: this.state.fulladdress,
            };
        console.log('address => ' + JSON.stringify(address));

              
        let order={
            address: address,
            ammountPaid: this.state.cart.totalPrice,
            items: this.state.cart.items,
            modeOfPayment: this.state.modeOfPayment,
            profileid: localStorage.userid,
        }

        console.log('order => ' + JSON.stringify(order));

        
        OrderService.placeOrder(order);

        this.props.history.push(`/cart`);
            
    }

    changeFullnameHandler= (event) => {
        this.setState({fullName: event.target.value});
    }
    
    changeMobileNumberHandler= (event) => {
        this.setState({mobileNumber: event.target.value});
    }

    changeHouseNumberHandler= (event) => {
        this.setState({fulladdress: this.state.houseNumber+', '+ this.state.city+ ', '+ this.state.state1 +', ' + this.state.pincode})
        this.setState({houseNumber: event.target.value});
    }

    changeState= (event) => {
        this.setState({fulladdress: this.state.houseNumber+', '+ this.state.city+ ', '+ this.state.state1 +', ' + this.state.pincode})
        this.setState({state1: event.target.value});
    }

    changeCity= (event) => {
        this.setState({fulladdress: this.state.houseNumber+', '+ this.state.city+ ', '+ this.state.state1 +', ' + this.state.pincode})
        this.setState({city: event.target.value});
    }

    changePincode= (event) => {
        this.setState({fulladdress: this.state.houseNumber+', '+ this.state.city+ ', '+ this.state.state1 +', ' + this.state.pincode})
        this.setState({pincode: event.target.value});
    }

    changeFulladdress= (event) => {
        this.setState({fulladdress: this.state.houseNumber+ this.state.city+ this.state.state1 + this.state.pincode})
        this.setState({fulladdress: event.target.value});
    }

    componentDidMount(){
        CartService.getCartById(localStorage.userid).then((res) => {
            this.setState({ cart: res.data});
            this.setState({ item: this.state.cart.items });
            console.log('cart => ' + JSON.stringify(this.state.cart));

        });
    }


 
    render() {

        const onSuccess = (payment) => {
            // Congratulation, it came here means everything's fine!
                    console.log("The payment was succeeded!", payment);
                    // You can bind the "payment" object's value to your state or props or whatever here, please see below for sample returned data
        }

        return (
            <div class="container">
                 <h2 className="text-center">Delivery Address</h2>
                 <br></br>

                 <div>
                    

                        <form id="contact-form" style={{width:"800px"}} >
                            <div class="row">
                                <div  class="col-sm">
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">Name</label>
                                        <input  className="form-control" placeholder="Enter Name" type="text" name="lastName"
                                                        value={this.state.gender} onChange={this.changeFullnameHandler} aria-describedby="emailHelp" />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="name">Mobile Number</label>
                                        <input placeholder="Enter Mobile Number" type="number" name="mobile" className="form-control" 
                                                        value={this.state.mobileNumber} onChange={this.changeMobileNumberHandler} aria-describedby="emailHelp"/>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">House Number</label>
                                        <input type="text" placeholder="Enter House Number" className="form-control" 
                                                        value={this.state.houseNumber} onChange={this.changeHouseNumberHandler} aria-describedby="emailHelp" />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">City</label>
                                        <input className="form-control"  placeholder="Enter City" type="text" name="city"  
                                                        value={this.state.city} onChange={this.changeCity} aria-describedby="emailHelp" ></input>
                                    </div>
                                </div>
                                <div class="col-sm">
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">State</label>
                                        <select name="state" className="form-control" placeholder="Enter State" type="text" 
                                                        value={this.state.state1} onChange={this.changeState} aria-describedby="emailHelp">
                                            <option value="Andhra Pradesh">Andhra Pradesh</option>
                                            <option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
                                            <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                                            <option value="Assam">Assam</option>
                                            <option value="Bihar">Bihar</option>
                                            <option value="Chandigarh">Chandigarh</option>
                                            <option value="Chhattisgarh">Chhattisgarh</option>
                                            <option value="Dadar and Nagar Haveli">Dadar and Nagar Haveli</option>
                                            <option value="Daman and Diu">Daman and Diu</option>
                                            <option value="Delhi">Delhi</option>
                                            <option value="Lakshadweep">Lakshadweep</option>
                                            <option value="Puducherry">Puducherry</option>
                                            <option value="Goa">Goa</option>
                                            <option value="Gujarat">Gujarat</option>
                                            <option value="Haryana">Haryana</option>
                                            <option value="Himachal Pradesh">Himachal Pradesh</option>
                                            <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                                            <option value="Jharkhand">Jharkhand</option>
                                            <option value="Karnataka">Karnataka</option>
                                            <option value="Kerala">Kerala</option>
                                            <option value="Madhya Pradesh">Madhya Pradesh</option>
                                            <option value="Maharashtra">Maharashtra</option>
                                            <option value="Manipur">Manipur</option>
                                            <option value="Meghalaya">Meghalaya</option>
                                            <option value="Mizoram">Mizoram</option>
                                            <option value="Nagaland">Nagaland</option>
                                            <option value="Odisha">Odisha</option>
                                            <option value="Punjab">Punjab</option>
                                            <option value="Rajasthan">Rajasthan</option>
                                            <option value="Sikkim">Sikkim</option>
                                            <option value="Tamil Nadu">Tamil Nadu</option>
                                            <option value="Telangana">Telangana</option>
                                            <option value="Tripura">Tripura</option>
                                            <option value="Uttar Pradesh">Uttar Pradesh</option>
                                            <option value="Uttarakhand">Uttarakhand</option>
                                            <option value="West Bengal">West Bengal</option>
                                        </select>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">Pincode</label>
                                        <input  className="form-control" placeholder="Enter Pincode" type="text" name="lastName"
                                                        value={this.state.pincode} onChange={this.changePincode} aria-describedby="emailHelp" />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">Full Address</label>
                                        <input  className="form-control"  placeholder="Enter Address" type="text" name="firstName"  
                                                        value={this.state.fulladdress} onChange={this.changeFulladdress} aria-describedby="emailHelp" />
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="exampleInputEmail1">Your Full Address is:</label><br/>
                                        <a>{this.state.fulladdress}</a>
                                    </div>
                                </div>
                                <div class="col-sm">
                                   

                                    <div>
                                        <label htmlFor="exampleInputEmail1">Confirm Payment</label><br/>
                                        <button type="submit" onClick={this.addAddress} className="btn btn-primary">Pay Cash on Delivery: ${this.state.cart.totalPrice}</button>
                                        
                                    </div><br/>
                                    
                                    <div>
                                    <label htmlFor="exampleInputEmail1">Or</label><br/>
                                    <PayPalButton
                                        createOrder={(data, actions) => this.createOrder(data, actions)}
                                        onApprove={(data, actions) => this.onApprove(data, actions)}
                                        onCancel={(data) => this.onCancel(data)}
                                    />

                                    </div>
                                    
                                </div>
                            </div>
                        </form>
                
                  </div>


            </div>
        )
    }
}

export default Address
