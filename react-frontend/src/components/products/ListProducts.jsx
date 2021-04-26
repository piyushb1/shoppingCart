import React, { Component } from 'react';
import {Link} from 'react-router-dom'
import ProductService from '../../services/ProductService';
import '../css/ListProducts.css'

class ListUsers extends Component {
    constructor(props) {
        super(props)

        this.state = {
            products: []
        }
      
        this.addProduct = this.addProduct.bind(this);
        this.deleteProduct = this.deleteProduct.bind(this);
        this.viewProduct = this.viewProduct.bind(this);
    }

    viewProduct(productid){
        this.props.history.push(`/product/${productid}`);
    }

    addProduct(){
        this.props.history.push(`/addproduct`);
    }

    deleteProduct(productid){
        ProductService.deleteProduct(productid);
        this.props.history.push(`/products`);
    }

    componentDidMount(){
        if(localStorage.role=="[admin]"){
			this.isAdmin=true;
		}else{
            this.props.history.push(`/`);
        }
		
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data});
        });
    }

  
    render() {
        return (
            <div>
                 <h2 className="text-center">Products</h2>
                 <div className = "row">
                    <button className="btn btn-primary"  href="/addproduct"> Add Product</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                <th> Product Name</th>
                                    <th> Product Name</th>
                                    <th> Price</th>
                                    <th style={{width: "300px"}}> Description</th>
                                    <th> Options</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.products.map(
                                        product => 
                                        <tr key = {product.productid}>
                                             <td> { product.productName} </td>   
                                             <td> { product.category} </td>   
                                             <td> {product.price}</td>
                                             <td> {product.description}</td>
                                             <td>
                                                 <button onClick={ () => this.editEmployee(product.productid)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteProduct(product.productid)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewProduct(product.productid)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

                   

            </div>
        )
    }
}

export default ListUsers
