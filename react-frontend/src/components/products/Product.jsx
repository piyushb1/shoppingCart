import React, { Component } from 'react'
import {Link} from 'react-router-dom'
import '../css/Details.css'
import ProductService from '../../services/ProductService';
import CartService from '../../services/CartService';

export class Product extends Component {
    constructor(props) {
        super(props)

        this.state = {
            productid: this.props.match.params.id,
                product:[]
        }
       
        this.addtoCart = this.addtoCart.bind(this);
    }


    componentDidMount(){
        ProductService.getProductById(this.state.productid).then((res) => {
            console.log('response => ' + JSON.stringify(this.state.productid));
            console.log('response => ' + JSON.stringify(res.data));
            this.setState({ product: res.data});
        });
    }

    addtoCart(productid){
        let userid = localStorage.userid;
        CartService.addToCart(userid,productid);
    }


    render() {
        let item = this.state.product;
        return (
            <>
                {/* {
                    product.map(item =>( */}
                        <div className="details" >
                            <img src="../images/1.png" alt=""/>
                            <div className="box">
                                <div className="row">
                                    <h2>{item.productName}</h2>
                                    <span>${item.price}</span>
                                </div>
                                {/* <Colors colors={item.colors}/> */}
                                <p>{item.description}</p>
                                <p></p>
                                <Link onClick={()=> this.addtoCart(item.productid)} className="cart" >
                                    Add to cart
                                </Link>
                            </div>
                        </div>
                    {/* ))
                } */}
            </>
        )
    }
}

export default Product