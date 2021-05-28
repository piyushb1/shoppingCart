import React from "react";
import ReactDOM from "react-dom"
import CartService from '../../services/CartService';

const PayPalButton = window.paypal.Buttons.driver("react", { React, ReactDOM });

class PayPal extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
           cart:[]
    }
  }

  componentDidMount(){
    CartService.getCartById(localStorage.userid).then((res) => {
        this.setState({ cart: res.data});
        this.setState({ item: this.state.cart.items });
        console.log('cart => ' + JSON.stringify(this.state.cart));
  
    });
  }

  createOrder(data, actions) {
        return actions.order.create({
          purchase_units: [
            {
              amount: {
                value: 0.1,
              },
            },
          ],
        });
    }
    
    onApprove(data, actions) {
        return actions.order.capture().then(function(details){
          console.log("Paid")
            console.log(details)
            this.props.history.push(`/myorders`);
        });
    }

    onCancel(data){
        this.props.history.push(`/cart`);
    }


  render() {
    return (
      <PayPalButton
        createOrder={(data, actions) => this.createOrder(data, actions)}
        onApprove={(data, actions) => this.onApprove(data, actions)}
        onCancel={(data) => this.onCancel(data)}
      />
    );
  }
}

export default PayPal