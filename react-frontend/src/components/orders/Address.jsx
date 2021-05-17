import React, { Component } from 'react'
import CartService from '../../services/CartService';
import OrderService from '../../services/OrderService';

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
                fulladdress:''
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


     
    addAddress = (e) => {

        e.preventDefault();
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
            modeOfPayment: " ",
            profileid: localStorage.userid,
        }

        console.log('order => ' + JSON.stringify(order));

        
        OrderService.placeOrder(order);

        this.props.history.push(`/myorders`);
            
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
        return (
            <div>
                 <h2 className="text-center">Delivery Address</h2>
                 <br></br>

                        <form id="contact-form" style={{width:"800px"}} >
                            <div>
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
                                <div className="form-group">
                                    <label htmlFor="exampleInputEmail1">State</label>
                                    <input className="form-control"  placeholder="Enter State" type="text" name="state"  
                                                    value={this.state.state1} onChange={this.changeState} aria-describedby="emailHelp" ></input>
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
                                <button type="submit" onClick={this.addAddress} className="btn btn-primary">Confirm Order</button>
                            </div>
                        </form>


            </div>
        )
    }
}

export default Address
