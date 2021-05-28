import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import OrderService from '../../services/OrderService';
import '../css/DetailsC.css'
import '../css/Cart.css'

class MyOrders extends Component {
    constructor(props) {
        super(props)

        this.state = {
            num:0,
            orders: []
        }       
        this.addtoCart = this.addtoCart.bind(this);
        this.viewOrder = this.viewOrder.bind(this);
        this.placeOrder = this.placeOrder.bind(this);

    }

    componentDidMount(){
        OrderService.getOrdersById(localStorage.userid).then((res) => {
            console.log('orders => ' + JSON.stringify(res.data));
            this.setState({ orders: res.data});
        });
    }

    addtoCart(productid){
        let userid = localStorage.userid;
        // CartService.addToCart(userid,productid);
    }

    placeOrder(){
        let cartid = this.state.cart.cartid;
        OrderService.placeOrder(cartid);
    }

    viewOrder(orderid){
        this.props.history.push(`/order/${orderid}`);
    }

    // componentWillUnmount() {
    //     alert('The component is going to be unmounted');
    // }

    render() {
            return (
                <div>               
                    <div style={{padding:"10px"}}>
                 <h2 className="text-center">My Orders</h2>
                 </div>
                 {
                        // this.state.item.map(item =>(this.state.num++,
                        //     <div className="details cart" key={item.productid}>
                        //         <img src={`images/${this.state.num}.png`} alt=""/>
                        //         <div className="box">
                        //             <div className="row">
                        //                 <h2>{item.productName}</h2>
                        //                 <span>${item.price}</span>
                        //             </div>
                        //             {/* <Colors colors={item.colors}/> */}
                        //             {/* <p>{item.description}</p> */}
                        //             <p>"Ddue"</p>
                        //             <div className="amount">
                        //                 <button className="count" > - </button>
                        //                 <span>{item.quantity}</span>
                        //                 <button className="count"> + </button>
                        //             </div>
                        //             <div className="delete">Remove</div>
                        //         </div>
                                
                        //     </div>
                        // ))
                    }
                   
                    <table className = "table table-striped table-bordered">
                             <thead>
                                <tr>
                                    <th>Order id</th>
                                    <th> Amount</th>
                                    <th> Date Ordered</th>
                                    <th> Delivery Status</th>
                                    <th> Payment Method</th>
                                    <th> Quantity</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.orders.map(item =>(this.state.num++,
                                        <tr key = {item.orderid}>
                                             {/* <td> <img src={`images/${this.state.num}.png`} alt="" style={{width:"100px"}}/></td> */}
                                             <td><Link onClick={ () => this.viewOrder(item.orderid)}> { item.orderid}</Link> </td>   
                                             <td> ${item.ammountPaid}</td>
                                             <td> { item.orderDate} </td>   
                                             <td> { item.orderStatus} </td>   
                                             <td> { item.modeOfPayment} </td>   
                                             <td> {item.quantity} </td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>

                    </div>

                )
            
        }
}

export default MyOrders;
