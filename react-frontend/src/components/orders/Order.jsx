import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import OrderService from '../../services/OrderService';
import '../css/DetailsC.css'
import '../css/Cart.css'

class Cart extends Component {
    constructor(props) {
        super(props)

        this.state = {
            num:0,
            order: [],
            address:[],
            item:[],
            orderid: this.props.match.params.id
            
        }       
        this.addtoCart = this.addtoCart.bind(this);
        this.placeOrder = this.placeOrder.bind(this);

    }

    componentDidMount(){
        OrderService.getOrderById(this.state.orderid).then((res) => {
            console.log('order => ' + JSON.stringify(res.data));
            this.setState({ order: res.data});
            this.setState({ item: this.state.order.items });
            this.setState({address: this.state.order.address});
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

    // componentWillUnmount() {
    //     alert('The component is going to be unmounted');
    // }

    render() {
            return (
                <div>               
                    <div style={{padding:"10px"}}>
                 <h2 className="text-center">Order of {this.state.order.orderDate}</h2>
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
                            <tbody>
                                {
                                    this.state.item.map(item =>(this.state.num++,
                                        <tr key = {item.productid}>
                                             <td> <img src={`images/${this.state.num}.png`} alt="" style={{width:"100px"}}/></td>
                                             <td> { item.productName} </td>   
                                             <td> ${item.price}</td>
                                             <td>
                                                <button className="count" onClick={()=> this.remove(item.productid)} style={{margin:"10px"}}> - </button>
                                                <span>{item.quantity}</span>
                                                <button className="count" onClick={()=> this.addtoCart(item.productid)} style={{margin:"10px"}}> + </button>
                                             </td>
                                        </tr>
                                    ))
                                }
                            </tbody>
                        </table>
                        <h4>To Address: ${this.state.address.fulladdress}</h4>
                        <h3>Total Amount: ${this.state.order.ammountPaid}</h3>
                    {/* <div className="total">
                        <Link to="/payment" onClick={()=> this.placeOrder()}>Confirm Order</Link>
                        <h3>Total: ${this.state.cart.totalPrice}</h3>
                    </div> */}



                    </div>

                )
            
        }
}

export default Cart;
